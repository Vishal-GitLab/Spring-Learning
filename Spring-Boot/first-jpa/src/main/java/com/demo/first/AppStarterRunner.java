package com.demo.first;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStarterRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {   // ye functional interface hai jo
        System.out.println("Application has started using CommandLineRunner");
    }

}
