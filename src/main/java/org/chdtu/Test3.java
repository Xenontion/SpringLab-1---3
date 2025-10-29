package org.chdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University uni = context.getBean("universityBean", University.class);

        Person person = uni.getPerson();

        System.out.println("\n=== OUTPUT ===");
        System.out.println("University: " + uni.getName());

        // Виводимо повне ім'я: ім'я + прізвище
        System.out.println("Person: " + person.getName() + " " + person.getSurname());

        System.out.println("Pet: " + person.getPet().getName());

        context.close();
    }
}
