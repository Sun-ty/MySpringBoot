package com.sun.chapter1.controller;

import com.sun.chapter1.dao.ArticleJDBCDAO;
import com.sun.chapter1.entity.Article;
import com.sun.chapter1.service.ArticleRestServiceImpl;
import com.sun.chapter1.tool.AjaxResponse;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController //等价于 @Controller + @ResponerBody （发送json请求）
@RequestMapping("/rest")
public class ArticleRestController {
    private static Logger log=Logger.getLogger(ArticleRestController.class);
    private ArticleRestServiceImpl Servicejdbcdao=new ArticleRestServiceImpl();

    @RequestMapping("/hello")
    public String hell0(){
        return "Hello Word!!";
    }

    /*增加一篇Article ，使用POST方法*/
   // @RequestMapping(value = "/article",method =POST,produces = "application/json")
    @PostMapping("/addarticle")  //是@RequestMapping的简写
    public AjaxResponse saveArticle(@RequestBody Article article){
        log.info("saveArticle：{}"+article);
        return  AjaxResponse.success(article);
    }
    //删除一篇Article，使用DELETE方法，参数是id
   // @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/delarticle/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") int id) {
        log.info("deleteArticle：{}"+id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
   // @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/uparticle/{id}")
    public int updateArticle(@PathVariable("id") int id, @RequestBody Article article) {
         int count=Servicejdbcdao.updateArticle(article);
        return count;
    }

    //获取一篇Article，使用GET方法
    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @RequestMapping("/quarticle/{id}")
    public String getArticle(@PathVariable int id) {
        log.debug("==================进入查询方法=================");
        Article ar=new Article();
        ar=Servicejdbcdao.getArticle(id);
        log.debug("id："+ar.getId()+"书籍名称："+ar.getTitle()+"作者："+ar.getAuthor()+"出版时间："+ar.getCreateTime());
        return  "书籍名称："+ar.getTitle();
    }
}