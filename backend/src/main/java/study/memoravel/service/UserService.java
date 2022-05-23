package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.domain.Login;
import study.memoravel.domain.User;
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

    public String login(Login.DTO loginInfo) throws Exception {
        User.DTO result = userRepo.findByEmail(loginInfo.getEmail());
        if (result == null) {
            throw new Exception("Failed Login");
        }
        if (Encoding.checkBCrypt(loginInfo.getPassword(), result.getPassword())) {
            return JWT.create(result);
        } else {
            throw new Exception("Failed Login");
        }
    }

    public String signup(User.DTO user) {
        user.setPassword(Encoding.getBCrypt(user.getPassword()));
        userRepo.save(user);
        return JWT.create(user);
    }

    public User.DTO getUser(String email) {
        return userRepo.findByEmail(email);
    }

    public void setUser(String email, User.DTO user) {
        userRepo.updateUser(email, user);
    }

    public Boolean checkPhoneNumber(String phoneNumber) {
        User.DTO result = userRepo.findByPhoneNumber(phoneNumber);
        return result == null;
    }

    public void setPhoneNumber(String email, String phoneNumber) {
        userRepo.updatePhoneNumber(email, phoneNumber);
    }

    public Boolean checkEmail(String mail) {
        User.DTO result = userRepo.findByEmail(mail);
        return result == null;
    }
}
