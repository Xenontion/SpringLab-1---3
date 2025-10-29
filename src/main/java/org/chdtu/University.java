package org.chdtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("universityBean")
public class University {

    @Value("${university.name:CHDTU}")
    private String name;

    private final Person person;

    @Autowired
    public University(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    @PostConstruct
    public void init() {
        System.out.println("Class University: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class University: destroy method");
    }
}
