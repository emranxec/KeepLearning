package com.xec.spring.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfig {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private Student s1;

    @Autowired
    private Student s2;

    @Autowired
    @Qualifier("s7")
    private Student s7;

    @Bean(name = "s7")
    public Student s7(){
        return new Student();
    }
    @Bean("s3")
    public Student s3(){
        return new Student();
    }

    @Bean("s4")
    public Student s4(){
        return new Student();
    }

    @Bean
    public void testSingleton(){
        s1.setName("imran");
        s2.setName("ayesha");
        System.out.println("are s1 & s2 is equal? " + (s1==s2));
        Student s3= (Student) context.getBean("s3");
        s3.setName("salman");
        Student s4= (Student) context.getBean("s4");
        s4.setName("imtiaz");
        System.out.println("are s3 & s4 is equal? " + (s3==s4));
        System.out.println("are s1 & s4 is equal? " + (s1==s4));
        Student s5 = new Student();
        s5.setName("ibrahim");
        Student s6 = new Student();
        s6.setName("aman");
        s7.setName("heena");
        System.out.println("are s5 & s6 is equal? " + (s5==s6));
        System.out.println("s1 name " + s1.getName());
        System.out.println("s2 name " + s2.getName());
        System.out.println("s3 name " + s3.getName());
        System.out.println("s4 name " + s4.getName());
        System.out.println("s5 name " + s5.getName());
        System.out.println("s6 name " + s6.getName());
        System.out.println("s7 name " + s7.getName());
    }
}
