package myjava;


import bao1.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {


    @Test
    public void test3(){

        String config = "bao1/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student s1 = (Student) ac.getBean("myStudent");
        System.out.println(s1);
        Date d1 =(Date)ac.getBean("myDate");
        System.out.println(d1);

    }
}
