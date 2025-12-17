package org.chdtu.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // Pointcut на всі методи збереження (save) у будь-якому сервісі
    @Pointcut("execution(* org.chdtu.services.*.save*(..))")
    public void saveMethods() {}

    // Pointcut на будь-який метод у UniversityService
    @Pointcut("execution(* org.chdtu.services.UniversityService.*(..))")
    public void universityServiceMethods() {}

    // Pointcut на видалення (delete)
    @Pointcut("execution(* org.chdtu.services.*.delete*(..))")
    public void deleteMethods() {}

    @Before("saveMethods()")
    public void beforeSaveAdvice() {
        System.out.println("[AOP] Спроба збереження нового об'єкта через сервіс...");
    }

    @Before("universityServiceMethods()")
    public void beforeUniversityAdvice() {
        System.out.println("[AOP Univ] Робота з даними університету");
    }

    @After("deleteMethods()")
    public void afterDeleteAdvice() {
        System.out.println("[AOP After] Операція видалення успішно завершена");
    }
}