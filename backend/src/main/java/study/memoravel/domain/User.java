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
    @ApiModel("유저 정보")
    @AllArgsConstructor
    @Builder
    public static class Request {
        @ApiModelProperty(value = "이메일")
        private String email;
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
    }

    @Getter
    @Setter
    @ApiModel(value = "로그인 요청")
    public static class LoginRequest {
        @ApiModelProperty(value = "아이디")
        private String id;
        @ApiModelProperty(value = "비밀번호")
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table(name = "user")
    public static class Info {
        @Id
        @PrimaryKeyJoinColumn
        private String email;
        private String password;
        @CreationTimestamp
        private Date regDate;
        private String address;
        private String gender;
        private String photoPath;
        private String phoneNumber;
    }
}
