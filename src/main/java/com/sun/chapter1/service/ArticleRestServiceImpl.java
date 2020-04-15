package com.sun.chapter1.service;

import com.sun.chapter1.dao.ArticleJDBCDAO;
import com.sun.chapter1.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书服务实现类
 *
 * 实现数据库交互  应该去控制器执行
 */
@Service
public class ArticleRestServiceImpl implements ArticleRestService{
    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    /**
     * 增加的方法
     * @param article
     * @return
     */
    @Transactional
    @Override
    public int saveArticle( Article article) {
       int count= articleJDBCDAO.save(article);
       // articleJDBCDAO.save(article);

        return  count;
    }
    /**
     * 删除的方法
     * @param id
     */
    @Override
    public int deleteArticle(int id) {
        int count=articleJDBCDAO.deleteById(id);
         return count;
    }
    /**
     * 修改的方法
     * @param article
     */
    @Override
    public int updateArticle(Article article) {
        int count=articleJDBCDAO.updateById(article);
         return count;
    }
    /**
     * 带条件的查询
     * @param id
     * @return
     */
    @Override
    public Article getArticle(int id) {
        return  articleJDBCDAO.findById(id);

    }
    /**
     * 无条件的查询
     * @return
     */
    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();

    }
}
