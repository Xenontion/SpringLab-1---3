package org.chdtu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("dogBean")
public class Dog implements Pet {

    @Value("${dog.name:Sharik}")
    private String name;

    @Override
    public void say() {
        System.out.println("Woof-woof!");
    }

    @Override
    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
