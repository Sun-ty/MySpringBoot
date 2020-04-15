package com.sun.chapter1.tool;

import com.sun.chapter1.entity.Article;
import com.sun.chapter1.service.ArticleRestServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试JDBC数据库连接
 * 进行单元测试必须加上这两个注释
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJDBC {
    private Logger log=Logger.getLogger(TestJDBC.class);
    //数据源

    @Autowired
     DataSource dataSource;
    @Test
    public void Test() throws SQLException {
     ArticleRestServiceImpl ars=new ArticleRestServiceImpl();
     Article ar=new Article();
     ar=ars.getArticle(1);
     log.debug("id："+ar.getId()+"书籍名称："+ar.getTitle()+"作者："+ar.getAuthor()+"出版时间："+ar.getCreateTime());
    }
}*/
