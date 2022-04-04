package com.example.protocolapp;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ProtocolAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProtocolAppApplication.class, args);
        try {
            Console.main(args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
