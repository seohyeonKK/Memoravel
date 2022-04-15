package domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="user")
public class User {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private String userName;
    private String userPassword;
    private String phoneNum;
    private String email;
    private String gender;
    private String city;
    @CreationTimestamp
    private Date regDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String user_password) {
        this.userPassword = user_password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phone_num) {
        this.phoneNum = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date reg_date) {
        this.regDate = reg_date;
    }
}
