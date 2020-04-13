package com.sun.chapter1.entity;

import javafx.scene.NodeBuilder;

import java.util.Date;

/**
 * 物品类
 */
public class Article {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;

    //构造函数


    public Article(Long id, String author, String title, String content, Date createTime) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    //封装
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
