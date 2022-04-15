package study.memoravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.domain.User;
import study.memoravel.repository.UserRepository;

@Transactional
@Service
public class UserService {
    private static UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        UserService.userRepo = userRepo;
    }

    public Boolean login(String userId, String userPassword) throws Exception {
        User result = userRepo.findByUserId(userId);
        if (result == null) {
            throw new Exception("존재하지 않는 ID");
        }
        return result.getUserPassword().equals(userPassword);
    }

    public String join(User user) {
        userRepo.save(user);
    }

    private String generateToken(User user) {
        return "12335432165[Token]12332541254";
    }
}
