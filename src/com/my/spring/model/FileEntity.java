package com.my.spring.model;

import javax.persistence.*;

/**
 * Created by nixinan on 2017/2/14.
 */
@Entity
@Table(name = "file")
public class FileEntity {
    private long id;
    private String name;
    private Integer type;
    private String intro;
    private String src;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Basic
    @Column(name = "imgsrc")
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

   
}
