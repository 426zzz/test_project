package org.lyz.test_project.test;

import java.io.*;

class UserInfo implements Serializable {
    private static final long serialVersionUID = 996890129747019948L;
    private static String name;
    private transient String psw;

    public UserInfo(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserInfo.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String toString() {
        return "name=" + name + ", psw=" + psw;
    }

}
public class TransientTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("zs", "123456");
        System.out.println(userInfo);
        OutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // 序列化，被设置为transient的属性没有被序列化
            fos = new FileOutputStream(new File("E:\\test.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        InputStream ins = null;
        ObjectInputStream ois = null;
        try {
            //在反序列化之前改变name(name是类属性)的值
            userInfo.setName("hello");
            // 反序列化
            ins = new FileInputStream(new File("E:\\test.txt"));
            ois = new ObjectInputStream(ins);
            UserInfo readUserInfo = (UserInfo) ois.readObject();
            //读取后psw的内容为null
            System.out.println(userInfo.toString());
            System.out.println(readUserInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ins != null){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
