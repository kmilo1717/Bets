package com.bets.Bets.Models;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
public class Connection {
    public DataSource gDataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/betTest");
        dataSource.setUsername("root");
        dataSource.setPassword(null);
        return dataSource;
    }
}
