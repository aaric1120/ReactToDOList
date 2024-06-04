package org.example;
import java.util.*;



public class WordBlock {
    static boolean isWB(List<String> word_list) {
        List<Integer> check_range = new ArrayList<Integer>();
        for(int i = 0;i<word_list.size();i++) {
            check_range.addLast(i);
        }
        while(!check_range.isEmpty()) {
            int curr_num = check_range.removeFirst();
            for(Integer num:check_range){
                // System.out.printf("we are currently comparing %s and %s \n",word_list.get(curr_num).charAt(num),word_list.get(num).charAt(curr_num));
                if(word_list.get(curr_num).charAt(num) != word_list.get(num).charAt(curr_num)) {
                    return false;
                }
            }
        }
        return true;
    }

    static List<List<String>> findWB(List<String> words_list) {
        List<List<String>> f_out = new ArrayList<List<String>>();
        List<String> temp_out = new ArrayList<String>();
        recurWB(words_list,temp_out,f_out);
        return f_out;
    }

    static void recurWB(List<String> input, List<String> output,List<List<String>> final_output) {
        if (output.size() != 4) {
            for(int i = 0;i<input.size();i++){
                List<String> new_input = new ArrayList<>(input);
                List<String> new_output = new ArrayList<>(output);
                new_output.add(new_input.remove(i));
                recurWB(new_input,new_output,final_output);
            }
        }
        else {
            if (isWB(output)) {
                final_output.add(output);
            }
            return;
        }
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList(new String[]{"BALL","AREA","LEAD","LADY","DEAR","YARD"}));
        System.out.println(findWB(input));
    }
}
