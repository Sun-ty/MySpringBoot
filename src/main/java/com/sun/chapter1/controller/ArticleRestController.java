package com.sun.chapter1.controller;

import com.sun.chapter1.entity.Article;
import com.sun.chapter1.tool.AjaxResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("/rest")
public class HelloController {
    private static Logger log=Logger.getLogger(HelloController.class);

    //增加一篇Article ，使用POST方法
    @RequestMapping(value = "/article",method =POST,produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article){

        String str="name:小明，age：18";
        return null;
    }
    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}",id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {

        //使用lombok提供的builder构建对象
        Article article1 = Article.builder()
                .id(1L)
                .author("zimug")
                .content("spring boot 2.深入浅出")
                .createTime(new Date())
                .title("t1").build();
        return AjaxResponse.success(article1);
    }
}