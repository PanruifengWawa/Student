package com.my.spring.model;

import javax.persistence.*;

/**
 * Created by nixinan on 2017/1/18.
 */
@Entity
@Table(name = "label")
public class LabelEntity {
    private long userid;
    private String label;

    @Id
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelEntity that = (LabelEntity) o;

        if (userid != that.userid) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userid ^ (userid >>> 32));
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}
