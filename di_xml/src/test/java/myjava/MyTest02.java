package myjava;

import bao2.School;
import bao2.Student;
import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test(){
        Student s1 = new Student();
        s1.setId(12);
        s1.setName("Tom");
        School school = new School();
        school.setName("一中");
        school.setAddress("北京");
        s1.setSchool(school);
        System.out.println(s1);
    }
    @Test
    public void test2(){
        String config = "bao2/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student s1 = (Student) ac.getBean("myStudent");
        System.out.println(s1);
    }
}
