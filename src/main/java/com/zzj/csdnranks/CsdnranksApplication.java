package com.zzj.csdnranks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CsdnranksApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsdnranksApplication.class, args);
    }

}
