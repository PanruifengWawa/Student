package com.my.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/1/18.
 */
@Entity
@Table(name = "posts")
public class PostsEntity {
    private long postsid;
    private Long userid;
    private String theme;
    private String title;
    private String contents;
    private Long readcount;
    private Timestamp time;
    private Integer state;
    
    private String username;
    

    
    @Basic
    @Column(name = "state")
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Transient
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
    @Column(name = "read_count")
    public Long getReadcount() {
		return readcount;
	}

	public void setReadcount(Long readcount) {
		this.readcount = readcount;
	}

	@Id
    @Column(name = "postsid")
    public long getPostsid() {
        return postsid;
    }

    public void setPostsid(long postsid) {
        this.postsid = postsid;
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
    @Column(name = "theme")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
    @Column(name = "contents")
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostsEntity that = (PostsEntity) o;

        if (postsid != that.postsid) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (theme != null ? !theme.equals(that.theme) : that.theme != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (contents != null ? !contents.equals(that.contents) : that.contents != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (postsid ^ (postsid >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
