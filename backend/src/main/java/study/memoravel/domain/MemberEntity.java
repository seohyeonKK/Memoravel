package study.memoravel.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import study.memoravel.dto.SignUpInfoDto;

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
    private Point location;

    @Column(nullable = false, unique = true)
    private String gender;

    private String photoPath;

    private String phoneNumber;
    private String language;

    @Column(nullable = false)
    private String salt;

    private String jwt;

    public MemberEntity(SignUpInfoDto signUpInfoDto, String salt) {
        this.email = signUpInfoDto.getEmail();
        this.nickname = signUpInfoDto.getNickname();
        this.password = signUpInfoDto.getPassword();
        try {
            this.location = (Point) new WKTReader().read(String.format("POINT(%s %s)", signUpInfoDto.getLatitude(), signUpInfoDto.getLongitude()));
        } catch (ParseException e) {
            System.out.println("좌표 저장 파싱 오류");
            e.printStackTrace();
        }
        this.gender = signUpInfoDto.getGender();
        this.salt = salt;
    }

    @PrePersist
    public void prePersist() {
        this.language = this.language == null ? "korean" : this.language;
        // default photo path
        this.photoPath = this.photoPath == null ? "D://" : this.photoPath;
    }
}
