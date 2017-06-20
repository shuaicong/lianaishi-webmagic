package com.lianaishi;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.lianaishi"})
@MapperScan(basePackages={"com.lianaishi.dao"})
@EnableAutoConfiguration  //开启自动配置
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
