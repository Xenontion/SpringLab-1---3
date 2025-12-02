package org.chdtu;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet {

    private String name = "Барбос";

    @Override
    public void say() {
        System.out.println("Собака каже: Гав-гав!");
    }

    @Override
    public String getName() {
        return name;
    }

    public void init() {
        System.out.println("Class Dog: init method");
    }

    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
