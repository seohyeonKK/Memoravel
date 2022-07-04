package study.memoravel.domain.requestCourse;


import lombok.*;
import study.memoravel.domain.MemberEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "interested_req_course")
public class InterestedRequestCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private MemberEntity memberEntity;

    @JoinColumn(name = "course_id")
    @OneToOne
    private InterestedRequestCourseEntity requestedCourseEntity;
}
