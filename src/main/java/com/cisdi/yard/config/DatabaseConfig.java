//package com.cisdi.yard.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.cisdi.yard.db.repository.SpringScheduledCronRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//
///**
// * @author meisen
// * @since 2021-05-10
// */
//@Configuration
//@EnableJpaRepositories(basePackageClasses = SpringScheduledCronRepository.class)
//public class DatabaseConfig {
//    @Value("${spring.datasource.driverClassName}")
//    private String driverClassName;
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setInitialSize(10);
//        dataSource.setMaxActive(20);
//        dataSource.setMaxWait(10000);
//        dataSource.setDefaultAutoCommit(true);
//        dataSource.setRemoveAbandoned(true);
//        dataSource.setTestOnBorrow(true);
//        dataSource.setValidationQuery("select now()");
//        return dataSource;
//    }
//
//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//}