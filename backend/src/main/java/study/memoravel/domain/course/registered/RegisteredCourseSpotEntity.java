package study.memoravel.domain.course.registered;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import study.memoravel.dto.CourseSpot;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "reg_course_spot")
public class RegisteredCourseSpotEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private RegisteredCourseEntity registeredCourseEntity;

    @Column(nullable = false)
    private int ordered;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column
    private int expectedCost;

    public RegisteredCourseSpotEntity(RegisteredCourseEntity registeredCourseEntity, int ordered, CourseSpot courseSpot) {
        this.registeredCourseEntity = registeredCourseEntity;
        this.ordered = ordered;
        this.latitude = courseSpot.getLatitude();
        this.longitude = courseSpot.getLongitude();
        this.expectedCost = courseSpot.getExpectedCost();
    }
}
