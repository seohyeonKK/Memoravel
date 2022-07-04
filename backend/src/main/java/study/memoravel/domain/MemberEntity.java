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
@Entity(name = "member")
public class MemberEntity {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(nullable = false)
    private Date regDate;

    @Column(nullable = false, unique = true)
    private String address;

    @Column(nullable = false, unique = true)
    private String gender;

    private String photoPath;

    private String phoneNumber;
    private String language;

    @Column(nullable = false)
    private String salt;
    
    private String jwt;

    @PrePersist
    public void prePersist() {
        this.language = this.language == null ? "korean" : this.language;
        // default photo path
        this.photoPath = this.photoPath == null ? "D://" : this.photoPath;
    }
}
