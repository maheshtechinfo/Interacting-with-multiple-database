package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.prodrepo",
                                                 entityManagerFactoryRef = "oraEMF",
                                                 transactionManagerRef = "oraTxMgmr")
public class OracleDBConfig {

    private final DataSource createMySQLDS;

    OracleDBConfig(DataSource createMySQLDS) {
        this.createMySQLDS = createMySQLDS;
    }
	
	@Bean(name="oraDS")
	@ConfigurationProperties(prefix = "ora.ds")
	@Primary
	public   DataSource  createOraDS() {
         System.out.println("OracleDBConfig.createOraDS()");
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="oraEMF")
	@Primary
	public  LocalContainerEntityManagerFactoryBean  createEMFBOracle(EntityManagerFactoryBuilder builder) {
		// prepare  JPA properties for  Hibernate
		Map<String,Object> props=new HashMap();
	   props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
	    props.put("hibernate.hbm2ddl.auto", "update");
	    props.put("hibernate.show_sql", "true");
		   
	    return  builder
	    		      .dataSource(createOraDS())
	    		      .packages("com.nt.entity.prodentity")
	    		      .properties(props)
	    		      .build();
	}
	
	@Bean(name="oraTxMgmr")
	@Primary
	public   JpaTransactionManager createTxMgmrForOracle(@Qualifier("oraEMF") EntityManagerFactory  factory) {
		return  new  JpaTransactionManager(factory);
	}


}
