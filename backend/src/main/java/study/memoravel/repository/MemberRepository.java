package study.memoravel.repository;

import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Repository;
import study.memoravel.domain.MemberEntity;
import study.memoravel.dto.MemberInfo;
import study.memoravel.dto.SignUpInfo;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public long save(SignUpInfo signUpInfo, String salt) {
//        em.createNativeQuery("insert into user (email, nickname, password, address, gender, photo_path) values (:email,:nickname,:password,:address,:gender,:photoPath)")
//                .setParameter("email", user.getEmail())
//                .setParameter("nickname", user.getNickname())
//                .setParameter("password", user.getPassword())
//                .setParameter("address", user.getAddress())
//                .setParameter("gender", user.getGender())
//                .setParameter("photoPath", user.getPhotoPath());

        MemberEntity memberEntity = new MemberEntity(signUpInfo, salt);
        em.persist(memberEntity);
        return memberEntity.getId();
    }

    public void updateJWT(long id, String jwt) {
        em.createQuery("update member as m set m.jwt = :jwt where m.id = :id")
                .setParameter("jwt", jwt)
                .setParameter("id", id)
                .executeUpdate();
    }

    public MemberInfo findById(long id) {
        MemberEntity memberEntity = em.find(MemberEntity.class, id);
        return new MemberInfo(memberEntity);
    }

    public MemberInfo findByPhoneNumber(String phoneNumber) {
        try {
            MemberEntity result = em.createQuery("select m from member as m where m.phoneNumber = :phoneNumber", MemberEntity.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();

            return new MemberInfo(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public MemberInfo findByEmail(String email) {
        try {
            MemberEntity result = em.createQuery("select m from member as m where m.email = :email", MemberEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();

            return new MemberInfo(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public MemberInfo findByNickname(String nickname) {
        try {
            MemberEntity result = em.createQuery("select m from member as m where m.nickname = :nickname", MemberEntity.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();

            return new MemberInfo(result);
        } catch (NoResultException e) {
            return null;
        }
    }

    public void updatePhoneNumber(long id, String phoneNumber) {
        em.createQuery("update member as m set m.phoneNumber = :phoneNumber where m.id = :id")
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("id", id)
                .executeUpdate();
    }

    public void updateMemberInfo(MemberInfo memberInfo) {
        Point location = null;
        try {
            location = (Point) new WKTReader().read(String.format("POINT(%s %s)", memberInfo.getLongitude(), memberInfo.getLatitude()));
        } catch (ParseException e) {
            System.out.println("좌표 저장 파싱 오류");
            e.printStackTrace();
        }

        em.createQuery("update member as m set m.email = :newEmail, m.nickname = :nickname," +
                        " m.location = :location, m.gender = :gender , m.photoPath = :photoPath , m.phoneNumber = :phoneNumber , " +
                        "m.language = :language where m.id = :id")
                .setParameter("newEmail", memberInfo.getEmail())
                .setParameter("nickname", memberInfo.getNickname())
                .setParameter("location", location)
                .setParameter("gender", memberInfo.getGender())
                .setParameter("photoPath", memberInfo.getPhotoPath())
                .setParameter("phoneNumber", memberInfo.getPhoneNumber())
                .setParameter("language", memberInfo.getLanguage())
                .setParameter("id", memberInfo.getId())
                .executeUpdate();
    }

    public void updateLanguage(long id, String newLanguage) {
        em.createQuery("update member as m set m.language = :language where m.id = :id")
                .setParameter("language", newLanguage)
                .setParameter("id", id)
                .executeUpdate();
    }
}
