package study.memoravel.controller;


import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.memoravel.domain.Login;
import study.memoravel.domain.Response;
import study.memoravel.domain.User;
import study.memoravel.service.MailService;
import study.memoravel.service.SMSService;
import study.memoravel.service.UserService;
import study.memoravel.util.JWT;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@ResponseBody
public class UserApiController {
    private final UserService userService;
    private final MailService mailService;
    private final SMSService smsService;

    @Autowired
    public UserApiController(UserService userService, MailService mailService, SMSService smsService) {
        this.userService = userService;
        this.mailService = mailService;
        this.smsService = smsService;
    }

    @GetMapping("email-authentication")
    @ApiOperation(value = "이메일 인증", notes = "이미 가입된 유저의 이메일과 같은 이메일인지 확인하고 같은 이메일이 없다면, 인증번호을 반환한다.")
    public Response getEmailAuthentication(@ApiParam(value = "이메일", required = true) @RequestParam String email) {
        try {
            if (userService.checkEmail(email)) {
                String randomNumber = mailService.sendCheckMail(email);
                return Response.builder().code(200).result(randomNumber).message("success email authentication").build();
            } else {
                return Response.builder().code(500).result(email).message("failed email authentication\n already using email").build();
            }
        } catch (NoSuchAlgorithmException e) {
            return Response.builder().code(500).result(e).message("failed email authentication\n MD5 algorithm is error").build();
        }
    }


    @PostMapping("signup")
    @ApiOperation(value = "가입", notes = "가입 할 유저의 정보를 저장하고, JWT 를 반환한다.")
    public Response signup(@RequestBody User.DTO user) {
        try {
            String jwt = userService.signup(user);
            return Response.builder().code(200).result(jwt).message("success signup").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed signup").build();
        }
    }

    @PostMapping(value = "login")
    @ApiOperation(value = "로그인", notes = "로그인 할 유저의 아이디와 비밀번호의 일치를 확인하고, 일치한다면 JWT 를 발급한다.")
    public Response login(@ApiParam(value = "유저의 아이디(id)와 비밀번호(password)", required = true) @RequestBody Login.DTO loginInfo) {
        try {
            String jwt = userService.login(loginInfo);
            return Response.builder().code(200).result(jwt).message("success login").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.builder().code(500).result(e).message("failed login").build();
        }
    }

    @GetMapping("refresh-token")
    @ApiOperation(value = "JWT token 재발행", notes = "JWT 를 확인하여 만료기간을 갱신 후 반환한다.")
    public Response getRefreshToken(@RequestHeader Map<String, Object> header) {
        try {
            String email = JWT.getEmailFromJWT((String) (header.get("authorization")));
            User.DTO user = userService.getUser(email);
            String newJwt = JWT.create(user);
            return Response.builder().code(200).result(newJwt).message("success refresh token").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed refresh token").build();
        }
    }

    @GetMapping("phone-number-authentication")
    @ApiOperation(value = "핸드폰 번호 인증", notes = "이미 가입된 유저의 핸드폰 번호와 같은 번호인지 확인하고 같은 번호가 없다면, 인증번호를 반환한다.")
    public Response getPhoneAuthentication(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestParam String phoneNumber) {
        if (userService.checkPhoneNumber(phoneNumber)) {
            String randomNumber = null;
            try {
                randomNumber = smsService.sendMessage(phoneNumber);
                return Response.builder().code(200).result(randomNumber).message("success phone number authentication").build();
            } catch (CoolsmsException e) {
                return Response.builder().code(500).result(e).message("failed phone number authentication\n cool sms error").build();
            }
        } else {
            return Response.builder().code(500).result(null).message("failed phone number authentication\n already using phone number").build();
        }
    }

    @PutMapping("phone-number")
    @ApiOperation(value = "핸드폰 번호 저장", notes = "핸드폰 번호 인증 이후 유저의 핸드폰 번호를 저장한다.")
    public Response putPhoneNumber(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestParam String phoneNumber, @RequestHeader Map<String, Object> header) {
        try {
            String email = JWT.getEmailFromJWT((String) (header.get("authorization")));
            userService.setPhoneNumber(email, phoneNumber);
            return Response.builder().code(200).result(phoneNumber).message("success set phone number").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed set phone number").build();
        }
    }

    @GetMapping("info")
    @ApiOperation(value = "유저 정보 반환", notes = "헤더의 JWT 에 해당하는 유저 정보를 반환한다.")
    public Response getUserInfo(@RequestHeader Map<String, Object> header) {
        try {
            String email = JWT.getEmailFromJWT((String) (header.get("authorization")));
            User.DTO user = userService.getUser(email);
            return Response.builder().code(200).result(user).message("success get user info").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed get user info \n token is expired").build();
        }
    }

    @PostMapping("info")
    @ApiOperation(value = "유저 정보 수정", notes = "헤더의 JWT 에 해당하는 유저 정보를 전송한 유저 정보로 수정한다.")
    public Response postUserInfo(@RequestHeader Map<String, Object> header, @RequestBody User.DTO user) {
        try {
            String email = JWT.getEmailFromJWT((String) (header.get("authorization")));
            userService.setUser(email, user);
            return Response.builder().code(200).result(user).message("success get user info").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("failed get user info \n token is expired").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed get user info").build();
        }
    }

}
