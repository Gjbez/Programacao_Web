package maria_db.example;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MariaDBConfig {
    @Bean
    public DataSource dataSource() {
        MariaDBConnectionPoolDataSource dataSource = new MariaDBConnectionPoolDataSource();
        dataSource.setUser("your_username");
        dataSource.setPassword("your_password");
        dataSource.setUrl("jdbc:mariadb://host:port/database");
        return dataSource;
    }
    }
