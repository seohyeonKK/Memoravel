package study.memoravel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import study.memoravel.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;


public class UserRepository {
    private final EntityManager em;

    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public void save(User.DTO user) {
//        em.createNativeQuery("insert into user (email, nickname, password, address, gender, photo_path) values (:email,:nickname,:password,:address,:gender,:photoPath)")
//                .setParameter("email", user.getEmail())
//                .setParameter("nickname", user.getNickname())
//                .setParameter("password", user.getPassword())
//                .setParameter("address", user.getAddress())
//                .setParameter("gender", user.getGender())
//                .setParameter("photoPath", user.getPhotoPath());

        em.persist(user.toDAO());
    }

    public User.DTO findById(long id) {
        return em.find(User.DAO.class, id).toDTO();
    }

    public User.DTO findByPhoneNumber(String phoneNumber) {
        try {
            User.DAO result = em.createQuery("select u from user as u where u.phoneNumber = :phoneNumber", User.DAO.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();
            return result.toDTO();
        } catch (NoResultException e) {
            return null;
        }
    }

    public User.DTO findByEmail(String mail) {
        List<User.DAO> result = em.createQuery("select user from user as user where user.email = :mail", User.DAO.class)
                .setParameter("mail", mail)
                .getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0).toDTO();
    }
}
