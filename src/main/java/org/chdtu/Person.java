package org.chdtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("personBean")
public class Person {

    @Value("${person.name}")
    private String name;

    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private Integer age;

    @Autowired
    @Qualifier("catBean") // вибираємо конкретного Pet
    private Pet pet;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Integer getAge() { return age; }
    public Pet getPet() { return pet; }

    public String getFullName() { return name + " " + surname; }

    public void callPet() {
        System.out.println(getFullName() + " кличе свого улюбленця...");
        pet.say();
    }

    @PostConstruct
    public void init() { System.out.println("Class Person: init method"); }

    @PreDestroy
    public void destroy() { System.out.println("Class Person: destroy method"); }
}
