package com.sun.chapter1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.scene.NodeBuilder;

import java.util.Date;

/**
 * 图书类
 */
public class Article {
    private int id;
    private String author;
    private String title;
    private String content;
    //同Spring MVC不能自动转换日期格式。可以在application.yml中进行全局配置
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //构造函数
    public Article(){}

    public Article(int id, String author, String title, String content, Date createTime) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    //封装
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
