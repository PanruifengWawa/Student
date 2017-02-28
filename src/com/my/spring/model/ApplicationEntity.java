package com.my.spring.model;


import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class ApplicationEntity {
	private long applicationid;
	private Long userid;
	private Long itemsid;
	private String username;
	private Timestamp time;
	private Integer state;
	
	@Id
    @Column(name = "applicationid")
	public long getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(long applicationid) {
		this.applicationid = applicationid;
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
    @Column(name = "itemsid")
	public Long getItemsid() {
		return itemsid;
	}
	public void setItemsid(Long itemsid) {
		this.itemsid = itemsid;
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
    @Column(name = "time")
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	@Basic
    @Column(name = "state")
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
