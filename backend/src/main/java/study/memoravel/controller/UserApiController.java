package study.memoravel.controller;


import io.jsonwebtoken.Claims;
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
        if (userService.checkEmail(email)) {
            String randomNumber = mailService.sendCheckMail(email);
            return Response.builder().code(200).result(randomNumber).message("success email authentication").build();
        } else {
            return Response.builder().code(500).result(null).message("failed email authentication\n already using email").build();
        }
    }


    @PostMapping("signup")
    @ApiOperation(value = "가입", notes = "가입 할 유저의 정보를 저장하고, JWT 를 반환한다.")
    public Response Signup(@RequestBody User.DTO user) {
        try {
            String jwt = userService.Signup(user);
            return Response.builder().code(200).result(jwt).message("success signup").build();
        } catch (Exception e) {
            e.printStackTrace();
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

    // TODO JWT Token Refresh
    @GetMapping("jwt")
    @ApiOperation(value = "백엔드 테스트용 API", notes = "백엔드 테스트용 API")
    public Integer jwt(@RequestParam("jwt") String jwt) {
        try {
            Claims claims = JWT.parseJWT(jwt);
            return claims.get("id", Integer.class);
        } catch (Exception e) {
            // TODO: jwt 만료에 대한 예외처리 -> 앱에서 만료 확인 후 재송신
            // TODO 삭제
            e.printStackTrace();
            return null;
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
                return Response.builder().code(500).result(e).message("faild phone number authentication\n cool sms error").build();
            }
        } else {
            return Response.builder().code(500).result(null).message("failed phone number authentication\n already using phone number").build();
        }
    }

    @PutMapping("phone-number")
    @ApiOperation(value = "핸드폰 번호 저장", notes = "핸드폰 번호 인증 이후 유저의 핸드폰 번호를 저장한다.")
    public Response setPhoneNumber(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestParam String phoneNumber, @RequestHeader Map<String, Object> header) {
        String jwt = (String) header.get("authorization");
        try {
            Claims claims = JWT.parseJWT(jwt);
            String email = (String) claims.get("email");
            userService.setPhoneNumber(email, phoneNumber);

            return Response.builder().code(200).result(phoneNumber).message("success set phone number").build();
        } catch (ExpiredJwtException e) {
            return Response.builder().code(500).result(e).message("asdfasdf").build();
        }
    }
}
