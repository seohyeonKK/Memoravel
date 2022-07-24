package study.memoravel.exception.course;

import study.memoravel.exception.BusinessException;
import study.memoravel.exception.ErrorCode;

public class CourseNotFoundException extends BusinessException {
    public CourseNotFoundException() {
        super(ErrorCode.COURSE_NOT_FOUND_EXCEPTION);
    }
}
