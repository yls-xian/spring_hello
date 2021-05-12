package com.myjava.service.impl;

import com.myjava.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("无参构造方法执行");
    }
    @Override
    public void doSome() {
        System.out.println("执行了SomeService的dosome()方法");
    }
}
