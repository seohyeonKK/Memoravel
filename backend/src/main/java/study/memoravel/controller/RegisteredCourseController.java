package study.memoravel.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.memoravel.annotation.Auth;
import study.memoravel.aop.MemberContext;
import study.memoravel.controller.dto.RegisterCourseRequest;
import study.memoravel.controller.dto.RegisteredCourseInfoResponse;
import study.memoravel.dto.RegisteredCourseInfo;
import study.memoravel.service.RegisteredCourseService;

@RestController
@RequestMapping("/api/register-course/")
@ResponseBody
@RequiredArgsConstructor
public class RegisteredCourseController {
    private final RegisteredCourseService registeredCourseService;

    @Auth
    @PostMapping("")
    @ApiOperation(value = "코스 등록", notes = "헤더의 JWT 에 해당하는 유저가 코스를 등록한다.")
    public void registerCourse(@RequestBody RegisterCourseRequest registerCourseRequest) {
        long memberId = MemberContext.getCurrentMemberId();
        RegisteredCourseInfo registeredCourseInfo = new RegisteredCourseInfo(registerCourseRequest, memberId);
        registeredCourseService.registerCourse(registeredCourseInfo);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "등록된 코스 정보 반환")
    public RegisteredCourseInfoResponse getRegisteredCourseInfo(@ApiParam(value = "등록된 코스 id", required = true) @PathVariable("id") int courseId) {
        RegisteredCourseInfo registeredCourseInfo = registeredCourseService.getCourseInfo(courseId);
        return new RegisteredCourseInfoResponse(registeredCourseInfo);
    }
}
