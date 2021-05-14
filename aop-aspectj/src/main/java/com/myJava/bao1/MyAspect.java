package com.myJava.bao1;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAspect {
    /**
     * @Aspect表示当前类是切面类，aspectj框架中的注解
     * 切面类:用来给业务方法增加功能的类，在这个类中有切面的功能代码
     * 在类定义的上面
     */

    /**
     * 定义方法，实现切面功能
     * 1.pubLic
     * 2.没有返回值
     * 3.自定义名称
     * 4.可以有参数，可以没有
     * 如果有参数，参数不是自定义的，个别的参数类型可以使用
     */
    /***
     * @Before()前置通知注解
     * value:切入点表达式，表示切面的执行位置
     * 1.在目标方法执行之前
     * 2.不会改变目标方法的执行结果
     * 3.不会影响目标方法的执行
     */

//    @Before(value = "execution(void com.myJava.bao1.SomeServiceImpl.doSome(String,Integer))")
//    @Before(value = "execution(void *..SomeServiceImpl.doSome(String,Integer))")
//    @Before(value = "execution(void *..SomeServiceImpl.do*(..))")
    /**
     * 指定通知方法中的参数：JoinPoint
     * JoinPoint业务方法，要加入切面功能的业务方法
     *  作用是：可以在通知方法中获取方法执行时的信息，例如方法名称，方法实参
     *  如果你的切面中需要用到方法的信息，加入此参数
     *  该参数的值是由框架赋予的，因此必须是第一个位置的参数
     */
    @Before(value = "execution(public void com.myJava.bao1.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore(JoinPoint jp){
//        System.out.println(jp.getSignature()+"方法的签名（定义）");
//        System.out.println(jp.getSignature().getName()+"方法的名称");
//        Object [] args = jp.getArgs();
//        for(Object arg : args){
//            System.out.println("参数"+arg);
//        }
        System.out.println("切面功能：在目标方法执行之前输出时间"+new Date());
    }

    /**
     @AfterReturning()后置通知注解
      * value:切入点表达式，表示切面的执行位置
      * returning :自定义变量，表示目标方法的返回值。
      *     自定义变量必须与通知方法的形参名一样
      * 1.在目标方法执行之后
      * 2.获取目标方法的返回值，根据返回值做不同的处理功能
      * 3.可以修改返回值
     */
    @AfterReturning(value = "execution(public String com.myJava.bao1.SomeServiceImpl.doOther(String,Integer))",returning = "res")
    public void myAfterReturing(JoinPoint jp,Object res){
        //Object res = do.Other()的返回值
        System.out.println("后置通知，在目标方法之后"+res);
    }


    /**
     * 环绕通知方法的定义格式
     * 1.pubLic
     * 2.必须有一个返回值，推荐使用Object
     * 3.方法名称自定义
     * 4.方法有参数，固定参数ProceedingJoinPoint
     *
     * 环绕通知：
     *          属性value切入点表达式
     *          位置：在方法的定义什么
*       特定：
     *       1.功能最强的通知
     *       2.在目标方法的前和后都能增强功能
     *       3.控制目标方法是否被调用执行
     *       4.修改原来的目标方法的执行结果。影响最后的调用结果
 *       等同于动态代理中的InvocationHandler接口
     *       ProceedingJoinPoint 等同于method
     *       作用执行目标方法的
     *       返回值；目标方法的执行结果可以修改
     *
     */
    @Around(value="execution(String com.myJava.bao1.SomeServiceImpl.doFirst(String,Integer))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object res = null;
        Object [] args  = pjp.getArgs();
        String name = "";
        if(args != null && args.length >1){
            Object arg = args[0];
            name = (String) arg;
        }
        System.out.println("环绕通知，在目标方法之前，输出时间"+new Date());
        //目标方法带哦用
        if("王五".equals(name)) {
            res = pjp.proceed();//method.invoke()  Object res = doFirst()
            //在目标方法的前后者后加功能

        }
        System.out.println("环绕通知，在目标方法之后，提交事务");
        if(res!=null){
            res = "xin";
        }
        return res;
    }

    /***
     *异常通知
     * 1.pubLic
     * 2.没有返回值
     * 3.自定义名称
     * 4.可以有参数，可以没有
     *  如果有参数是JoinPoint
     *
     *
     *  @AfterThrowing
     *      属性1.value切入点表达式
     *      2.throwing自定义变量，表示目标抛出的异常对象，变量名必须和方法的参数名一样
 *      特点：
     *      1.在目标方法抛出异常时执行
     *      2.可以做异常的监控程序，监控目标方法执行时是否有异常
     *      如果有异常可以发送邮件，短信进行通知
     *
     *       /**
     *          * 异常方法的执行，一般是
     *          * try{
     *          *    目标方法的执行
     *          * }
     *          * catch(Exception e){
     *          *     异常方法的执行
     *          * }
     *          */

    @AfterThrowing(value = "execution(void com.myJava.bao1.SomeServiceImpl.doSecond())",
            throwing = "ex")
    public void myAfterThrowing(Exception ex){
        System.out.println("异常通知:方法发生异常时，执行;"+ex.getMessage());


        //发送邮件或者短信

    }

    /**
     * 最终通知方法的定义格式
     * 1.pubLic
     * 2.没有返回值
     * 3.自定义名称
     * 4.可以有参数，可以没有
     *  如果有参数是JoinPoint
     *
     * @After:最终通知
     * 属性value切入点表达式
     *
     *
     *
     * 总是会执行
     * 在目标方法之后执行
     * 类似
     * finally中的方法
     *
     */
//    @After(value="execution(void com.myJava.bao1.SomeServiceImpl.doLast())")
    @After(value="mypt()")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行的代码");
        //一般做资源清除工作
    }
    /**
     * @Pointcut:定义管理切入点的，项目中多个切入点表达式可以重复，可以服用
     * value切入点表达式
     * 位置：自定义的方法上面
     *
     * 使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名
     * 其他的通知中，value属性可以使用这个名称，代替切入点表达式
     */
    @Pointcut(value="execution(* *..SomeServiceImpl.doLast(..))")
    public void mypt(){

    }
}
