package study.memoravel.controller.account;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.memoravel.controller.userInfo.UserInfo;
import study.memoravel.domain.Response;
import study.memoravel.service.MailService;
import study.memoravel.service.UserService;
import study.memoravel.util.JWT;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
@ResponseBody
public class AccountApiController {
    private final UserService userService;
    private final MailService mailService;

    @Autowired
    public AccountApiController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
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

    @GetMapping("nickname-check")
    @ApiOperation(value = "닉네임 중복 확인", notes = "이미 가입된 유저의 닉네임과 같은 닉네임인지 확인한다. 중복이면 false 반환")
    public Response getNicknameCheck(@ApiParam(value = "닉네임", required = true) @RequestParam String nickname) {
        try {
            if (userService.checkNickname(nickname)) {
                return Response.builder().code(200).result(true).message("success nickname check").build();
            } else {
                return Response.builder().code(200).result(false).message("success nickname check").build();
            }
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed nickname check").build();
        }
    }

    @PostMapping("signup")
    @ApiOperation(value = "가입", notes = "가입 할 유저의 정보를 저장하고, JWT 를 반환한다.")
    public Response signup(@RequestBody SignupInfo user) {
        try {
            String jwt = userService.signup(user);
            return Response.builder().code(200).result(jwt).message("success signup").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed signup").build();
        }
    }

    @PostMapping(value = "login")
    @ApiOperation(value = "로그인", notes = "로그인 할 유저의 아이디와 비밀번호의 일치를 확인하고, 일치한다면 JWT 를 발급한다.")
    public Response login(@ApiParam(value = "유저의 아이디(id)와 비밀번호(password)", required = true) @RequestBody LoginInfo loginInfo) {
        try {
            String jwt = userService.login(loginInfo);
            return Response.builder().code(200).result(jwt).message("success login").build();
        } catch (Exception e) {
            if (e.getMessage().equals("not matched password") || e.getMessage().equals("not exist email")) {
                return Response.builder().code(500).result(null).message("failed login").build();
            }
            e.printStackTrace();
            return Response.builder().code(500).result(e).message("failed login").build();
        }
    }

    @GetMapping("refresh-token")
    @ApiOperation(value = "JWT token 재발행", notes = "JWT 를 확인하여 만료기간을 갱신 후 반환한다.")
    public Response getRefreshToken(@RequestHeader Map<String, Object> header) {
        try {
            int id = JWT.getIdFromJWT((String) (header.get("authorization")));
            UserInfo userInfo = userService.getUser(id);
            String newJwt = JWT.create(userInfo.getId(), userInfo.getNickname());
            return Response.builder().code(200).result(newJwt).message("success refresh token").build();
        } catch (Exception e) {
            return Response.builder().code(500).result(e).message("failed refresh token").build();
        }
    }
}
