package com.leetcode.dp;


/**
 * @Descrption Ì¨½×ÖÖÊý  https://leetcode.com/problems/climbing-stairs/description/
 *
 * @author wjczz
 * @date 2017/11/11
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if(n >= 1 && n <= 2){
            return n;
        }
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n; i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[n];
    }

    public static void main(String[] arg){
        for(int i = 1; i < 11; i++){
            System.out.println(climbStairs(i));
        }
    }
}
