package study.memoravel.domain.course.registered;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "reg_course_image")
public class RegisteredCourseImageEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RegisteredCourseEntity registeredCourseEntity;

    @Column(nullable = false)
    private String imagePath;

    public RegisteredCourseImageEntity(RegisteredCourseEntity registeredCourseEntity, String imagePath) {
        this.registeredCourseEntity = registeredCourseEntity;
        this.imagePath = imagePath;
    }
}
