package org.example;
import java.util.*;

public class BestServer {
    public static int findServer(ArrayList<Integer> servers, int server_load) {
        String binary_form = Integer.toBinaryString(server_load);
        List<Integer> serv_decomp = new ArrayList<Integer>();

        for (int i = binary_form.length() - 1;i >= 0 ;i--) {

            if (binary_form.charAt(i) != '0') {
                serv_decomp.add((int) Math.pow(2,binary_form.length() - 1 - i));
            }
        }

        int curr_count = 0;

        while (server_load > 0) {
            System.out.printf("we are comparing %s and %s ;\n",serv_decomp.toString(),servers.toString());
            try {
                if (serv_decomp.getLast() > servers.getLast()) {
                    int temp = serv_decomp.removeLast();
                    if (temp / servers.getLast() > servers.size()) {
                        return -1;
                    }
                    for (int i = 0; i < temp / servers.getLast(); i++) {
                        serv_decomp.add(servers.getLast());
                    }
                } else if (serv_decomp.getLast() == servers.getLast()){
                    server_load -= serv_decomp.getLast();
                    curr_count += 1;
                    servers.removeLast();
                    serv_decomp.removeLast();
                } else {
                    servers.removeLast();
                }
            } catch (Exception e) {
                return -1;
            }
        }
        if (server_load == 0){
            return curr_count;
        }
        return -1;
    }

    public static int log2(int num) {
        return (int) (Math.log(num)/Math.log(2));
    }

    public static void main(String[] args) {
        Integer[] temp = new Integer[]{1,1,2,4,4,8,8};
        ArrayList<Integer> temp2 = new ArrayList<Integer>(Arrays.stream(temp).toList());
        System.out.println(findServer(temp2,37));
    }
}
