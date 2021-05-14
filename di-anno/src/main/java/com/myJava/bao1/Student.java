package com.myJava.bao1;
import org.springframework.stereotype.Component;


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
    private String name;
    private Integer age;

    public Student(){
        System.out.println("无参构造器");
    }
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
                '}';
    }
}
