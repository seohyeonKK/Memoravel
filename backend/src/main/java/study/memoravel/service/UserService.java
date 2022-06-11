package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.controller.account.LoginRequest;
import study.memoravel.controller.account.SignupInfo;
import study.memoravel.controller.userInfo.UserInfo;
import study.memoravel.domain.UserEntity;
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

    public String login(LoginRequest login) throws Exception {
        UserInfo result = userRepo.findByEmail(login.getEmail());
        if (result == null) {
            throw new Exception("not exist email");
        }
        if (Encoding.checkBCrypt(login.getPassword(), result.getPassword())) {
            return JWT.create(result.getId(), result.getNickname());
        } else {
            throw new Exception("not matched password");
        }
    }

    public String signup(SignupInfo user) {
        // 유저 데이터 저장
        String saltValue = Encoding.getSalt();
        user.setPassword(Encoding.getBCrypt(user.getPassword(), saltValue));
        user.setSalt(saltValue);
        UserEntity userEntity = userRepo.save(user);
        // jwt 저장
        String jwt = JWT.create(userEntity.getId(), userEntity.getNickname());
        userRepo.updateJWT(userEntity.getId(), jwt);
        return jwt;
    }

    public UserInfo getUser(int id) {
        return userRepo.findById(id);
    }

    public void setUser(int id, UserInfo userInfo) {
        userRepo.updateUser(id, userInfo);
    }

    public Boolean checkPhoneNumber(String phoneNumber) {
        UserInfo result = userRepo.findByPhoneNumber(phoneNumber);
        return result == null;
    }

    public void setPhoneNumber(int id, String phoneNumber) {
        userRepo.updatePhoneNumber(id, phoneNumber);
    }

    public Boolean checkEmail(String mail) {
        UserInfo result = userRepo.findByEmail(mail);
        return result == null;
    }

    public Boolean checkNickname(String nickname) {
        UserInfo result = userRepo.findByNickname(nickname);
        return result == null;
    }
}
