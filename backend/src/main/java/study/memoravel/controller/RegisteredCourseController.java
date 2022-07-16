package study.memoravel.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.memoravel.annotation.Auth;
import study.memoravel.aop.MemberContext;
import study.memoravel.controller.dto.RegisterCourseRequest;
import study.memoravel.service.MemberService;

@RestController
@RequestMapping("/api/register-course/")
@ResponseBody
@RequiredArgsConstructor
public class RegisteredCourseController {
    private final MemberService memberService;

    @Auth
    @PostMapping("")
    @ApiOperation(value = "코스 등록", notes = "헤더의 JWT 에 해당하는 유저가 코스를 등록한다.")
    public void registerCourse(@RequestBody RegisterCourseRequest registerCourseRequest) {
        long id = MemberContext.getCurrentMemberId();

    }
}
