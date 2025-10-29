package org.chdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Pet pet = context.getBean("dogBean", Pet.class);
        pet.say();

        context.close();
    }
}
