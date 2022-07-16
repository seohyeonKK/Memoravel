package study.memoravel.domain.course.registered;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import study.memoravel.domain.MemberEntity;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "registered_course")
public class RegisteringEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private MemberEntity memberEntity;

    @JoinColumn(name = "course_id")
    @OneToOne
    private RegisteredCourseEntity registeredCourseEntity;

    public RegisteringEntity(MemberEntity memberEntity, RegisteredCourseEntity registeredCourseEntity) {
        this.memberEntity = memberEntity;
        this.registeredCourseEntity = registeredCourseEntity;
    }
}
