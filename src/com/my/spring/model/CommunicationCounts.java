package com.my.spring.model;

import java.math.BigInteger;

public class CommunicationCounts {
	private BigInteger todayPostCount;
	private BigInteger allPostCount;
	private BigInteger allCommentCount;
	public BigInteger getTodayPostCount() {
		return todayPostCount;
	}
	public void setTodayPostCount(BigInteger todayPostCount) {
		this.todayPostCount = todayPostCount;
	}
	public BigInteger getAllPostCount() {
		return allPostCount;
	}
	public void setAllPostCount(BigInteger allPostCount) {
		this.allPostCount = allPostCount;
	}
	public BigInteger getAllCommentCount() {
		return allCommentCount;
	}
	public void setAllCommentCount(BigInteger allCommentCount) {
		this.allCommentCount = allCommentCount;
	}
	
	
	
	
}
