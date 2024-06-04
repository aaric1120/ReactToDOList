package org.example;
import java.util.*;
import java.util.regex.*;

public class Decompress {
    static String decompression(String comp) {
        while (comp.contains("[")) {
            //System.out.println(comp);
            int tracker = 0;
            for (int i = 0;i < comp.length();i++) {
                if (comp.charAt(i) == '[') {
                    tracker = i;
                } else if (comp.charAt(i) == ']') {
                    //System.out.printf("the current sub index is %d and %d \n",tracker,i);
                    int num_int = 0;
                    for (int j = tracker - 1; j >= 0;j--) {
                        //System.out.println(comp.substring(j,tracker));
                        if (!comp.substring(j,tracker).matches("^[0-9]*$")) {
                            num_int = j + 1;
                            break;
                        }
                    }
                    //System.out.printf("Replacing this string %s with %s \n",comp.substring(num_int,i) + "]",comp.substring(tracker + 1,i).repeat(Integer.parseInt(comp.substring(num_int,tracker))));
                    comp = comp.replaceFirst(comp.substring(num_int,tracker) +"\\[" + comp.substring(tracker + 1,i)
                            + "\\]",comp.substring(tracker + 1,i).repeat(Integer.parseInt(comp.substring(num_int,tracker))));
                    break;
                }
            }
        }
        return comp;
    }

    public static void main(String[] args) {
        System.out.println(decompression("3[a6[bc]]4[ab]c"));
    }
}
