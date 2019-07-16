package com.jackting.mvpdaggerarch.bean.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Article {
    public int id;
    public String title;
    public String desc;
    public String niceDate;
    public String link;
    public String author;
    public long publishTime;
    @Generated(hash = 146783217)
    public Article(int id, String title, String desc, String niceDate, String link,
            String author, long publishTime) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.niceDate = niceDate;
        this.link = link;
        this.author = author;
        this.publishTime = publishTime;
    }
    @Generated(hash = 742516792)
    public Article() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getNiceDate() {
        return this.niceDate;
    }
    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getPublishTime() {
        return this.publishTime;
    }
    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }
}
