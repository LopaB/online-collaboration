package com.coll.OnlineCollaborateBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.coll.OnlineCollaborateBackEnd"})
@EnableTransactionManagement
public class HibernateConfig {
	//Database related information
		public static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:orcl1";
		public static final String DATABASE_DRIVER="oracle.jdbc.driver.OracleDriver";
		public static final String DATABASE_DIALECT="org.hibernate.dialect.Oracle10gDialect";
		public static final String DATABASE_USERNAME="collaborate";
		public static final String DATABASE_PASSWORD="collab";
		
		@Bean(name="dataSource")
		public DataSource getDataSource(){
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUrl(DATABASE_URL);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
			//datasource bean will be available
			return dataSource;
		}

		//sessionFactory will be available
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource){
			LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.coll.OnlineCollaborateBackEnd");
			return builder.buildSessionFactory();
		}
		//All the hibernate properties will be returned by this method
		public Properties getHibernateProperties(){
			Properties prop=new Properties();
			prop.put("hibernate.dialect", DATABASE_DIALECT);
			prop.put("hibernate.show_sql", "true");
			prop.put("hibernate.hbm2ddl.auto", "update");
			prop.put("hibernate.format_sql", "true");
			return prop;
		}
		//Transaction Management
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
			return transactionManager;
			
		}


}
