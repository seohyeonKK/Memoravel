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

    public void registerCourse(RegisteredCourseInfo registeredCourseInfo) {
        registeredCourseRepository.save(registeredCourseInfo);
    }

    public RegisteredCourseInfo getCourseInfo(long courseId) {
        return registeredCourseRepository.findById(courseId);
    }
}
