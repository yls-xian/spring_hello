import Service.SomeService;
import Service.SomeServiceImp.SomeServiceImpl;
import com.myJava.handler.MyIncationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
        //使用jdk的Proxy创建代理对象
        SomeService target = new SomeServiceImpl();
        //创建InvocationHandler对象
        InvocationHandler handler = new MyIncationHandler(target);
        SomeService proxy = (SomeService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
        proxy.doSome();
    }
}
