package org.example;
import java.util.List;
import java.util.HashMap;

public class LakeVolume {
    static int lakeVolume(int[] lake) {
        int end = lake.length - 1;
        int start = 0;
        int output = 0;
        while (end != start) {
            if (lake[start] < lake[end]) {
                int curr_max = lake[start];
                while (curr_max < lake[end]) {
                    if (curr_max > lake[start + 1]) {
                        output += curr_max - lake[start+ 1];
                    } else {
                        curr_max = lake[start + 1];
                        System.out.printf("the current max of start less than end is: %d \n",curr_max);
                    }
                    start += 1;
                    if (end == start) {
                        return output;
                    }
                }
            } else {
                int curr_max = lake[end];
                while (curr_max <= lake[start]) {
                    if (curr_max > lake[end - 1]) {
                        output += curr_max - lake[end - 1];
                    } else {
                        curr_max = lake[end - 1];
                        System.out.printf("the current max of end less than start is: %d \n",curr_max);
                    }
                    end -= 1;
                    if (end == start) {
                        return output;
                    }
                }
            }
            System.out.printf("the current start and end index are : %d    %d, and the output is: %d\n",start + 1,end + 1,output);
        }
        return output;
    }
    public static void main(String[] args) {
        int[] test_lake = new int[]{4,1,3,1,4,5,2,2,1,4,2,2};
        System.out.println(lakeVolume(test_lake));
    }
}
