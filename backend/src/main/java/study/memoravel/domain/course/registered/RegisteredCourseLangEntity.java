package study.memoravel.domain.course.registered;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import study.memoravel.domain.LanguageEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "reg_course_lang")
public class RegisteredCourseLangEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RegisteredCourseEntity registeredCourseEntity;

    @JoinColumn(name = "lang_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LanguageEntity languageEntity;

    public RegisteredCourseLangEntity(RegisteredCourseEntity registeredCourseEntity, LanguageEntity languageEntity) {
        this.registeredCourseEntity = registeredCourseEntity;
        this.languageEntity = languageEntity;
    }
}
