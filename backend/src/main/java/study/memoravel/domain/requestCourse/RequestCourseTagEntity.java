package study.memoravel.domain.requestCourse;


import lombok.*;
import study.memoravel.domain.TagEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "req_course_tag")
public class RequestCourseTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private RequestCourseTagEntity requestedCourseEntity;

    @JoinColumn(name = "tag_id")
    @ManyToOne
    private TagEntity tagEntity;
}
