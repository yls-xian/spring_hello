package com.myJava;


import com.myJava.bao1.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest01 {
    @Test
    public void test1(){
        String config = "bao1/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println(student);
    }
}
