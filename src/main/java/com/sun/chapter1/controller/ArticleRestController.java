package com.sun.chapter1.controller;

import com.sun.chapter1.entity.Article;
import com.sun.chapter1.tool.AjaxResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    private static Logger log=Logger.getLogger(ArticleRestController.class);

    //增加一篇Article ，使用POST方法
    @RequestMapping(value = "/article",method =POST,produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article){
        log.info("saveArticle：{}"+article);
        return  AjaxResponse.success(article);
    }
    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle：{}"+id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}"+article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable("id")  Long id) {

        Article article=new Article(1L,"zimug","t1","spring boot2 深入浅出",new Date());
        return AjaxResponse.success(article);
    }
}