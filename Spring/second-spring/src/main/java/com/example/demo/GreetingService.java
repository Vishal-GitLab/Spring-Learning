package com.example.demo;


import org.springframework.stereotype.Component;

@Component ("myBean")      // component ak aisa annotation hai jo  ak class ko manage kar sakta hai
public class GreetingService {
    public void sayHello() {
        System.out.println("Hello from Spring");
    }
}
