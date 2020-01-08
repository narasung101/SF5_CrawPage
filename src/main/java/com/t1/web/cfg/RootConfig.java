package com.t1.web.cfg;

import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.t1.web"})
@MapperScan(basePackages= {"com.t1.web"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {

	HikariConfig hikariConfig = new HikariConfig();
	hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
	hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/mysql");
	hikariConfig.setUsername("getmoney");
	hikariConfig.setPassword("getmoney");
	HikariDataSource dataSource = new HikariDataSource(hikariConfig);
	return dataSource;
}
}