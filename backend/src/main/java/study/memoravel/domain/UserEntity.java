package study.memoravel.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {
    @Id
    @PrimaryKeyJoinColumn
    private String email;
    private String nickname;
    private String password;
    @CreationTimestamp
    private Date regDate;
    private String address;
    private String gender;
    private String photoPath;
    private String phoneNumber;
    private String language;
}
