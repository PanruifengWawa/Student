package com.my.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/1/18.
 */
@Entity
@Table(name = "news")
public class NewsEntity {
    private long newsid;
    private Long userid;
    private String title;
    private Timestamp time;
    private String contents;
    private Long state;

    @Id
    @Column(name = "newsid")
    public long getNewsid() {
        return newsid;
    }

    public void setNewsid(long newsid) {
        this.newsid = newsid;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "contents")
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Basic
    @Column(name = "state")
    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (newsid != that.newsid) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (contents != null ? !contents.equals(that.contents) : that.contents != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (newsid ^ (newsid >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
