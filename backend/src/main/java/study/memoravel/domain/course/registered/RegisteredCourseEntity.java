package study.memoravel.domain.course.registered;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import study.memoravel.dto.RegisteredCourseInfo;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "registered_course")
public class RegisteredCourseEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String representRegion;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int guideCost;

    @Column(nullable = false)
    private int expectedTotalCost;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;

    @CreationTimestamp
    @Column(nullable = false)
    private Date updatedAt;


    public RegisteredCourseEntity(RegisteredCourseInfo registeredCourseInfo) {
        this.title = registeredCourseInfo.getTitle();
        this.representRegion = registeredCourseInfo.getRepresentRegion();
        this.contents = registeredCourseInfo.getContents();
        this.guideCost = registeredCourseInfo.getGuideCost();
        this.expectedTotalCost = registeredCourseInfo.getExpectedTotalCost();
        this.startDate = registeredCourseInfo.getStartDate();
        this.endDate = registeredCourseInfo.getEndDate();
    }
}
