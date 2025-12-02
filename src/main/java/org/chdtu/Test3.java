package org.chdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University uni = context.getBean("universityBean", University.class);

        System.out.println("\n=== OUTPUT ===");
        System.out.println("University: " + uni.getName());
        System.out.println("Person: " + uni.getPerson().getFullName());
        System.out.println("Pet: " + uni.getPerson().getPet().getName());

        uni.getPerson().callPet();

        context.close();
    }
}
