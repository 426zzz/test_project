package org.lyz.test_project.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 接口
interface Person{
    void clean();
    void getMoney();
}
// 商人
class BuissnessMan implements Person{
    @Override
    public void getMoney() {
        System.out.println("催账");
    }
    @Override
    public void clean() {
        System.out.println("洗钱");
    }
}
// 黑社会代理一切Person
class Gangdom<T> implements InvocationHandler{
    T target;
    public Gangdom(T target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if(method.getName().equals("getMoney")){
            System.out.println("准备家伙");
            // 需要指定方法代理的情况
            result = method.invoke(this.target, args);
            System.out.println("清理现场");
        }else {
            result = method.invoke(this.target, args);
        }
        System.out.println("---");
        return result;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象：商人
        Person person = new BuissnessMan();
        // 这里需要用接口作为目标对象
        Gangdom<Person> gangdom = new Gangdom<>(person);
        Person gangdomProxy = (Person)Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                gangdom
        );
        gangdomProxy.clean();
        gangdomProxy.getMoney();

    }
}
