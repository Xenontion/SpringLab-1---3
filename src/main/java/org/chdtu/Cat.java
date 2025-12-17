package org.chdtu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("catBean")
@Primary
public class Cat implements Pet {

    @Value("${cat.name:Barsik}")
    private String name;

    @Override
    public void say() {
        System.out.println("Meow-meow!");
    }

    @Override
    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Cat: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Cat: destroy method");
    }
}
