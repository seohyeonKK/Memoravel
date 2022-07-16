package study.memoravel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import study.memoravel.domain.course.registered.RegisteredCourseSpotEntity;

@Getter
@ApiModel("코스 목적지")
public class CourseSpot {
    @ApiModelProperty(value = "위도", required = true)
    private final double latitude;
    @ApiModelProperty(value = "경도", required = true)
    private final double longitude;
    @ApiModelProperty(value = "예상 비용")
    private final int expectedCost;

    public CourseSpot(RegisteredCourseSpotEntity registeredCourseSpotEntity) {
        this.latitude = registeredCourseSpotEntity.getLatitude();
        this.longitude = registeredCourseSpotEntity.getLongitude();
        this.expectedCost = registeredCourseSpotEntity.getExpectedCost();
    }
}
