package org.chdtu;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("catBean")
public class Cat implements Pet {

    private String name = "Мурчик";

    @Override
    public void say() {
        System.out.println("Кіт каже: Мяу-мяу!");
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
