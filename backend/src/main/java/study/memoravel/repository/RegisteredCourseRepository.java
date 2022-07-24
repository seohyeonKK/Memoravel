package study.memoravel.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.memoravel.domain.LanguageEntity;
import study.memoravel.domain.MemberEntity;
import study.memoravel.domain.course.registered.*;
import study.memoravel.dto.CourseSpot;
import study.memoravel.dto.RegisteredCourseInfo;
import study.memoravel.exception.course.CourseNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class RegisteredCourseRepository {
    private final EntityManager em;

    public void save(RegisteredCourseInfo registeredCourseInfo) {
        // 기본 코스 정보 저장
        RegisteredCourseEntity registeredCourseEntity = new RegisteredCourseEntity(registeredCourseInfo);
        em.persist(registeredCourseEntity);
        // 코스 등록 관계 정보 저장
        MemberEntity memberEntity = em.find(MemberEntity.class, registeredCourseInfo.getMemberId());
        RegisteringEntity registeringEntity = new RegisteringEntity(memberEntity, registeredCourseEntity);
        em.persist(registeringEntity);
        // 코스 가능 언어 정보 저장
        List<String> enableLangList = registeredCourseInfo.getEnableLangList();
        for (String enableLang : enableLangList) {
            LanguageEntity languageEntity = null;
            try {
                languageEntity = em.createQuery("select l from lang as l where l.langName = :name", LanguageEntity.class)
                        .setParameter("name", enableLang)
                        .getSingleResult();
            } catch (NoResultException e) {
                languageEntity = new LanguageEntity(enableLang);
            }
            RegisteredCourseLangEntity registeredCourseLangEntity =
                    new RegisteredCourseLangEntity(registeredCourseEntity, languageEntity);
            em.persist(registeredCourseLangEntity);
        }
        // 코스 사진 정보 저장
        for (String imagePath : registeredCourseInfo.getImagePathList()) {
            RegisteredCourseImageEntity registeredCourseImageEntity =
                    new RegisteredCourseImageEntity(registeredCourseEntity, imagePath);
            em.persist(registeredCourseImageEntity);
        }
        // 코스 목적지 정보 저장
        List<CourseSpot> courseSpotList = registeredCourseInfo.getCourseSpotList();
        for (int i = 0; i < courseSpotList.size(); i++) {
            RegisteredCourseSpotEntity registeredCourseSpotEntity =
                    new RegisteredCourseSpotEntity(registeredCourseEntity, i + 1, courseSpotList.get(i));
            em.persist(registeredCourseSpotEntity);
        }
    }

    public RegisteredCourseInfo findById(long id) {
        RegisteredCourseEntity registeredCourseEntity = em.find(RegisteredCourseEntity.class, id);
        if (registeredCourseEntity == null) {
            throw new CourseNotFoundException();
        }

        RegisteringEntity registeringEntity = em.find(RegisteringEntity.class, id);
        long memberId = registeringEntity.getMemberEntity().getId();

        List<String> enableLangList = new ArrayList<>();
        List<RegisteredCourseLangEntity> registeredCourseLangEntityList
                = em.createQuery("select r from reg_course_lang as r " +
                        "where r.registeredCourseEntity.id = :id", RegisteredCourseLangEntity.class)
                .setParameter("id", id)
                .getResultList();
        for (RegisteredCourseLangEntity registeredCourseLangEntity : registeredCourseLangEntityList) {
            enableLangList.add(registeredCourseLangEntity.getLanguageEntity().getLangName());
        }

        List<String> imagePathList = new ArrayList<>();
        List<RegisteredCourseImageEntity> registeredCourseImageEntityList
                = em.createQuery("select r from reg_course_image as r " +
                        "where r.registeredCourseEntity.id = :id", RegisteredCourseImageEntity.class)
                .setParameter("id", id)
                .getResultList();
        for (RegisteredCourseImageEntity registeredCourseImageEntity : registeredCourseImageEntityList) {
            imagePathList.add(registeredCourseImageEntity.getImagePath());
        }

        List<CourseSpot> courseSpotList = new ArrayList<>();
        List<RegisteredCourseSpotEntity> registeredCourseSpotEntityList = em.createQuery("select r from reg_course_spot as r " +
                        "where r.registeredCourseEntity.id = :id", RegisteredCourseSpotEntity.class)
                .setParameter("id", id)
                .getResultList();
        for (RegisteredCourseSpotEntity registeredCourseSpotEntity : registeredCourseSpotEntityList) {
            courseSpotList.add(new CourseSpot(registeredCourseSpotEntity));
        }

        return new RegisteredCourseInfo(registeredCourseEntity, memberId, enableLangList, imagePathList, courseSpotList);
    }
}
