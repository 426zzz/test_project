package org.lyz.test_project.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    private String test;

    public static int test(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
        list.forEach(str -> {
            System.out.println(str);
            if(str.equals("5")){
                return;
            }
        });
        return 1;
    }

    public static void main(String[] args) {
        // --- idea git test ---
        // master conflict
        // Desktop conflict
        test();
    }


}
