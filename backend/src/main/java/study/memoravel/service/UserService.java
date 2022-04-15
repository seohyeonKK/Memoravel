package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    public String login(String userId, String userPassword) throws Exception {
        User result = userRepo.findByUserId(userId);
        if (result == null) {
            throw new Exception("존재하지 않는 ID");
        }
        if (result.getUserPassword().equals(userPassword)) {

            return JWT.createJWT(result);
        }
        return null;
    }

    public String join(User user) {
        userRepo.save(user);
        return JWT.createJWT(user);
    }
}
