package study.memoravel.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.memoravel.annotation.Auth;
import study.memoravel.aop.MemberContext;
import study.memoravel.controller.dto.MemberInfoResponse;
import study.memoravel.controller.dto.UpdateMemberInfoRequest;
import study.memoravel.controller.dto.UpdatePhoneNumberRequest;
import study.memoravel.dto.MemberInfo;
import study.memoravel.exception.member.PhoneNumberDuplicateException;
import study.memoravel.service.MemberService;
import study.memoravel.service.SMSService;

@RestController
@RequestMapping("/api/member/info")
@ResponseBody
@RequiredArgsConstructor
public class MemberInfoController {
    private final MemberService memberService;
    private final SMSService smsService;

    @GetMapping("phone-number/{phoneNumber}/authentication")
    @ApiOperation(value = "핸드폰 번호 인증", notes = "이미 가입된 유저의 핸드폰 번호와 같은 번호인지 확인하고 같은 번호가 없다면, 인증번호를 반환한다.")
    public String getPhoneAuthentication(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @PathVariable("phoneNumber") String phoneNumber) {
        if (memberService.checkPhoneNumber(phoneNumber)) {
            return smsService.sendMessage(phoneNumber);
        } else {
            throw new PhoneNumberDuplicateException();
        }
    }

    @Auth
    @PutMapping("phone-number")
    @ApiOperation(value = "핸드폰 번호 저장", notes = "헤더의 JWT 에 해당하는 유저의 핸드폰 번호를 저장한다.")
    public void putPhoneNumber(@ApiParam(value = "핸드폰 번호(String,\"-\"제외하고)", required = true) @RequestBody UpdatePhoneNumberRequest updatePhoneNumberRequestDto) {
        long id = MemberContext.getCurrentMemberId();
        memberService.setPhoneNumber(id, updatePhoneNumberRequestDto.getPhoneNumber());
    }

    @Auth
    @GetMapping("")
    @ApiOperation(value = "유저 정보 반환", notes = "헤더의 JWT 에 해당하는 유저 정보를 반환한다.")
    public MemberInfoResponse getUserInfo() {
        long id = MemberContext.getCurrentMemberId();
        MemberInfo memberInfo = memberService.getMemberInfo(id);
        return new MemberInfoResponse(memberInfo);
    }

    @Auth
    @PostMapping("")
    @ApiOperation(value = "유저 정보 수정", notes = "헤더의 JWT 에 해당하는 유저 정보를 전송한 유저 정보로 수정한다.")
    public void postUserInfo(@RequestBody UpdateMemberInfoRequest updateUserInfoRequest) {
        long id = MemberContext.getCurrentMemberId();
        MemberInfo userInfo = new MemberInfo(updateUserInfoRequest, id);
        memberService.updateMemberInfo(userInfo);
    }
}
