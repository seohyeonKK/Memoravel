package study.memoravel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.dto.RegisteredCourseInfo;
import study.memoravel.repository.RegisteredCourseRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class RegisteredCourseService {

    private final RegisteredCourseRepository registeredCourseRepository;

    protected void registerCourse(RegisteredCourseInfo registeredCourseInfo) {
        // 기본 코스 정보 등록
        long id = registeredCourseRepository.save(registeredCourseInfo);

        // 사진 등록
        // 언어 등록(언어가 없다면 새롭게 생성)

    }

}
