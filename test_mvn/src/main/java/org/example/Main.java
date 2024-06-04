package org.example;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        // Create different array types
        int[] example_arr = new int[10];
        int[] example_arr2 = new int[]{3,3,52,6346,75,234,8665,843,234,9};

        Integer[] example_arr_convert = new Integer[]{1,2,3,4};
        ArrayList<Integer> example_convert_arry = new ArrayList<Integer>(Arrays.stream(example_arr_convert).toList());

        String[] example_arr3 = new String[]{"this","is","a","test","sentence"};
        List<String> example_list = new ArrayList<String>();
        List<Integer> example_int_list = new ArrayList<Integer>();
        for (int i = 0;i < 10;i++){
            example_list.add(Integer.toString(i));
            example_int_list.add(i);
        }

        HashMap<String,Integer> example_hashmap = new HashMap<String,Integer>();
        for (int j = 0;j <5;j++) {
            example_hashmap.put(example_arr3[j],example_arr2[j]);
        }
        int example_get = example_hashmap.get(example_arr3[2]);

        //Update Hashmap Values
        example_hashmap.put("this",example_hashmap.get("this") + 4);


        // String manipulation
        String example_string = "Maaster of the house, doling out the chaarm, ready with a haandshaake and an open palm.";
        String example_replace = example_string.replace(" ",":");
        String[] example_split = example_string.split(" ");
        List<String> example_str_list = new ArrayList<String>(Arrays.stream(example_split).toList());
        String example_index_finder = Character.toString(example_string.charAt(example_string.indexOf('a')));


        // Lisr & Array filter
        List<String> example_filter = Arrays.stream(example_split).filter(word -> word.toLowerCase().contains("a")).map(word -> word + "_suffix").collect(Collectors.toList());
        List<String> example_filter2 = example_str_list.stream().filter(word -> word.matches(".*[a-z].*")).map(word -> word.toUpperCase()+ "_suffix").collect(Collectors.toList());


        // Array List String Length
        int example_array_length = example_arr2.length;
        int example_string_length = example_string.length();
        int example_list_length = example_list.size();


        // Mathematic functions and conversion
        float example_float = 5.6f;
        double example_floor = Math.floor(example_float);
        double example_ceil = Math.ceil(example_float);
        double example_sqrt = Math.sqrt(example_float);
        double example_power = Math.pow(example_float, 6);
        int example_convert = (int)example_floor;


        // Array manipulations
        int[] example_sort = Arrays.stream(example_arr2).sorted().toArray();
        List<Integer> example_array_to_list = Arrays.stream(example_arr2).boxed().collect(Collectors.toList());
        //Array update value
        example_array_to_list.add(4,example_array_to_list.get(4) + 4);
        example_int_list.sort(Comparator.naturalOrder());
        example_int_list.sort(Comparator.reverseOrder());

        try {
            System.out.println(example_int_list.toString());
        } catch (Exception e) {
            System.out.println(example_int_list);
        }

        for( String key: example_hashmap.keySet()) {
            System.out.printf("%s is the key , and %d is the value \n",key,example_hashmap.get(key));
        }

        String test_case = "ie+09";
        System.out.println(test_case.matches("^[0-9a-z]*$"));
    }
}