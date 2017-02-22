package com.my.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/2/14.
 */
@Entity
@Table(name = "token")
public class TokenEntity {
    private long id;
    private String token;
    private Long userid;
    private Timestamp logindate;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "logindate")
    public Timestamp getLogindate() {
        return logindate;
    }

    public void setLogindate(Timestamp logindate) {
        this.logindate = logindate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenEntity that = (TokenEntity) o;

        if (id != that.id) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (logindate != null ? !logindate.equals(that.logindate) : that.logindate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (logindate != null ? logindate.hashCode() : 0);
        return result;
    }
}
