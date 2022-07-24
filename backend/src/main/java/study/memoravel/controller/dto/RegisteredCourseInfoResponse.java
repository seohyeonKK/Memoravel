package study.memoravel.controller.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.memoravel.dto.CourseSpot;
import study.memoravel.dto.RegisteredCourseInfo;

import java.util.Date;
import java.util.List;

@Getter
@ApiModel("코스 등록 정보")
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredCourseInfoResponse {
    @ApiModelProperty("코스 등록한 사람 id")
    private long memberId;
    @ApiModelProperty("등록할 코스 이름")
    private String title;
    @ApiModelProperty("대표 지역 주소")
    private String representRegion;
    @ApiModelProperty("가능한 언어 리스트")
    private List<String> enableLangList;
    @ApiModelProperty("사진 주소 리스트")
    private List<String> imagePathList;
    @ApiModelProperty("코스 설명 글")
    private String contents;
    @ApiModelProperty("목적지 리스트")
    private List<CourseSpot> courseSpotList;
    @ApiModelProperty("코스 가이드 비용")
    private int guideCost;
    @ApiModelProperty("코스 총 예상 비용")
    private int expectedTotalCost;
    @ApiModelProperty("시작 날짜(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)")
    private Date startDate;
    @ApiModelProperty("종료 날짜(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)")
    private Date endDate;

    public RegisteredCourseInfoResponse(RegisteredCourseInfo registeredCourseInfo) {
        memberId = registeredCourseInfo.getMemberId();
        title = registeredCourseInfo.getTitle();
        representRegion = registeredCourseInfo.getRepresentRegion();
        enableLangList = registeredCourseInfo.getEnableLangList();
        imagePathList = registeredCourseInfo.getImagePathList();
        contents = registeredCourseInfo.getContents();
        courseSpotList = registeredCourseInfo.getCourseSpotList();
        guideCost = registeredCourseInfo.getGuideCost();
        expectedTotalCost = registeredCourseInfo.getExpectedTotalCost();
        startDate = registeredCourseInfo.getStartDate();
        endDate = registeredCourseInfo.getEndDate();
    }
}
