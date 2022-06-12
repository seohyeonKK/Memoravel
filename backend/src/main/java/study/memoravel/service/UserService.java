package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.dto.SignInInfoDto;
import study.memoravel.dto.SignUpInfoDto;
import study.memoravel.dto.UserInfoDto;
import study.memoravel.exception.FailedSignUpException;
import study.memoravel.repository.UserRepository;
import study.memoravel.util.Encoding;
import study.memoravel.util.JWT;

@Transactional
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public String signIn(SignInInfoDto signInInfo) {
        UserInfoDto userInfo = userRepo.findByEmail(signInInfo.getEmail());
        if (userInfo == null) {
            throw new FailedSignUpException();
        }
        if (Encoding.checkBCrypt(signInInfo.getPassword(), userInfo.getPassword())) {
            return JWT.create(userInfo.getId(), userInfo.getNickname());
        } else {
            throw new FailedSignUpException();
        }
    }

    public String signUp(SignUpInfoDto signUpInfo) {
        // 유저 데이터 저장
        String salt = Encoding.getSalt();
        String newPassword = Encoding.getBCrypt(signUpInfo.getPassword(), salt);
        signUpInfo = new SignUpInfoDto(signUpInfo, newPassword);
        int userId = userRepo.save(signUpInfo, salt);
        // jwt 저장
        String jwt = JWT.create(userId, signUpInfo.getNickname());
        userRepo.updateJWT(userId, jwt);
        return jwt;
    }

    public UserInfoDto getUserInfo(int id) {
        return userRepo.findById(id);
    }

    public void updateUserInfo(UserInfoDto userInfo) {
        userRepo.updateUser(userInfo);
    }

    public Boolean checkPhoneNumber(String phoneNumber) {
        UserInfoDto result = userRepo.findByPhoneNumber(phoneNumber);
        return result == null;
    }

    public void setPhoneNumber(int id, String phoneNumber) {
        userRepo.updatePhoneNumber(id, phoneNumber);
    }

    public Boolean checkEmail(String mail) {
        UserInfoDto result = userRepo.findByEmail(mail);
        return result == null;
    }

    public Boolean checkNickname(String nickname) {
        UserInfoDto result = userRepo.findByNickname(nickname);
        return result == null;
    }
}
