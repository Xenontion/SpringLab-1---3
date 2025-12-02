package org.chdtu;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.chdtu")
@PropertySource("classpath:university.properties") // тут вказуємо файл properties
@EnableAspectJAutoProxy
public class MyConfig {
}