package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class LongestWord {

    static String findLongest(List<String> word_list, String seq) {
        word_list = word_list.stream().sorted((str1,str2) -> str2.length() - str1.length()).filter(word ->
                word.length() <= seq.length()).collect(Collectors.toList());

        while(!word_list.isEmpty()) {
            String curr_word = word_list.removeFirst();

            int word_ind = 0,seq_ind = 0;
            while (word_ind < curr_word.length() && seq_ind < seq.length()) {
                if (curr_word.charAt(word_ind) == seq.charAt(seq_ind)) {
                    word_ind += 1;
                }
                seq_ind += 1;
            }
            if (word_ind == curr_word.length()) {
                return curr_word;
            }
        }
        return "no word was found...";
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<String>(Arrays.asList( new String[]{ "kangaroo","apple","able", "ale", "bale"}));
        String input2 = "abpplgeee";
        System.out.println(findLongest(input,input2));


    }
}
