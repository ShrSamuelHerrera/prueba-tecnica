package com.shr.indtx.pruebatecnicainditex.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.shr.indtx.pruebatecnicainditex.app.client")

public class PruebaTecnicaInditexApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaInditexApplication.class, args);
    }

}
