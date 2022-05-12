package study.memoravel.domain.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import study.memoravel.domain.User;

import java.sql.Date;

@ApiModel(value = "유저 정보")
public class UserDTO {
    @ApiModelProperty(value = "이메일")
    public String email;
    @ApiModelProperty(value = "비밀번호")
    public String password;
    @ApiModelProperty(hidden = true)
    public Date regDate;
    @ApiModelProperty(value = "주소")
    public String address;
    @ApiModelProperty(value = "성별")
    public String gender;
    @ApiModelProperty(value = "프로필 사진 위치")
    public String photoPath;
    @ApiModelProperty(value = "핸드폰번호")
    public String phoneNumber;

    public User toEntity() {
        return new User(email, password, address, gender, photoPath, phoneNumber);
    }
}
