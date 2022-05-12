package study.memoravel.domain;


import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
