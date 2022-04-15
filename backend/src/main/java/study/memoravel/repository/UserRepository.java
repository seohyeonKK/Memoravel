package study.memoravel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import study.memoravel.domain.User;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserRepository {
    private final EntityManager em;

    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);

        return user;
    }

    public List<User> findAll() {
        return em.createQuery("select user from User as user", User.class).getResultList();
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
}
