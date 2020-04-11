package com.sun.chapter1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
   public int i=0;
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

}
