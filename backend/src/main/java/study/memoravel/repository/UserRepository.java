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

    public UserEntity save(SignupInfo signupInfo) {
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
                .gender(signupInfo.getGender())
                .salt("asdf")
                .jwt("asdfsadF")
                .build();
        em.persist(user);
        return user;
    }

    public void updateJWT(int id, String jwt) {
        em.createQuery("update user as u set u.jwt = :jwt where u.id = :id")
                .setParameter("jwt", jwt)
                .setParameter("id", id)
                .executeUpdate();
    }

    public UserInfo findById(int id) {
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

    public UserInfo findByNickname(String nickname) {
        try {
            UserEntity result = em.createQuery("select user from user as user where user.nickname = :nickname", UserEntity.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();

            return new UserInfo(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public void updatePhoneNumber(int id, String phoneNumber) {
        em.createQuery("update user as u set u.phoneNumber = :phoneNumber where u.id = :id")
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("id", id)
                .executeUpdate();
    }

    public void updateUser(int id, UserInfo userInfo) {
        em.createQuery("update user as u set u.email = :newEmail, u.nickname = :nickname," +
                        " u.address = :address, u.gender = :gender , u.photoPath = :photoPath , u.phoneNumber = :phoneNumber , " +
                        "u.language = :language where u.id = :id")
                .setParameter("newEmail", userInfo.getEmail())
                .setParameter("nickname", userInfo.getNickname())
                .setParameter("address", userInfo.getAddress())
                .setParameter("gender", userInfo.getGender())
                .setParameter("photoPath", userInfo.getPhotoPath())
                .setParameter("phoneNumber", userInfo.getPhoneNumber())
                .setParameter("language", userInfo.getLanguage())
                .setParameter("id", id)
                .executeUpdate();
    }

    public void updateLanguage(int id, String newLanguage) {
        em.createQuery("update user as u set u.language = :language where u.id = :id")
                .setParameter("language", newLanguage)
                .setParameter("id", id)
                .executeUpdate();
    }
}
