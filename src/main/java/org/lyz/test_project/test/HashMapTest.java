package org.lyz.test_project.test;

import org.lyz.test_project.entity.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    // Iterator遍历
    public static void iterator(Map<Student, String> map){
        Set<Map.Entry<Student, String>> entries = map.entrySet();
        Iterator<Map.Entry<Student, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Student, String> next = iterator.next();
            Student key = next.getKey();
            String value = next.getValue();
            System.out.println(key + "::" + value);
        }
    }

    // entrySet遍历
    public static void entrySet(Map<Student, String> map){
        Set<Map.Entry<Student, String>> entries = map.entrySet();
        for(Map.Entry<Student, String> m : entries){
            Student key = m.getKey();
            String value = m.getValue();
            System.out.println(key + "::" + value);
        }
    }

    // keySet遍历
    public static void keySet(Map<Student, String> map){
        Set<Student> students = map.keySet();
        for(Student s : students){
            System.out.println(s.toString() + "::" + map.get(s));
        }
    }

    // λ表达式遍历
    public static void forEach(Map<Student, String> map){
        map.forEach((x, y)->{
            System.out.println(x.toString() + "::" + y);
        });
    }

    public static void main(String[] args) {
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("zs", 12), "1");
        map.put(new Student("ls", 12), "2");
        map.put(new Student("ww", 12), "3");
        map.put(new Student("ml", 12), "4");
//        iterator(map);
//        entrySet(map);
//        keySet(map);
//        forEach(map);
    }



}
