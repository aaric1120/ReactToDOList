package org.example;
import java.util.*;

class MyRegex {
    public String is_ip;
    public MyRegex(String ip) {
        is_ip = ip;
    }

    public boolean test_ip() {
        String[] ip_ele = is_ip.split("\\.");
        System.out.println(ip_ele.length);
        long output;
        try {
            output =  Arrays.stream(ip_ele).filter(ele -> ele.matches("^[0-9]*$")).filter(ele -> ele.length() <=3).filter(ele -> Integer.parseInt(ele) <= 255).count();
        } catch (Exception e) {
            return false;
        }
        if (output != 4) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyRegex test_obj = new MyRegex("00.12.123.123123.123");
        System.out.println(test_obj.test_ip());
        // System.out.println(Integer.parseInt(""));
        System.out.println("23.45.12".matches("[0-2]?[0-5]?[0-5]?\\.[0-2]?[0-5]?[0-5]?\\.[0-2]?[0-5]?[0-5]?"));

    }
}
