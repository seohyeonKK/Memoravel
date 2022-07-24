package study.memoravel.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.memoravel.controller.dto.SignInRequest;
import study.memoravel.controller.dto.SignUpRequest;
import study.memoravel.dto.SignInInfo;
import study.memoravel.dto.SignUpInfo;
import study.memoravel.exception.member.EmailDuplicateException;
import study.memoravel.service.MailService;
import study.memoravel.service.MemberService;

@RestController
@RequestMapping("/api/account")
@ResponseBody
@RequiredArgsConstructor
public class AccountController {
    private final MemberService memberService;
    private final MailService mailService;

    @GetMapping("email/{email}/authentication")
    @ApiOperation(value = "이메일 인증", notes = "이미 가입된 유저의 이메일과 같은 이메일인지 확인하고 같은 이메일이 없다면, 인증번호을 반환한다.")
    public String getEmailAuthentication(@ApiParam(value = "이메일", required = true) @PathVariable("email") String email) {
        if (memberService.checkEmail(email)) {
            return mailService.sendCheckMail(email);
        } else {
            throw new EmailDuplicateException();
        }
    }

    @GetMapping("nickname/{nickname}/check")
    @ApiOperation(value = "닉네임 중복 확인", notes = "이미 가입된 유저의 닉네임과 같은 닉네임인지 확인한다. 중복이면 false 반환")
    public Boolean getNicknameCheck(@ApiParam(value = "닉네임", required = true) @PathVariable("nickname") String nickname) {
        return memberService.checkNickname(nickname);
    }

    @PostMapping("signup")
    @ApiOperation(value = "가입", notes = "가입 할 유저의 정보를 저장하고, JWT 를 반환한다.")
    public String signup(@RequestBody SignUpRequest signUpRequest) {
        SignUpInfo signUpInfo = new SignUpInfo(signUpRequest);
        return memberService.signUp(signUpInfo);
    }

    @PostMapping(value = "signin")
    @ApiOperation(value = "로그인", notes = "로그인 할 유저의 아이디와 비밀번호의 일치를 확인하고, 일치한다면 JWT 를 발급한다.")
    public String login(@ApiParam(value = "유저의 아이디(id)와 비밀번호(password)", required = true) @RequestBody SignInRequest signInRequest) {
        SignInInfo signInInfo = new SignInInfo(signInRequest);
        return memberService.signIn(signInInfo);
    }
}
