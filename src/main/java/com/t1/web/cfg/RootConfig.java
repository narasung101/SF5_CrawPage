package com.t1.web.cfg;

import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.t1.web"})
@MapperScan(basePackages= {"com.t1.web"})
@Import({
	ServletConfig.class, MyBatisConfig.class, 
})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();

  	dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
    dataSource.setUrl("jdbc:mariadb://localhost:3306/mysql");
    dataSource.setUsername("getmoney");
    dataSource.setPassword("getmoney");

//	HikariConfig hikariConfig = new HikariConfig();
//	hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
//	hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/mysql");
//	hikariConfig.setUsername("getmoney");
//	hikariConfig.setPassword("getmoney");
//	HikariDataSource dataSource = new HikariDataSource(hikariConfig);
    		
	return dataSource;
}
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}