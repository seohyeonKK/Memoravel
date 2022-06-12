package study.memoravel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.dto.MemberInfoDto;
import study.memoravel.dto.SignInInfoDto;
import study.memoravel.dto.SignUpInfoDto;
import study.memoravel.exception.FailedSignUpException;
import study.memoravel.repository.MemberRepository;
import study.memoravel.util.Encoding;
import study.memoravel.util.JWT;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public String signIn(SignInInfoDto signInInfo) {
        MemberInfoDto MemberInfo = memberRepository.findByEmail(signInInfo.getEmail());
        if (MemberInfo == null) {
            throw new FailedSignUpException();
        }
        if (Encoding.checkBCrypt(signInInfo.getPassword(), MemberInfo.getPassword())) {
            return JWT.create(MemberInfo.getId(), MemberInfo.getNickname());
        } else {
            throw new FailedSignUpException();
        }
    }

    public String signUp(SignUpInfoDto signUpInfo) {
        // 유저 데이터 저장
        String salt = Encoding.getSalt();
        String newPassword = Encoding.getBCrypt(signUpInfo.getPassword(), salt);
        signUpInfo = new SignUpInfoDto(signUpInfo, newPassword);
        int id = memberRepository.save(signUpInfo, salt);
        // jwt 저장
        String jwt = JWT.create(id, signUpInfo.getNickname());
        memberRepository.updateJWT(id, jwt);
        return jwt;
    }

    public MemberInfoDto getMemberInfo(int id) {
        return memberRepository.findById(id);
    }

    public void updateMemberInfo(MemberInfoDto memberInfo) {
        memberRepository.updateMemberInfo(memberInfo);
    }

    public Boolean checkPhoneNumber(String phoneNumber) {
        MemberInfoDto result = memberRepository.findByPhoneNumber(phoneNumber);
        return result == null;
    }

    public void setPhoneNumber(int id, String phoneNumber) {
        memberRepository.updatePhoneNumber(id, phoneNumber);
    }

    public Boolean checkEmail(String mail) {
        MemberInfoDto result = memberRepository.findByEmail(mail);
        return result == null;
    }

    public Boolean checkNickname(String nickname) {
        MemberInfoDto result = memberRepository.findByNickname(nickname);
        return result == null;
    }
}
