package com.shivam.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

public class hibernateconflict {
	private static final String DB_DRIVER="org.h2.driver";
	private static final String DB_DIALECT="org.hibernate.dialect.H2Dialect";
	private static final String DB_URL="jdbc:h2:tcp://localhost/~/EMP_M_S";
	private static final String DB_USERNAME="sa";
	private static final String DB_PASSWORD="";


@Bean("dataSource")
public DataSource getDataSource() {
	
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	dataSource.setDriverClassName(DB_DRIVER);
	dataSource.setUrl(DB_URL);
	dataSource.setUsername(DB_USERNAME);
	dataSource.setPassword(DB_PASSWORD);
	
	
	
	return dataSource;
	
}

@Bean
public SessionFactory getSessionFactory(DataSource datasource) {
	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
	
	builder.addProperties(getHibernateProperties());
	builder.scanPackages("com.backend.model");
	
	return builder.buildSessionFactory();
	
	
}

private Properties getHibernateProperties() {
	
	Properties properties = new Properties();
	
	properties.put("hibernate.dialect", DB_DIALECT);
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	
	properties.put("hibernate.hbm2ddl.auto", "update");
	
	return properties;
	
}

@Bean
public HibernateTransactionManager getTransactionManager (SessionFactory sessionFactory) {
HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
return transactionManager;
}


}



