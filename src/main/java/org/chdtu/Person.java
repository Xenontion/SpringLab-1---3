package org.chdtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("personBean")
public class Person {

    @Value("${person.name:Oleh}")
    private String name;

    @Value("${person.surname:Sasko}")
    private String surname;

    @Value("${person.age:20}")
    private int age;

    @Autowired
    @Qualifier("dogBean") // або "catBean"
    private Pet pet;

    // 🔹 Гетери
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Pet getPet() {
        return pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely pet!");
        pet.say();
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Person: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Person: destroy method");
    }
}
