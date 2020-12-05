package kr.or.connect.todolist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.todolist.dao", "kr.or.connect.todolist.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
