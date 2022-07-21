package study.memoravel.domain.course.requested;


import lombok.*;
import study.memoravel.domain.MemberEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "requested_course")
public class RequestedCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private MemberEntity memberEntity;

    @JoinColumn(name = "course_id")
    @OneToOne
    private RequestedCourseEntity requestedCourseEntity;
}
