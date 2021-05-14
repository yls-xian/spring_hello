package com.myJava.bao2;
import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component(value="myStudent")
//@Component("myStudent")
//@Component
public class Student {
    /***
     * @Component：创建对象的，等同于<bean>的功能
     * 属性value就是对象的名称，也就是bean的id值。
     * value的值是唯一的。
     * 位置：在类的对象上用，
     * @Component(value="myStudent")等同于  --->value可以省略
     * 甚至可以仅仅只写个@Component,但是getBean()参数需要类名首字母小写
     * <bean id="myStudent"class="com.myJava.bao1.Student"></bean>
     *
     *
     *
     * Spirng中和@Component功能一致，创建对象的注解还有
     * @Repository(用在持久层类的上)放在dao的实现类上面。表示创建dao对象，dao对象访问数据库     *
     * @Service （放在业务层类上）service的实现类上面，
     * 创建service对象，做业务处理，可以有事务等功能
     * @Controller（控制器的上面）放在控制器类的上，创建控制器对象的，接收用户提交的参数，显示请求的结果
     * 三个注解使用语法和@Component一样。都能创建对象，但是具有额外的功能
     * 给项目的对象分层。
     */
    /**
     * 基本类型赋值@Value(可以省略其中的value值)
     * 可以放在属性上面赋值，无需set方法，推荐使用
     * 在set方法上面进行赋值
     *
     * 引用类型赋值
     * @Autowired:spring框架提供的注解，实现引用类型的赋值
     * spring通过注解给引用类型赋值，使用的是自动注入原理，支持byName,byType
     * @Autowired:默认使用的是byType自动注入
     *      属性：required，是一个boolean类型，默认是true
     *      required=true:表示引用的类型赋值失败时，程序报错，终止执行
     *      required=false：表示引用的类型赋值失败时，程序正常执行，引用类型为Null
     *
     * 位置1）在属性定义的上面，无需set方法，推荐使用
     * 2）在set方法的上面0
     *
     * 使用byName方式：
     * 1.属性前加@Autowired
     * 2.属性上加@Qualifier(value="bean的id")，表示使用指定名称的bean完成
     *
     *
     * 引用类型赋值：
     * @Resource 来自jdk中的注解，spring框架提供对这个注解的功能支持，可以使用它给引用类型赋值
     *           使用的也是自动注解原理，支持byName,byType,默认byName
     * 位置：1：在属性定义的上面，无需set方法，推荐使用
     * 2、在set方法上
     * 默认使用byName:先使用byName自动注入，如果byName赋值失败，再使用byType
     */
    @Value("张三")
    private String name;
    @Value(value = "12")
    private Integer age;

//    @Autowired
//    @Qualifier("mySchool")
    @Resource(name = "mySchool")
    private School school;

    public Student(){
        System.out.println("无参构造器");
    }
    @Value("李四")
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
