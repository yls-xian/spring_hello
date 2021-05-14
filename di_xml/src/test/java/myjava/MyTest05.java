package myjava;

import bao5.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test(){
        String config = "bao5/total.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student s1 = (Student) ac.getBean("myStudent");
        System.out.println(s1);
    }
}
