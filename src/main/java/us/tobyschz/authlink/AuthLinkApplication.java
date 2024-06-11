package us.tobyschz.authlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class AuthLinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthLinkApplication.class, args);
    }

}
