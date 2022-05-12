package study.memoravel.domain;


import javax.persistence.*;


public class Course {
    @Entity
    @Table(name = "course")
    public static class Info {
        @Id
        @PrimaryKeyJoinColumn
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    }

}
