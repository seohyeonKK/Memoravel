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

    @GetMapping("jwt")
    public Integer jwt(@RequestParam("jwt") String jwt) {
        Claims claims = JWT.parseJWT(jwt);
        return claims.get("id", Integer.class);
    }
}
