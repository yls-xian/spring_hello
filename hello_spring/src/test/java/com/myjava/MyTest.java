package com.myjava;

import com.myjava.service.SomeService;
import com.myjava.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test1(){
        //不利用注解的方式创建对象
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    /***
     * spring默认创建对象时，在创建Spring容器时，创建配置文件中的所有对象
     */
    @Test
    public void test2(){
        //通过spring构造对象
        //1.指定spring配置文件的名称
        String config = "beans.xml";
        //2.创建表示Spring容器的对象
        //ApplicationContext就是表示Spring的容器，通过容器获取对象
        //ClassPathXmlApplicationContext代表从类路径中加载Spring的配置文件
        ApplicationContext  ac =  new ClassPathXmlApplicationContext(config);

        //3.从容器中获取对象，调用对象的方法
        //getBean("配置文件中的bean的id值")由于返回的是object，因此需要转换为你需要的类型
        SomeService service = (SomeService) ac.getBean("someService");
        //使用Spring创建好的对象调用接口的方法
        service.doSome();
    }
    /**
     * 获取Spring容器中java对象的信息
     */
    @Test
    public void test3(){

        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取容器中对象的数量
        int num = ac.getBeanDefinitionCount();
        System.out.println(num);
        //获取容器中定义的每个对象的名称
        String [] names = ac.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }

    }
    /**
     * 获取一个非自定义的对象
     */
    @Test
    public void test4(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date mydate = (Date) ac.getBean("mydate");
        System.out.println(mydate);
    }
}
