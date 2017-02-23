package com.my.spring.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commentreply")
public class CommentReplyEntity {
	private long commentreplyid;
	private Long commentid;
	private String contents;
	private Timestamp time;
	private Long userid;
	private String username;
	
	@Id
    @Column(name = "commentreplyid")
	public long getCommentreplyid() {
		return commentreplyid;
	}
	public void setCommentreplyid(long commentreplyid) {
		this.commentreplyid = commentreplyid;
	}
	
	@Basic
    @Column(name = "commentid")
	public Long getCommentid() {
		return commentid;
	}
	public void setCommentid(Long commentid) {
		this.commentid = commentid;
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
	@Basic
    @Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	


}
