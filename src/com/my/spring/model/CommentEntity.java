package com.my.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Entity
@Table(name = "comment")
public class CommentEntity {
    private long commentid;
    private Long postsid;
    private String contents;
    private Timestamp time;
    private Long userid;
    private String username;
    
    

    private List<CommentReplyEntity> commentReplyEntity;
    
    @Transient
    public List<CommentReplyEntity> getCommentReplyEntity() {
		return commentReplyEntity;
	}

	public void setCommentReplyEntity(List<CommentReplyEntity> commentReplyEntity) {
		this.commentReplyEntity = commentReplyEntity;
	}

	@Transient
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
    @Column(name = "commentid")
    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    @Basic
    @Column(name = "postsid")
    public Long getPostsid() {
        return postsid;
    }

    public void setPostsid(Long postsid) {
        this.postsid = postsid;
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

    @Basic
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentid != that.commentid) return false;
        if (postsid != null ? !postsid.equals(that.postsid) : that.postsid != null) return false;
        if (contents != null ? !contents.equals(that.contents) : that.contents != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (commentid ^ (commentid >>> 32));
        result = 31 * result + (postsid != null ? postsid.hashCode() : 0);
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
