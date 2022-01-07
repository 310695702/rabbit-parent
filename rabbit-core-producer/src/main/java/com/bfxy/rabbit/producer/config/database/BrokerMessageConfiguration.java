package com.bfxy.rabbit.producer.config.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * 执行sql创建数据库
 *
 * @author: HanYuXing
 * @date: 2022-01-07 10:09
 **/
@Configuration
public class BrokerMessageConfiguration {

    @javax.annotation.Resource
    private DataSource rabbitProducerDataSource;

    @Value("classpath:rabbit-producer-message-schema.sql")
    private Resource schemaScript;

    @Bean
    public DataSourceInitializer initDataSourceInitializer() {
        System.err.println("--------------rabbitProducerDataSource-----------:" + rabbitProducerDataSource);
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(rabbitProducerDataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        return populator;
    }
}
