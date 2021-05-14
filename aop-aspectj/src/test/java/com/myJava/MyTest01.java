package com.myJava;

import com.myJava.bao1.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象  com.sun.proxy.$Proxy8：jdk动态代理对象
        SomeService proxy = (SomeService)ctx.getBean("someService");
//        proxy.doSome("list",20);
//        proxy.doOther("张三",21);
//        System.out.println("=================");
//        String str = proxy.doFirst("王五",23);
//        System.out.println("str的值为"+str);


//        proxy.doSecond();
        proxy.doLast();
    }
}
