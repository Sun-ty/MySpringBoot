package com.sun.chapter1.dao;

import com.sun.chapter1.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * JDBC连接层
 * 以图书为例
 */
@Repository  //对应数据访问层Bean
public class ArticleJDBCDAO {

    /*
    JdbcTemplate主要提供以下五类方法：
        execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
        update方法及batchUpdate方法：update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
        query方法及queryForXXX方法：用于执行查询相关语句；
        call方法：用于执行存储过程、函数相关语

        jdbcTemplate 是springboot的核心文件  用来简化数据库操作,内部定义了很多避免错误的机制
        springboot自动注入数据源,使用它不用管理数据源,也不用管理关闭问题


     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //保存文章
    public int save(Article article) {

        //jdbcTemplate.update适合于insert 、update和delete操作；
        int count= jdbcTemplate.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
        return count;
    }

    //删除文章
    public int deleteById(int id){
        //jdbcTemplate.update适合于insert 、update和delete操作；
        int count= jdbcTemplate.update("DELETE FROM article WHERE id = ?",new Object[]{id});
        return count;
    }



    //更新文章
    public int updateById(Article article) {

        //jdbcTemplate.update适合于insert 、update和delete操作；
       int count= jdbcTemplate.update("UPDATE article SET author = ?, title = ? ,content = ?,create_time = ? WHERE id = ?",

                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
        return count;
    }



    //根据id查找文章
    public Article findById(int id) {

    //BeanPropertyRowMapper:它是用来映射Java对象的属性和MySQL表的字段名称的
    //queryForObject用于查询单条记录,查询的结果以对象类型返回。如果返回int类型(例：select count(*) from tb)，那么第三个参数应该写integer.class

        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper(Article.class));
    }

    //查询所有
    public List<Article> findAll(){

        //query用于查询结果列表
        return (List<Article>) jdbcTemplate.query("SELECT * FROM article ",  new BeanPropertyRowMapper(Article.class));

    }

}
