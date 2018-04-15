package com.leetcode.array;

import java.util.Arrays;

/**
 * @Descrption  https://leetcode.com/problems/game-of-life/description/
 * @Author stark
 * @Date 2017/12/5
 */
public class GameOfLife {

    /**
     * œ»∂‘∆‰copy
     * @param board
     */
    public static void gameOfLife(int[][] board) {
        int[][] copy = Arrays.copyOf(board, board.length);
        for(int i = 0, imax = copy.length; i < imax; i++){
            for(int j = 0, jmax = copy[i].length; j < jmax; j++){
                int sum = 0;
                int left = i - 1;
                int right = i + 1;
                int up = j - 1;
                int down = j + 1;
                if(left > 0){
                    if(up > 0){
                        sum += copy[left][up];
                    }
                    sum += copy[left][j];
                    if(down < jmax){
                        sum += copy[left][down];
                    }
                }
                if(up > 0){
                    sum += copy[i][up];
                }
                if(down < jmax){
                    sum += copy[i][down];
                }

                if(right < imax){
                    if(up > 0){
                        sum += copy[right][up];
                    }
                    sum += copy[right][j];
                    if(down < jmax){
                        sum += copy[right][down];
                    }
                }

                if(board[i][j] == 0 && sum == 3){
                    board[i][j] = 1;
                }else if(board[i][j] == 1) {
                    if (sum <= 2 || sum > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] arg){
        int[][] board = {{1,1}, {1, 0}};
        gameOfLife(board);
        for(int[] i:board){
            for(int j:i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
