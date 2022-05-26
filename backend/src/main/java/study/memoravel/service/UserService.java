package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.controller.account.LoginInfo;
import study.memoravel.controller.account.SignupInfo;
import study.memoravel.controller.userInfo.UserInfo;
import study.memoravel.repository.UserRepository;
import study.memoravel.util.Encoding;
import study.memoravel.util.JWT;

@Transactional
public class UserService {
    private static UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        UserService.userRepo = userRepo;
    }

    public String login(LoginInfo login) throws Exception {
        UserInfo result = userRepo.findByEmail(login.getEmail());
        if (result == null) {
            throw new Exception("Failed Login");
        }
        if (Encoding.checkBCrypt(login.getPassword(), result.getPassword())) {
            return JWT.create(result.getNickname(), result.getEmail());
        } else {
            throw new Exception("Failed Login");
        }
    }

    public String signup(SignupInfo user) {
        user.setPassword(Encoding.getBCrypt(user.getPassword()));
        userRepo.save(user);
        return JWT.create(user.getNickname(), user.getEmail());
    }

    public UserInfo getUser(String email) {
        return userRepo.findByEmail(email);
    }

    public void setUser(String email, UserInfo userInfo) {
        userRepo.updateUser(email, userInfo);
    }

    public Boolean checkPhoneNumber(String phoneNumber) {
        UserInfo result = userRepo.findByPhoneNumber(phoneNumber);
        return result == null;
    }

    public void setPhoneNumber(String email, String phoneNumber) {
        userRepo.updatePhoneNumber(email, phoneNumber);
    }

    public Boolean checkEmail(String mail) {
        UserInfo result = userRepo.findByEmail(mail);
        return result == null;
    }
}
