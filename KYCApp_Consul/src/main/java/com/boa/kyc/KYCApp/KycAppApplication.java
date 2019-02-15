package com.boa.kyc.KYCApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.boa.kyc.configurations.DbConfiguration;
import com.boa.kyc.models.MongoTransaction;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages="com.boa.kyc.*")
@EnableJpaRepositories(basePackages="com.boa.kyc.*")
@EnableMongoRepositories(basePackages="com.boa.kyc.*")
@EntityScan(basePackages="com.boa.kyc.*")
//@PropertySource("classpath:application.properties")
public class KycAppApplication {
	
	/*@Autowired
	private DbConfiguration dbConfig;*/
	
	public static void main(String[] args) {
		System.setProperty("dbType", "MongoDB");
		
		String[] appArgs = { "--debug" };
		SpringApplication app = new SpringApplication(KycAppApplication.class);
		app.setLogStartupInfo(false);
		app.run(appArgs);
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		//System.out.println(dbConfig.mongoTransactions());
		// TODO Auto-generated method stub
		for(Object obj : dbConfig.mongoTransactions().getAllTransactions()) {
			MongoTransaction tran = (MongoTransaction) obj;
			System.out.println(tran.getAmount());
		}
		
	}
*/
}

