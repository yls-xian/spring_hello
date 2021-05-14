package com.myJava.handler;

import util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {
    //目标对象
    private Object target;//SomeServiceImpl类


    public MyIncationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        //通过代理对象执行方法时，会调用执行这个invoke()
        Object res = null;
        //执行目标类的方法，通过Method类实现。

        ServiceTools.doLog();
        res = method.invoke(target,args);//SomeServiceImpl.doOther(),doSome()
        ServiceTools.doTrans();
        //目标方法执行结果
        return res;
    }
}
