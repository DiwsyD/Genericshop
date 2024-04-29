package com.stepit.lecture.genericshop;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Log4j2
@SpringBootApplication
@EnableJpaRepositories
public class GenericShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericShopApplication.class, args);
    }

}
