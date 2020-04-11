package com.sun.chapter1;
/**
 * 这个类为整个项目的启动类
 * 而且也是创建SpringBoot项目时自动创建的启动类
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //声明此应用程序为SpringBoot工程
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}
