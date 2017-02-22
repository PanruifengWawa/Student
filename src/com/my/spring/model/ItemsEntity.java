package com.my.spring.model;

import javax.persistence.*;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nixinan on 2017/1/18.
 */
@Entity
@Table(name = "items")
public class ItemsEntity {
    private long itemid;
    private Long userid;
    private String itemtype;
    private String itemname;
    private String itemleader;
    private String teacher;
    private String major;
    private String keywords;
    private String itembrief;
    private String expectresult;
    private String exitbasic;
    private String memberdemand;
    private Timestamp releasedate;
    private String itemresult;
    private String innovate;
    private String itemcyle;
    private String telephone;
    private Long type;
    private Long state;
    private Timestamp time;
    
    private Date starttime;
    private Date endtime;
    
    private String email;
    
    private Integer allpeople;
    private Integer nowpeople;
    
    private String labels;
    private String exitbasicfilesrc;
    private String memberdemandfilesrc;
    private String projectdirection;
    
    
    
    @Basic
    @Column(name = "projectdirection")
    public String getProjectdirection() {
		return projectdirection;
	}

	public void setProjectdirection(String projectdirection) {
		this.projectdirection = projectdirection;
	}

	@Basic
    @Column(name = "exitbasicfilesrc")
    public String getExitbasicfilesrc() {
		return exitbasicfilesrc;
	}

	public void setExitbasicfilesrc(String exitbasicfilesrc) {
		this.exitbasicfilesrc = exitbasicfilesrc;
	}

	@Basic
    @Column(name = "memberdemandfilesrc")
	public String getMemberdemandfilesrc() {
		return memberdemandfilesrc;
	}

	public void setMemberdemandfilesrc(String memberdemandfilesrc) {
		this.memberdemandfilesrc = memberdemandfilesrc;
	}

	@Basic
    @Column(name = "labels")
    public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	@Basic
    @Column(name = "all_people")
    public Integer getAllpeople() {
		return allpeople;
	}

	public void setAllpeople(Integer allpeople) {
		this.allpeople = allpeople;
	}

	@Basic
    @Column(name = "now_people")
	public Integer getNowpeople() {
		return nowpeople;
	}

	public void setNowpeople(Integer nowpeople) {
		this.nowpeople = nowpeople;
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
    @Column(name = "starttime")
    public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Basic
    @Column(name = "endtime")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Id
    @Column(name = "itemid")
    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
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
    @Column(name = "itemtype")
    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    @Basic
    @Column(name = "itemname")
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Basic
    @Column(name = "itemleader")
    public String getItemleader() {
        return itemleader;
    }

    public void setItemleader(String itemleader) {
        this.itemleader = itemleader;
    }

    @Basic
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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
    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "itembrief")
    public String getItembrief() {
        return itembrief;
    }

    public void setItembrief(String itembrief) {
        this.itembrief = itembrief;
    }

    @Basic
    @Column(name = "expectresult")
    public String getExpectresult() {
        return expectresult;
    }

    public void setExpectresult(String expectresult) {
        this.expectresult = expectresult;
    }

    @Basic
    @Column(name = "exitbasic")
    public String getExitbasic() {
        return exitbasic;
    }

    public void setExitbasic(String exitbasic) {
        this.exitbasic = exitbasic;
    }

    @Basic
    @Column(name = "memberdemand")
    public String getMemberdemand() {
        return memberdemand;
    }

    public void setMemberdemand(String memberdemand) {
        this.memberdemand = memberdemand;
    }

    @Basic
    @Column(name = "releasedate")
    public Timestamp getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Timestamp releasedate) {
        this.releasedate = releasedate;
    }

    @Basic
    @Column(name = "itemresult")
    public String getItemresult() {
        return itemresult;
    }

    public void setItemresult(String itemresult) {
        this.itemresult = itemresult;
    }

    @Basic
    @Column(name = "innovate")
    public String getInnovate() {
        return innovate;
    }

    public void setInnovate(String innovate) {
        this.innovate = innovate;
    }

    @Basic
    @Column(name = "itemcyle")
    public String getItemcyle() {
        return itemcyle;
    }

    public void setItemcyle(String itemcyle) {
        this.itemcyle = itemcyle;
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
    @Column(name = "type")
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Basic
    @Column(name = "state")
    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
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

        ItemsEntity that = (ItemsEntity) o;

        if (itemid != that.itemid) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (itemtype != null ? !itemtype.equals(that.itemtype) : that.itemtype != null) return false;
        if (itemname != null ? !itemname.equals(that.itemname) : that.itemname != null) return false;
        if (itemleader != null ? !itemleader.equals(that.itemleader) : that.itemleader != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (itembrief != null ? !itembrief.equals(that.itembrief) : that.itembrief != null) return false;
        if (expectresult != null ? !expectresult.equals(that.expectresult) : that.expectresult != null) return false;
        if (exitbasic != null ? !exitbasic.equals(that.exitbasic) : that.exitbasic != null) return false;
        if (memberdemand != null ? !memberdemand.equals(that.memberdemand) : that.memberdemand != null) return false;
        if (releasedate != null ? !releasedate.equals(that.releasedate) : that.releasedate != null) return false;
        if (itemresult != null ? !itemresult.equals(that.itemresult) : that.itemresult != null) return false;
        if (innovate != null ? !innovate.equals(that.innovate) : that.innovate != null) return false;
        if (itemcyle != null ? !itemcyle.equals(that.itemcyle) : that.itemcyle != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemid ^ (itemid >>> 32));
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (itemtype != null ? itemtype.hashCode() : 0);
        result = 31 * result + (itemname != null ? itemname.hashCode() : 0);
        result = 31 * result + (itemleader != null ? itemleader.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (itembrief != null ? itembrief.hashCode() : 0);
        result = 31 * result + (expectresult != null ? expectresult.hashCode() : 0);
        result = 31 * result + (exitbasic != null ? exitbasic.hashCode() : 0);
        result = 31 * result + (memberdemand != null ? memberdemand.hashCode() : 0);
        result = 31 * result + (releasedate != null ? releasedate.hashCode() : 0);
        result = 31 * result + (itemresult != null ? itemresult.hashCode() : 0);
        result = 31 * result + (innovate != null ? innovate.hashCode() : 0);
        result = 31 * result + (itemcyle != null ? itemcyle.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
