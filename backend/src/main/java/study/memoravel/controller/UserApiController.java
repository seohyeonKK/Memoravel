package study.memoravel.controller;


import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.memoravel.domain.DTO.loginDTO;
import study.memoravel.domain.User;
import study.memoravel.service.MailService;
import study.memoravel.service.SMSService;
import study.memoravel.service.UserService;
import study.memoravel.util.JWT;

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

    @GetMapping("checkMail")
    @ApiOperation(value = "이메일 중복 확인", notes = "이미 가입된 유저의 이메일과 같은 이메일인지 확인하고 같은 이메일이 없다면, 인증번호을 반환한다.")
    public String checkMail(@ApiParam(value = "이메일", required = true) @RequestParam String mail) {
        String randomNumber = null;
        if (userService.checkMail(mail)) {
            randomNumber = mailService.sendCheckMail(mail);
        }
        return randomNumber;
    }

    @GetMapping("checkPhone")
    @ApiOperation(value = "핸드폰 번호 중복 확인", notes = "이미 가입된 유저의 핸드폰 번호와 같은 번호인지 확인하고 같은 번호가 없다면, 인증번호를 반환한다.")
    public String checkPhone(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestParam String phoneNumber) {
        String randomNumber = null;
        if (userService.checkPhone(phoneNumber)) {
            try {
                randomNumber = smsService.sendMessage(phoneNumber);
            } catch (CoolsmsException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println(e.getCode());
            }
        }
        return randomNumber;
    }

    @PostMapping(value = "login")
    @ApiOperation(value = "로그인", notes = "로그인 할 유저의 아이디와 비밀번호의 일치를 확인하고, 일치한다면 JWT를 반환한다.")
    public String login(@ApiParam(value = "유저의 아이디(userId)와 비밀번호(userPassword)", required = true) @RequestBody loginDTO loginDTO) {
        try {
            return userService.login(loginDTO.getUserId(), loginDTO.getUserPassword());
        } catch (Exception e) {
            // TODO 없는 아이디에 대한 예외처리
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("join")
    @ApiOperation(value = "가입", notes = "가입 할 유저의 정보를 저장하고, JWT를 반환한다.")
    public String join(@RequestBody User user) {
        return userService.join(user);
    }


    // for jwt parse test
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
}
