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

    public User.DTO findByEmail(String email) {
        List<User.DAO> result = em.createQuery("select user from user as user where user.email = :email", User.DAO.class)
                .setParameter("email", email)
                .getResultList();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0).toDTO();
    }

    public void updatePhoneNumber(String email, String phoneNumber) {
        em.createQuery("update user as u set u.phoneNumber = :phoneNumber where u.email = :email")
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("email", email)
                .executeUpdate();
    }

    public void updateUser(String email, User.DTO user) {
        em.createQuery("update user as u set u.email = :newEmail, u.nickname = :nickname," +
                        " u.address = :address, u.gender = :gender , u.photoPath = :photoPath , u.phoneNumber = :phoneNumber , " +
                        "u.language = :language where u.email = :email")
                .setParameter("newEmail", user.getEmail())
                .setParameter("nickname", user.getNickname())
                .setParameter("address", user.getAddress())
                .setParameter("gender", user.getGender())
                .setParameter("photoPath", user.getPhotoPath())
                .setParameter("phoneNumber", user.getPhoneNumber())
                .setParameter("language", user.getLanguage())
                .setParameter("email", email)
                .executeUpdate();
    }

    public void updateLanguage(String email, String newLanguage) {
        em.createQuery("update user as u set u.language = :language where u.email = :email")
                .setParameter("language", newLanguage)
                .setParameter("email", email)
                .executeUpdate();
    }
}
