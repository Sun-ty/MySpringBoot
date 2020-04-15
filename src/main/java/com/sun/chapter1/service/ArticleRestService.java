package com.sun.chapter1.service;

import com.sun.chapter1.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书服务接口
 */

public interface ArticleRestService {
    public int saveArticle(Article article);

    public int deleteArticle(int id);

    public int updateArticle(Article article);

    public Article getArticle(int id);

    public List<Article> getAll();
}
