package study.memoravel.controller;


import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.memoravel.domain.User;
import study.memoravel.service.UserService;
import study.memoravel.util.JWT;

@RestController
@RequestMapping("/api/user")
@ResponseBody
public class UserApiController {
    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("checkMail")
    public Boolean checkMail(@RequestParam String mail) {
        return userService.checkMail(mail);
    }

    @GetMapping("checkPhone")
    public String checkPhone(@RequestParam String phoneNumber) {
        return userService.checkPhone(phoneNumber);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        try {
            return userService.login(user.getUserId(), user.getUserPassword());
        } catch (Exception e) {
            // TODO 없는 아이디에 대한 예외처리
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("join")
    public String join(@RequestBody User user) {
        return userService.join(user);
    }


    // for jwt parse test
    @GetMapping("jwt")
    public Integer jwt(@RequestParam("jwt") String jwt) {
        try {
            Claims claims = JWT.parseJWT(jwt);
            return claims.get("id", Integer.class);
        } catch (Exception e) {
            // TODO: jwt 만료에 대한 예외처리 -> 앱에서 만료 확인 후 재송신
            e.printStackTrace();
            return null;
        }
    }
}
