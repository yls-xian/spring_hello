package myjava;

import bao3.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
    @Test
    public void test(){
        String config = "bao3/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student s1 = (Student) ac.getBean("myStudent2");
        System.out.println(s1);
        File file = (File) ac.getBean("myFile");
        System.out.println(file);
    }
}
