package study.memoravel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.memoravel.domain.course.registered.RegisteredCourseEntity;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder

public class RegisteredCourseCard {
    // TODO 별점 추가
    private final long id;
    private final String title;
    private final String representRegion;
    private final List<String> enableLangList;
    private final List<String> imagePathList;
    private final String contents;
    private final int guideCost;
    private final int expectedTotalCost;
    private final Date startDate;
    private final Date endDate;

    public RegisteredCourseCard(RegisteredCourseEntity registeredCourseEntity, List<String> enableLangList, List<String> imagePathList) {
        id = registeredCourseEntity.getId();
        title = registeredCourseEntity.getTitle();
        representRegion = registeredCourseEntity.getRepresentRegion();
        this.enableLangList = enableLangList;
        this.imagePathList = imagePathList;
        contents = registeredCourseEntity.getContents();
        guideCost = registeredCourseEntity.getGuideCost();
        expectedTotalCost = registeredCourseEntity.getExpectedTotalCost();
        startDate = registeredCourseEntity.getStartDate();
        endDate = registeredCourseEntity.getEndDate();
    }
}
