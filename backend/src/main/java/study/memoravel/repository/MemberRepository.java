package study.memoravel.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.memoravel.domain.MemberEntity;
import study.memoravel.dto.MemberInfoDto;
import study.memoravel.dto.SignUpInfoDto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public long save(SignUpInfoDto signUpInfo, String salt) {
//        em.createNativeQuery("insert into user (email, nickname, password, address, gender, photo_path) values (:email,:nickname,:password,:address,:gender,:photoPath)")
//                .setParameter("email", user.getEmail())
//                .setParameter("nickname", user.getNickname())
//                .setParameter("password", user.getPassword())
//                .setParameter("address", user.getAddress())
//                .setParameter("gender", user.getGender())
//                .setParameter("photoPath", user.getPhotoPath());
        MemberEntity memberEntity = MemberEntity.builder().email(signUpInfo.getEmail())
                .password(signUpInfo.getPassword())
                .address(signUpInfo.getAddress())
                .nickname(signUpInfo.getNickname())
                .gender(signUpInfo.getGender())
                .salt(salt)
                .build();
        em.persist(memberEntity);
        return memberEntity.getId();
    }

    public void updateJWT(long id, String jwt) {
        em.createQuery("update member as m set m.jwt = :jwt where m.id = :id")
                .setParameter("jwt", jwt)
                .setParameter("id", id)
                .executeUpdate();
    }

    public MemberInfoDto findById(int id) {
        MemberEntity memberEntity = em.find(MemberEntity.class, id);
        return new MemberInfoDto(memberEntity);
    }

    public MemberInfoDto findByPhoneNumber(String phoneNumber) {
        try {
            MemberEntity result = em.createQuery("select m from member as m where m.phoneNumber = :phoneNumber", MemberEntity.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();

            return new MemberInfoDto(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public MemberInfoDto findByEmail(String email) {
        try {
            MemberEntity result = em.createQuery("select m from member as m where m.email = :email", MemberEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

            return new MemberInfoDto(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public MemberInfoDto findByNickname(String nickname) {
        try {
            MemberEntity result = em.createQuery("select m from member as m where m.nickname = :nickname", MemberEntity.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();

            return new MemberInfoDto(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public void updatePhoneNumber(int id, String phoneNumber) {
        em.createQuery("update member as m set m.phoneNumber = :phoneNumber where m.id = :id")
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("id", id)
                .executeUpdate();
    }

    public void updateMemberInfo(MemberInfoDto memberInfo) {
        em.createQuery("update member as m set m.email = :newEmail, m.nickname = :nickname," +
                        " m.address = :address, m.gender = :gender , m.photoPath = :photoPath , m.phoneNumber = :phoneNumber , " +
                        "m.language = :language where m.id = :id")
                .setParameter("newEmail", memberInfo.getEmail())
                .setParameter("nickname", memberInfo.getNickname())
                .setParameter("address", memberInfo.getAddress())
                .setParameter("gender", memberInfo.getGender())
                .setParameter("photoPath", memberInfo.getPhotoPath())
                .setParameter("phoneNumber", memberInfo.getPhoneNumber())
                .setParameter("language", memberInfo.getLanguage())
                .setParameter("id", memberInfo.getId())
                .executeUpdate();
    }

    public void updateLanguage(int id, String newLanguage) {
        em.createQuery("update member as m set m.language = :language where m.id = :id")
                .setParameter("language", newLanguage)
                .setParameter("id", id)
                .executeUpdate();
    }
}
