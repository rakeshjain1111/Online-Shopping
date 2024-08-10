package com.rakesh.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value="classpath:application.properties")
@ComponentScan(basePackages = {"com.rakesh.shoppingbackend"})
@EnableTransactionManagement
public class HibernateConfig {
	
	@Autowired
	private Environment env;

    
    @Bean("dataSource")
    public DataSource getDataSource() {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setDriverClassName(env.getProperty("jdbc.drivarClassName"));
    	ds.setUrl(env.getProperty("jdbc.url"));
    	ds.setUsername(env.getProperty("jdbc.username"));
    	ds.setPassword(env.getProperty("jdbc.password"));
    	return ds;
    }
    
    @Bean("sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource ds) {
    	LocalSessionFactoryBean sf =new LocalSessionFactoryBean();
    	sf.setDataSource(ds);
    	sf.setPackagesToScan(new String[] {"com.rakesh.shoppingbackend.dto"});
    	sf.setHibernateProperties(getHibernateProperties());
    	return sf;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		HibernateTransactionManager txManager =new HibernateTransactionManager(sf);
		return txManager;
	}
}	
	
//	private final static String  DATABASE_URL= "jdbc:mysql://localhost:3306/onshop";
//	private final static String  DATABASE_DRIVER= "com.mysql.jdbc.Driver";
//	private final static String  DATABASE_DIALECT= "org.hibernate.dialect.MYSQL8Dialect";
//	private final static String  DATABASE_USERNAME= "root";
//    private final static String  DATABASE_PASSWORD= "root";
   
	
	
//	@Bean("dataSource")
//	public DataSource getDataSource() {
//		BasicDataSource dataSource =new BasicDataSource();
//		dataSource.setDriverClassName(DATABASE_DRIVER);
//		dataSource.setUrl(DATABASE_URL);
//		dataSource.setUsername(DATABASE_USERNAME);
//		dataSource.setPassword(DATABASE_PASSWORD);
//		return dataSource;
//	}
	
//	@Bean
//	public SessionFactory getSessionFactory(DataSource ds) {
//		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(ds);
//		builder.addProperties(getHibernateProperties());
//		builder.scanPackages("com.rakesh.shoppingbackend.dto");
//		return builder.buildSessionFactory();
//	}
	
//	@Bean
//	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
//		HibernateTransactionManager txManager =new HibernateTransactionManager(sf);
//		return txManager;
//	}
	

