package com.RubenA.GestorTareas;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSouerceConfig {
	@Bean
    public DataSource datasource() {
		return DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://localhost:3306/gestiontareas?serverTimezone=UTC")
            .username("root")
            .password("root")
            .build();
	}
}
