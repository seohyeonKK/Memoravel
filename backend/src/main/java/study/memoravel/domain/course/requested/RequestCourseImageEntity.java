package study.memoravel.domain.course.requested;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "req_course_image")
public class RequestCourseImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "course_id")
    @OneToOne
    private RequestCourseImageEntity requestedCourseEntity;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false)
    @CreationTimestamp
    private Date updatedAt;
}
