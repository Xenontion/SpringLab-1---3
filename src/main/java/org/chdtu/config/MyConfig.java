package org.chdtu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.chdtu")
@EnableAspectJAutoProxy // Залишаємо лише аспекти, якщо вони потрібні
// ВИДАЛЕНО: @EnableJpaRepositories - запобігає дублюванню
// ВИДАЛЕНО: @EnableTransactionManagement - автоматично вмикається JPA starter
public class MyConfig {
    // Усі компоненти JPA (DataSource, EntityManagerFactory, TransactionManager)
    // тепер налаштовуються АВТОМАТИЧНО Spring Boot через application.properties.

    // Якщо вам потрібно було лише увімкнути сканування компонентів,
    // це можна залишити, але @ComponentScan("org.chdtu") може дублювати
    // сканування, яке робить @SpringBootApplication, якщо він знаходиться в корені.
}