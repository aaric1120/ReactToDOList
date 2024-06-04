package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MineSweeper {
    static HashMap<String,int[]> plantBombs(int matrix_size) {
        HashMap<String,int[]> non_zero = new HashMap<String,int[]>();
        for(int i = 0;i < matrix_size;i++) {
            int row = (int) (Math.random() * (matrix_size - 1));
            int col = (int) (Math.random() * (matrix_size - 1));
            if(!non_zero.containsKey("%d_%d".formatted(row,col)) || non_zero.get("%d_%d".formatted(row,col))[0] != 9) {
                non_zero.put("%d_%d".formatted(row,col),new int[]{9});
                int vert = -1;
                while(vert < 2) {
                    for(int j = -1;j < 2;j++) {
                        if((row+j < matrix_size && row+j >= 0) && (col+vert < matrix_size && col+vert >= 0)) {
                            if(!non_zero.containsKey("%d_%d".formatted(row+j,col+vert))){
                                non_zero.put("%d_%d".formatted(row+j,col+vert),new int[]{1});
                            } else {
                                if (non_zero.get("%d_%d".formatted(row+j,col+vert))[0] != 9) {
                                    non_zero.get("%d_%d".formatted(row+j,col+vert))[0] += 1;
                                }
                            }
                        }
                    }
                    vert += 1;
                }
            }
        }
        return non_zero;
    }

    static boolean traverseMatrix(int row, int col, HashMap<String,int[]> visited, List<ArrayList<String>> grid) {
        int ma_len = grid.size();
        for(int i =-1;i < 2;i++) {
            for(int j = -1;j<2;j++) {
                if(visited.containsKey("%d_%d".formatted(row+i,col+j))) {
                    if(visited.get("%d_%d".formatted(row+i,col+j))[0] == 9) {
                        return false;
                    }
                    grid.get(row+i).set(col+j,Integer.toString(visited.get("%d_%d".formatted(row+i,col+j))[0]));
                } else {
                    if((row+i < ma_len && row+i >= 0) && (col+j < ma_len && col+j >= 0)) {
                        grid.get(row+i).set(col+j,"0");
                        visited.put("%d_%d".formatted(row+i,col+j),new int[]{0});
                        traverseMatrix(row+i,col+j,visited,grid);
                    }
                }
            }
        }
        return true;
    }

    static void createMatrix(int length) {
        HashMap<String,int[]> all_bombs = plantBombs(length);
        List<ArrayList<String>> output = new ArrayList<>();
        for(int i = 0;i < length;i++) {
            output.add(new ArrayList<String>());
            for(int j = 0;j< length;j++) {
                output.getLast().add("-");
            }
        }
        while(true) {
            for(ArrayList<String> row: output) {
                System.out.println(row.toString());
            }
            Scanner user_input = new Scanner(System.in);
            System.out.println("Enter the coordinates you wanna try: ");
            String user_inp = user_input.nextLine();
            String[] coord = user_inp.split(" ");
            if (!traverseMatrix(Integer.parseInt(coord[0]),Integer.parseInt(coord[1]),all_bombs,output)) {
                System.out.println("YOU HIT A BOMBBBB");
                return;
            }
        }

    }

    public static void main(String[] args) {
        //createMatrix(10);
        int[] test = new int[]{1,2,5,21,1};
        //Arrays.sort(test);
        //System.out.println(Arrays.stream(test).boxed().collect(Collectors.toList()));
        String test_tur = 6 < 7 ? "this" : "that";
        System.out.println(test_tur);



    }
}
