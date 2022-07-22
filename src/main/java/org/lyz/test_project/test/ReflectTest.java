package org.lyz.test_project.test;

import org.lyz.test_project.entity.UserInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 获取类
        Class clz1 = Class.forName("org.lyz.test_project.entity.UserInfo");
        Class clz2 = UserInfo.class;
        Class clz3 = new UserInfo().getClass();

        // 获取批量构造方法
        Constructor[] cons = clz1.getConstructors();
        for(Constructor c : cons){
//            System.out.println(c);
        }
        Constructor[] cons2 = clz1.getDeclaredConstructors();
        for(Constructor c : cons2){
//            System.out.println(c);
        }
        // 获取单个构造
        Constructor con1 = clz1.getConstructor(null);
        Constructor con2 = clz1.getDeclaredConstructor(Integer.class);

        // 获取批量成员方法
        Field[] f1 = clz1.getFields();
        for(Field f : f1){
//            System.out.println(f);
        }
        Field[] f2 = clz1.getDeclaredFields();
        for(Field f : f2){
//            System.out.println(f);
        }
        Method[] m1 = clz1.getMethods();
        for(Method m : m1){
//            System.out.println(m);
        }
        Method[] m2 = clz1.getDeclaredMethods();
        for(Method m : m1){
//            System.out.println(m);
        }

        UserInfo ui = (UserInfo)clz1.newInstance();

        Field test = clz1.getField("test");
        Field username = clz1.getDeclaredField("username");
        Field nickname = clz1.getDeclaredField("nickname");
        Field tel = clz1.getDeclaredField("tel");
        test.set(ui, "test1");
        username.setAccessible(true);
        username.set(ui, "username1");
        nickname.setAccessible(true);
        nickname.set(ui, "nickname");
        tel.setAccessible(true);
        tel.set(ui, 1);

        Method test1 = clz1.getDeclaredMethod("test", int.class);
        test1.setAccessible(true);
        test1.invoke(ui, 1);

    }
}
