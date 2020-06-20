package com.nacos.config.nacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
@RefreshScope
public class NacosConfigApplication  implements CommandLineRunner {

    @Value("${user.name}")
    private String userName;


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);


        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.out.println("username :"+userName+"; age: "+userAge);

        //===========

        String env = applicationContext.getEnvironment().getProperty("env");
        System.out.println(env);


        String test = applicationContext.getEnvironment().getProperty("test");
        System.out.println(test);

//        TimeUnit.SECONDS.sleep(3);


        System.out.println("userName：" + userName);


        //   自定义扩展的 Data Id 配置
        String ext = applicationContext.getEnvironment().getProperty("ext");
        System.out.println(ext);

        String ext02 = applicationContext.getEnvironment().getProperty("ext02");
        System.out.println(ext02);

        String ext03 = applicationContext.getEnvironment().getProperty("ext03");
        System.out.println(ext03);


        // 支持共享的 Data Id
        String common = applicationContext.getEnvironment().getProperty("common");
        System.out.println(common);


    }


    @Override
    public void run(String... args) throws Exception {
        System.out.printf("启动完成");
    }



}
