package com.my.spring.model;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/1/18.
 */
public class CommunicationEntity {
	private Long postsId;
    private String theme;
    private String title;
    private String userName;
    private BigInteger replyCount;
    private BigInteger readCount;
    private String replyContents;
    private Timestamp publishedTime;
    private Timestamp replyTime;
    public CommunicationEntity() {
    	
    }
    
    

    public String getReplyContents() {
		return replyContents;
	}



	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}



	public BigInteger getReplyCount() {
		return replyCount;
	}



	public void setReplyCount(BigInteger replyCount) {
		this.replyCount = replyCount;
	}



	public BigInteger getReadCount() {
		return readCount;
	}



	public void setReadCount(BigInteger readCount) {
		this.readCount = readCount;
	}



	public Long getPostsId() {
		return postsId;
	}


	public void setPostsId(Long postsId) {
		this.postsId = postsId;
	}


	public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Timestamp getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Timestamp publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }
}
