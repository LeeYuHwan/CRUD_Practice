package org.edwith.webbe.securityexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

// 레이어드 아키텍처에서 Controller가 사용하는 Bea들에 대해 설정을 한다.
// dao, service를 컴포넌트 스캔하여 찾도록 한다.
// 어노테이션으로 트랜잭션을 관리하기 위해 @EnableTransactionManagement를 설정하였다.
@Configuration
@ComponentScan(basePackages = {"org.edwith.webbe.securityexam.dao", "org.edwith.webbe.securityexam.service"})
@EnableTransactionManagement
public class ApplicationConfig implements TransactionManagementConfigurer {
	
	// mysql Driver 클래스를 메모리에 로드 시키기 위한 변수 지정
	private String driverClassName = "com.mysql.cj.jdbc.Driver";

	// DB와 커넥션 맺기 위한 정보
    private String url = "jdbc:mysql://localhost:3306/springlogin?useSSL=false&serverTimezone = UTC&useUnicode=true&characterEncoding=UTF-8";;
    private String username = "root";
    private String password = "0000";
    
    
    // 커넥션 풀을 잘 조정할 DataSource Bean 등록
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driverClassName);
    	dataSource.setUrl(url);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	
    	return dataSource;
    }
    
    // 애노테이션 기반의 트랜잭션 관리자를 설정
    @Bean
    public PlatformTransactionManager transactionManager() {
    	return new DataSourceTransactionManager(dataSource());
    }
    
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}

}
