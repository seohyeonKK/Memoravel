package study.memoravel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import study.memoravel.domain.User;

import javax.persistence.EntityManager;
import java.util.List;


public class UserRepository {
    private final EntityManager em;

    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.persist(user);
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public User findByUserId(String userId) {
        List<User> result = em.createQuery("select user from User as user where user.userId = :userId", User.class)
                .setParameter("userId", userId)
                .getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }

    public User findByPhoneNumber(String phoneNumber) {
        List<User> result = em.createQuery("select user from User as user where user.phoneNum = :phoneNumber", User.class)
                .setParameter("phoneNumber", phoneNumber)
                .getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }

    public User findByEmail(String mail) {
        List<User> result = em.createQuery("select user from User as user where user.email = :mail", User.class)
                .setParameter("mail", mail)
                .getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
