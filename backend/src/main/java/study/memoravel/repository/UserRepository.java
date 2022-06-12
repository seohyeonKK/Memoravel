package study.memoravel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import study.memoravel.domain.UserEntity;
import study.memoravel.dto.SignUpInfoDto;
import study.memoravel.dto.UserInfoDto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class UserRepository {
    private final EntityManager em;

    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public int save(SignUpInfoDto signUpInfo, String salt) {
//        em.createNativeQuery("insert into user (email, nickname, password, address, gender, photo_path) values (:email,:nickname,:password,:address,:gender,:photoPath)")
//                .setParameter("email", user.getEmail())
//                .setParameter("nickname", user.getNickname())
//                .setParameter("password", user.getPassword())
//                .setParameter("address", user.getAddress())
//                .setParameter("gender", user.getGender())
//                .setParameter("photoPath", user.getPhotoPath());
        UserEntity user = UserEntity.builder().email(signUpInfo.getEmail())
                .password(signUpInfo.getPassword())
                .address(signUpInfo.getAddress())
                .nickname(signUpInfo.getNickname())
                .gender(signUpInfo.getGender())
                .salt(salt)
                .build();
        em.persist(user);
        return user.getId();
    }

    public void updateJWT(int id, String jwt) {
        em.createQuery("update user as u set u.jwt = :jwt where u.id = :id")
                .setParameter("jwt", jwt)
                .setParameter("id", id)
                .executeUpdate();
    }

    public UserInfoDto findById(int id) {
        UserEntity userEntity = em.find(UserEntity.class, id);
        return new UserInfoDto(userEntity);
    }

    public UserInfoDto findByPhoneNumber(String phoneNumber) {
        try {
            UserEntity result = em.createQuery("select u from user as u where u.phoneNumber = :phoneNumber", UserEntity.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();

            return new UserInfoDto(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserInfoDto findByEmail(String email) {
        try {
            UserEntity result = em.createQuery("select user from user as user where user.email = :email", UserEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

            return new UserInfoDto(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserInfoDto findByNickname(String nickname) {
        try {
            UserEntity result = em.createQuery("select user from user as user where user.nickname = :nickname", UserEntity.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();

            return new UserInfoDto(result);
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

    public void updateUser(UserInfoDto userInfo) {
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
                .setParameter("id", userInfo.getId())
                .executeUpdate();
    }

    public void updateLanguage(int id, String newLanguage) {
        em.createQuery("update user as u set u.language = :language where u.id = :id")
                .setParameter("language", newLanguage)
                .setParameter("id", id)
                .executeUpdate();
    }
}
