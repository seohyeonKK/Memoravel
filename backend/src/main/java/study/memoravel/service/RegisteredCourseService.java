package study.memoravel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.memoravel.dto.RegisteredCourseCard;
import study.memoravel.dto.RegisteredCourseInfo;
import study.memoravel.repository.RegisteredCourseRepository;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class RegisteredCourseService {

    private final RegisteredCourseRepository registeredCourseRepository;

    public void registerCourse(RegisteredCourseInfo registeredCourseInfo) {
        registeredCourseRepository.save(registeredCourseInfo);
    }

    public RegisteredCourseInfo getCourseInfoById(long courseId) {
        return registeredCourseRepository.findById(courseId);
    }

    public List<RegisteredCourseCard> getRegisteredCourseCardList(int offset, int limit) {
        return registeredCourseRepository.GetRegisterCourseCardList(offset, limit);
    }

}
