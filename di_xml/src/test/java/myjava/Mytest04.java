package myjava;

import bao4.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest04 {
    @Test
    public void test(){
        String config = "bao4/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student s1 = (Student) ac.getBean("myStudent");
        System.out.println(s1);
    }
}
