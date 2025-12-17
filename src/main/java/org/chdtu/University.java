package org.chdtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("universityBean")
public class University {

    @Value("CHDTU")
    private String name;

    @Autowired
    private Person person;

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }
}
