package org.edwith.webbe.securityexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

// 레이어드 아키텍처에서 Controller가 사용하는 Beanㄷ르에 대해 설정을 한다.
// dao, service를 컴포넌트 스캔하여 찾도록 한다.
// 어노테이션으로 트랜잭션을 관리하기 위해 @EnableTransactionManagement를 설정하였다.
@Configuration
@ComponentScan(basePackages = {"org.edwith.webbe.securityexam.dao", "org.edwith.webbe.securityexam.service"})
@EnableTransactionManagement
public class ApplicationConfig implements TransactionManagementConfigurer{
	
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	private String url = "jdbc:mysql://localhost:3306/springlogin?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private String username = "root";
    private String password = "0000";
    
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driverClassName);
    	dataSource.setUrl(url);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	
    	return dataSource;
    }
    
    @Bean
	public PlatformTransactionManager transactionManager() {		
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}

}
