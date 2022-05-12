package study.memoravel.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "user")
public class User {
    public User() {

    }

    public User(String email, String password, String address, String gender, String photoPath, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.photoPath = photoPath;
        this.phoneNumber = phoneNumber;
    }

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
