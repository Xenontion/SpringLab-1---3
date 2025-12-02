package org.chdtu.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // ===== POINTCUTS =====
    @Pointcut("execution(* org.chdtu.Person.get*(..))")
    public void getterMethods() {}

    @Pointcut("execution(* org.chdtu.Person.callPet(..))")
    public void callPetMethod() {}

    @Pointcut("execution(* org.chdtu.University.*(..))")
    public void universityAllMethods() {}

    // ===== ADVICES =====

    // 1) Перед усіма геттерами Person
    @Before("getterMethods()")
    public void beforeGetterAdvice() {
        System.out.println("[AOP Before] Викликається геттер у класі Person");
    }

    // 2) Перед будь-яким методом University
    @Before("universityAllMethods()")
    public void beforeUniversityAdvice() {
        System.out.println("[AOP Univ] Викликано метод університету");
    }

    // 3) Після завершення callPet()
    @After("callPetMethod()")
    public void afterCallPetAdvice() {
        System.out.println("[AOP After] Метод callPet() завершився");
    }
}
