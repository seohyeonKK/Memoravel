package study.memoravel.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @PrePersist
    public void prePersist(){
        this.language = this.language == null ? "korean" : this.language;
        this.photoPath = this.photoPath == null ? "D://" : this.photoPath;
    }
}
