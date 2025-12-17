package org.chdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        // Создаем контекст на основе Java-конфигурации
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        // Получаем бин University
        University uni = context.getBean("universityBean", University.class);

        // Выводим информацию о университете и связанных объектах
        System.out.println("University: " + uni.getName());
        System.out.println("Person: " + uni.getPerson().getSurname());
        System.out.println("Pet: " + uni.getPerson().getPet().getName());

        context.close();
    }
}
