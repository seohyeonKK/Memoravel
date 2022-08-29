package study.memoravel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import study.memoravel.controller.dto.RegisterCourseRequest;
import study.memoravel.controller.dto.RegisteredCourseInfoResponse;
import study.memoravel.dto.CourseSpot;
import study.memoravel.dto.SignUpInfo;
import study.memoravel.service.MemberService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class RegisteredCourseControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("코스 등록 테스트")
    public void registerCourseTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        SignUpInfo signUpInfo = SignUpInfo.builder().email("koc0819@gamil.com").gender("man")
                .nickname("chanbro")
                .password("1234")
                .latitude(37.559722)
                .longitude(126.975278)
                .build();
        String auth = memberService.signUp(signUpInfo);

        ArrayList<String> enableLangList = new ArrayList<>();
        Collections.addAll(enableLangList, "korean", "english");

        ArrayList<String> imagePathList = new ArrayList<>();
        Collections.addAll(imagePathList, "D://path/item1", "D://path/item2");

        ArrayList<CourseSpot> courseSpotList = new ArrayList<>();
        courseSpotList.add(new CourseSpot(36.3232, 127.3443, 500));
        courseSpotList.add(new CourseSpot(36.3272, 127.3423, 500));


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        RegisterCourseRequest registerCourseRequest = RegisterCourseRequest.builder()
                .title("테스트 코스")
                .representRegion("광진구 구의동 236-37")
                .enableLangList(enableLangList)
                .imagePathList(imagePathList)
                .contents("여기는 아주 좋은 곳 입니다. 아주 좋아요")
                .courseSpotList(courseSpotList)
                .guideCost(5000)
                .expectedTotalCost(1000)
                .startDate(formatter.parse("2022-07-19T15:00:00.000+00:00"))
                .endDate(formatter.parse("2022-09-28T15:00:00.000+00:00"))
                .build();

        mockMvc.perform(post("/api/register-course/")
                        .content(objectMapper.writeValueAsString(registerCourseRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("authorization", auth)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());


        MvcResult result = mockMvc.perform(get("/api/register-course/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String returnContent = result.getResponse().getContentAsString();
        RegisteredCourseInfoResponse registeredCourseInfoResponse = objectMapper.readValue(returnContent, RegisteredCourseInfoResponse.class);
        assertAll(
                "registeredCourseInfoResponse",
                () -> assertEquals(registeredCourseInfoResponse.getTitle(), registerCourseRequest.getTitle()),
                () -> assertEquals(registeredCourseInfoResponse.getRepresentRegion(), registerCourseRequest.getRepresentRegion()),
                () -> assertEquals(registeredCourseInfoResponse.getEnableLangList(), registerCourseRequest.getEnableLangList()),
                () -> assertEquals(registeredCourseInfoResponse.getImagePathList(), registerCourseRequest.getImagePathList()),
                () -> assertEquals(registeredCourseInfoResponse.getContents(), registerCourseRequest.getContents()),
                () -> assertEquals(registeredCourseInfoResponse.getCourseSpotList(), registerCourseRequest.getCourseSpotList()),
                () -> assertEquals(registeredCourseInfoResponse.getGuideCost(), registerCourseRequest.getGuideCost()),
                () -> assertEquals(registeredCourseInfoResponse.getExpectedTotalCost(), registerCourseRequest.getExpectedTotalCost()),
                () -> assertEquals(registeredCourseInfoResponse.getStartDate(), registerCourseRequest.getStartDate()),
                () -> assertEquals(registeredCourseInfoResponse.getEndDate(), registerCourseRequest.getEndDate())
        );
    }

}