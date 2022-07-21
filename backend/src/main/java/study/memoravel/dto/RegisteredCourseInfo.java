package study.memoravel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.memoravel.controller.dto.RegisterCourseRequest;
import study.memoravel.domain.course.registered.RegisteredCourseEntity;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class RegisteredCourseInfo {
    private final long memberId;
    private final String title;
    private final String representRegion;
    private final List<String> enableLangList;
    private final List<String> imagePathList;
    private final String contents;
    private final List<CourseSpot> courseSpotList;
    private final int guideCost;
    private final int expectedTotalCost;
    private final Date startDate;
    private final Date endDate;

    public RegisteredCourseInfo(RegisterCourseRequest registerCourseRequest, long memberId) {
        this.memberId = memberId;
        this.title = registerCourseRequest.getTitle();
        this.representRegion = registerCourseRequest.getRepresentRegion();
        this.enableLangList = registerCourseRequest.getEnableLangList();
        this.imagePathList = registerCourseRequest.getImagePathList();
        this.contents = registerCourseRequest.getContents();
        this.courseSpotList = registerCourseRequest.getCourseSpotList();
        this.guideCost = registerCourseRequest.getGuideCost();
        this.expectedTotalCost = registerCourseRequest.getExpectedTotalCost();
        this.startDate = registerCourseRequest.getStartDate();
        this.endDate = registerCourseRequest.getEndDate();
    }

    public RegisteredCourseInfo(RegisteredCourseEntity registeredCourseEntity, long memberId,
                                List<String> enableLangList,
                                List<String> imagePathList,
                                List<CourseSpot> courseSpotList) {
        this.memberId = memberId;
        this.title = registeredCourseEntity.getTitle();
        this.representRegion = registeredCourseEntity.getRepresentRegion();
        this.enableLangList = enableLangList;
        this.imagePathList = imagePathList;
        this.contents = registeredCourseEntity.getContents();
        this.courseSpotList = courseSpotList;
        this.guideCost = registeredCourseEntity.getGuideCost();
        this.expectedTotalCost = registeredCourseEntity.getExpectedTotalCost();
        this.startDate = registeredCourseEntity.getStartDate();
        this.endDate = registeredCourseEntity.getEndDate();
    }
}
