package study.memoravel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.memoravel.domain.course.registered.RegisteredCourseSpotEntity;

@Getter
@ApiModel("코스 목적지")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CourseSpot {
    @ApiModelProperty(value = "위도", required = true)
    private double latitude;
    @ApiModelProperty(value = "경도", required = true)
    private double longitude;
    @ApiModelProperty(value = "예상 비용")
    private int expectedCost;

    public CourseSpot(RegisteredCourseSpotEntity registeredCourseSpotEntity) {
        this.latitude = registeredCourseSpotEntity.getLatitude();
        this.longitude = registeredCourseSpotEntity.getLongitude();
        this.expectedCost = registeredCourseSpotEntity.getExpectedCost();
    }
}
