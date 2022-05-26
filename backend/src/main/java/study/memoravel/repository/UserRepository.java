package study.memoravel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import study.memoravel.controller.account.SignupInfo;
import study.memoravel.controller.userInfo.UserInfo;
import study.memoravel.domain.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class UserRepository {
    private final EntityManager em;

    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public void save(SignupInfo signupInfo) {
//        em.createNativeQuery("insert into user (email, nickname, password, address, gender, photo_path) values (:email,:nickname,:password,:address,:gender,:photoPath)")
//                .setParameter("email", user.getEmail())
//                .setParameter("nickname", user.getNickname())
//                .setParameter("password", user.getPassword())
//                .setParameter("address", user.getAddress())
//                .setParameter("gender", user.getGender())
//                .setParameter("photoPath", user.getPhotoPath());
        UserEntity user = UserEntity.builder().email(signupInfo.getEmail())
                .password(signupInfo.getPassword())
                .address(signupInfo.getAddress())
                .nickname(signupInfo.getNickname())
                .gender(signupInfo.getGender()).build();

        em.persist(user);
    }

    public UserInfo findById(long id) {
        UserEntity userEntity = em.find(UserEntity.class, id);
        return new UserInfo(userEntity);
    }

    public UserInfo findByPhoneNumber(String phoneNumber) {
        try {
            UserEntity result = em.createQuery("select u from user as u where u.phoneNumber = :phoneNumber", UserEntity.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();

            return new UserInfo(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserInfo findByEmail(String email) {
        try {
            UserEntity result = em.createQuery("select user from user as user where user.email = :email", UserEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

            return new UserInfo(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public void updatePhoneNumber(String email, String phoneNumber) {
        em.createQuery("update user as u set u.phoneNumber = :phoneNumber where u.email = :email")
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("email", email)
                .executeUpdate();
    }

    public void updateUser(String email, UserInfo userInfo) {
        em.createQuery("update user as u set u.email = :newEmail, u.nickname = :nickname," +
                        " u.address = :address, u.gender = :gender , u.photoPath = :photoPath , u.phoneNumber = :phoneNumber , " +
                        "u.language = :language where u.email = :email")
                .setParameter("newEmail", userInfo.getEmail())
                .setParameter("nickname", userInfo.getNickname())
                .setParameter("address", userInfo.getAddress())
                .setParameter("gender", userInfo.getGender())
                .setParameter("photoPath", userInfo.getPhotoPath())
                .setParameter("phoneNumber", userInfo.getPhoneNumber())
                .setParameter("language", userInfo.getLanguage())
                .setParameter("email", email)
                .executeUpdate();
    }
}
