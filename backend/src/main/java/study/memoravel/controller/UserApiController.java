package study.memoravel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.memoravel.domain.User;
import study.memoravel.service.UserService;

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
    public Boolean login(@RequestBody User user) {
        try {
            return userService.login(user.getUserId(), user.getUserPassword());
        } catch (Exception e) {
            // TODO 없는 아이디에 대한 예외처리
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("join")
    public String join(@RequestBody User user) {

    }
}
