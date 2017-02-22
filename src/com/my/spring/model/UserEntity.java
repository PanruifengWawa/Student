package com.my.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/1/18.
 */
@Entity
@Table(name = "user")
public class UserEntity {
    private Long userid;
    private String username;
    private Long studentid;
    private String password;
    private String department;
    private String major;
    private String email;
    private String personalbrief;
    private Integer usertype;
    private String telephone;
    private Timestamp registertime;
    private String personaltag;
    
    
    
    @Basic
    @Column(name = "personal_tag")
    public String getPersonaltag() {
		return personaltag;
	}

	public void setPersonaltag(String personaltag) {
		this.personaltag = personaltag;
	}

	@Id
	@GeneratedValue
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "studentid")
    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "personalbrief")
    public String getPersonalbrief() {
        return personalbrief;
    }

    public void setPersonalbrief(String personalbrief) {
        this.personalbrief = personalbrief;
    }

    @Basic
    @Column(name = "usertype")
    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "registertime")
    public Timestamp getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != that.userid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (personalbrief != null ? !personalbrief.equals(that.personalbrief) : that.personalbrief != null)
            return false;
        if (usertype != null ? !usertype.equals(that.usertype) : that.usertype != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (registertime != null ? !registertime.equals(that.registertime) : that.registertime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userid ^ (userid >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (personalbrief != null ? personalbrief.hashCode() : 0);
        result = 31 * result + (usertype != null ? usertype.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (registertime != null ? registertime.hashCode() : 0);
        return result;
    }
}
