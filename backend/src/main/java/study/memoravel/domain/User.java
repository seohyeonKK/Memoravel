package study.memoravel.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.sql.Date;


public class User {
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    @ApiModel("유저 정보")
    public static class DTO {
        @ApiModelProperty(value = "이메일")
        private String email;
        @ApiModelProperty(value = "별명")
        private String nickname;
        @ApiModelProperty(value = "비밀번호")
        private String password;
        @ApiModelProperty(hidden = true)
        private Date regDate;
        @ApiModelProperty(value = "주소")
        private String address;
        @ApiModelProperty(value = "성별")
        private String gender;
        @ApiModelProperty(value = "프로필 사진 위치")
        private String photoPath;
        @ApiModelProperty(value = "핸드폰번호")
        private String phoneNumber;

        public User.DAO toDAO() {
            return User.DAO.builder().email(email).nickname(nickname).password(password)
                    .regDate(regDate).address(address).gender(gender).photoPath(photoPath)
                    .phoneNumber(phoneNumber).build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    @Entity(name = "user")
    @Table(name = "user")
    public static class DAO {
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

        public User.DTO toDTO() {
            return User.DTO.builder().email(email).nickname(nickname).password(password)
                    .regDate(regDate).address(address).gender(gender).photoPath(photoPath)
                    .phoneNumber(phoneNumber).build();
        }
    }

}
