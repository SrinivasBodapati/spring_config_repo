package com.boa.kyc.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.core.net.SyslogOutputStream;

@Configuration
public class DbConfiguration {
	
	@Value("${dataSource.url}")
	String dataSource;
	
	@Value("${db.user}")
	String user;
	
	@Value("${db.password}")
	String password;
	
	
	@Bean
	@ConditionalOnClass(DataSource.class)
	public DataSource getMysqlDataSource() {
		System.out.println("In SQL data source");
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(dataSource);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(password);
		
		return dataSourceBuilder.build();
		
	}
	
	@Bean
	@Conditional(JDBCDataTypeCondition.class)
	public TransactionData jdbcTransactions() {
		System.out.println("Entering jdbc ...");
		return new JDBCTransactionImpl();
	}
	
	@Bean
	@Conditional(MongoDataTypeCondition.class)
	public TransactionData mongoTransactions() {
		System.out.println("Entering mongodb ...");
		return new MongoTransactionImpl();
	}
}
