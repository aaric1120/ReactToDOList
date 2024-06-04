package org.example;
import java.util.*;

class Blocks {

}

public class MinMaxDistance {
    static void leftRecurDis(<List<List<Boolean>> blocks, int curr_ind, int[] curr_dis, boolean[] curr_check) {
        int count = 0;
        for (int i = 0; i < curr_check.length;i++) {
            if (curr_check[i]) {
                count += 1;
                if (count == curr_check.length) {
                    return;
                }
            }
        }
        try {
            for (int i = 0;i < curr_check.length;i++) {
                if (!curr_check[i]) {
                    if (!blocks.get(curr_ind).get(i)) {
                        curr_dis[i] += 1;
                    } else {
                        curr_check[i] = true;
                    }
                }
                leftRecurDis(blocks,curr_ind + 1,curr_dis,curr_check);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void rightRecurDis(<List<List<Boolean>> blocks, int curr_ind, int[] curr_dis, boolean[] curr_check) {
        int count = 0;
        for (int i = 0; i < curr_check.length;i++) {
            if (curr_check[i]) {
                count += 1;
                if (count == curr_check.length) {
                    return;
                }
            }
        }
        try {
            for (int i = 0;i < curr_check.length;i++) {
                if (!curr_check[i]) {
                    if (!blocks.get(curr_ind).get(i)) {
                        curr_dis[i] += 1;
                    } else {
                        curr_check[i] = true;
                    }
                }
                rightRecurDis(blocks,curr_ind - 1,curr_dis,curr_check);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int getDistance(List<List<Boolean>> input) {
        int[] dis_arr = new int[input.size()];
        int final_min = Integer.MAX_VALUE;
        for(int i = 0;i<dis_arr.length;i++) {
            int[] left_side = new int[input.get(i).size()];
            boolean[] left_side_bool = new boolean[input.get(i).size()];
            leftRecurDis(input,i,left_side,left_side_bool);

            int[] right_side = new int[input.get(i).size()];
            boolean[] right_side_bool = new boolean[input.get(i).size()];
            rightRecurDis(input,i,right_side,right_side_bool);
            int curr_max = -1;
            for(int j = 0; j < right_side.length;j++) {
                if (left_side[i] > right_side[i]) {
                    if (right_side[i] > curr_max) {
                        curr_max = right_side[i];
                    }
                } else {
                    if (left_side[i] > curr_max) {
                        curr_max = left_side[i];
                    }
                }
            }
            if (curr_max < final_min) {
                final_min = curr_max;
            }
        }
        return final_min;
    }

    
    public static void main(String[] args) {

    }
}
