package study.memoravel.domain.course.requested;


import lombok.*;
import study.memoravel.domain.LanguageEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "req_course_lang")
public class RequestCourseLangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private RequestCourseLangEntity requestedCourseEntity;

    @JoinColumn(name = "lang_id")
    @ManyToOne
    private LanguageEntity languageEntity;
}
