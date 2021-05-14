package com.myJava.bao1;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {

        //给doSome方法增加一个功能，在doSome（）执行之前，输出方法的执行时间
        System.out.println("=====目标方法doSome()======");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("=====目标方法doOther()方法");
        return "abc";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("======业务方法doFirst()======");
        return "doFirst";
    }

    @Override
    public void doSecond() {
        System.out.println("doSecond方法"+ 10/0);
    }

    @Override
    public void doLast() {
        System.out.println("最终通知方法");
    }
}
