package org.example;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class If{
    List<Iterator<Integer>> iterator_arr;
    int count = 0;
    int arr_len;

    public If(List<Iterator<Integer>> it_arr) {
        iterator_arr = it_arr;
        arr_len = it_arr.size();

    }

    public int length() {
        return arr_len;
    }

    public int next() {
        if (this.hasNext()) {
            int output = iterator_arr.get(count).next();
            count += 1;
            if (count == arr_len) {
                count = 0;
            }
            return output;
        }
        return 0;
    }

    public boolean hasNext() {
        while(arr_len != 0){
            if (iterator_arr.get(count).hasNext()) {
                // System.out.printf("this is the current length and the counter: %d   %d \n",arr_len,count);
                return true;
            }
            iterator_arr.remove(count);
            arr_len -= 1;
            if (count >= arr_len) {
                count = 0;
            }
            // System.out.printf("this is the current length and the counter: %d   %d \n",arr_len,count);
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] test_arr = new Integer[]{1,23,2,1};
        Integer[] test_arr2 = new Integer[]{5,3,2};
        Integer[] test_arr3 = new Integer[]{3,4,5,3,2};
        Iterator<Integer> test_it = Arrays.stream(test_arr).iterator();
        Iterator<Integer> test_it2 = Arrays.stream(test_arr2).iterator();
        Iterator<Integer> test_it3 = Arrays.stream(test_arr3).iterator();

        List<Iterator<Integer>> test_input = new ArrayList<Iterator<Integer>>();
        test_input.add(test_it);
        test_input.add(test_it2);
        test_input.add(test_it3);


        If output = new If(test_input);

        // System.out.println(output.length());
        while(output.hasNext()) {
            System.out.println(output.next());
        }
    }
}
