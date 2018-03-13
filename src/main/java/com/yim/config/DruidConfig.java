package com.yim.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
*@author:   yim
*@date:  2018年3月12日下午4:10:02
*@decription:   阿里巴巴数据库连接池配置
*/
@Configuration
@PropertySource(value = "classpath:application.yml")
public class DruidConfig {
	
	@Bean(destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource")
	public javax.sql.DataSource createDruidDataSource() {
		return new DruidDataSource();
	}
}
