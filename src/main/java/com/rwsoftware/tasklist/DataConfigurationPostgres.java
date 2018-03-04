package com.rwsoftware.tasklist;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("postgres")
public class DataConfigurationPostgres {
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/springboot");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        return dataSource;
    }
    
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
       // adapter.setDatabasePlatform("org.hibernate.dialect.postgresqldialect");
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");
        adapter.setPrepareConnection(true);
        return adapter;
        
    }
    
    
    

}
