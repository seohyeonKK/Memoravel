package study.memoravel.domain;


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
@Entity(name = "reg_course")
public class RegisterCourseEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String contents;
    @CreationTimestamp
    private Date createdAt;
    @CreationTimestamp
    private Date updatedAt;
    private Date startTime;
    private Date endTime;
    private int guidePay;
    private int travelExpense;
}
