package org.lyz.test_project.test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @Author lyz
 * @Date 2022-06-19
 * @Description:
 */
public class SplitInteger {

    public static String[] splitIteger(Integer num) throws NoSuchAlgorithmException {
        // 向上取整
        if(!num.toString().endsWith("00")){
            num = Integer.parseInt(num.toString().substring(0, num.toString().length() - 2) + "00") + 100;
        }
        StringBuilder numStr = new StringBuilder();
        for(String s : num.toString().split("")){
            numStr.append(s);
        }
        // 份数
        int numInteger = Integer.parseInt(numStr.toString());
        int part = numInteger % 2500 == 0 ? numInteger / 2500 : numInteger / 2500 + 1;
        // 拆分
        return getArr(numInteger, part);
    }

    private static String[] getArr(int numInteger, int part) throws NoSuchAlgorithmException {
        SecureRandom ran = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder();
        while(sb.toString().split(",").length != part){
            int singleNum = ran.nextInt(3000);
            if(!(singleNum < 1000 || singleNum > 3000 || Integer.toString(singleNum).endsWith("00") || Integer.toString(singleNum).endsWith("0"))){
                sb.append(singleNum);
                sb.append(",");
            }
        }
        String substring = sb.toString().substring(0, sb.toString().length() - 2);
        int total = 0;
        for(String num : substring.split(",")){
            total += Integer.parseInt(num);
        }
        if(total < numInteger - 2500){
            getArr(numInteger, part);
        }else{
            substring += "," + (numInteger - total) + "";
        }
        return substring.split(",");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] ints = splitIteger(8000);
        System.out.println(Arrays.toString(ints));
    }
}
