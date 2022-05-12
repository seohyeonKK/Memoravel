package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.domain.Login;
import study.memoravel.domain.User;
import study.memoravel.repository.UserRepository;
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
        if (result != null && result.getPassword().equals(loginInfo.getPassword())) {
            return JWT.createJWT(result);
        } else {
            throw new Exception("Failed Login");
        }
    }

    public String Signup(User.DTO user) {
        userRepo.save(user);
        return JWT.createJWT(user);
    }

    public Boolean checkPhone(String phoneNumber) {
        User.DTO result = userRepo.findByPhoneNumber(phoneNumber);
        return result == null;
    }

    public Boolean checkMail(String mail) {
        User.DTO result = userRepo.findByEmail(mail);
        return result == null;
    }
}
