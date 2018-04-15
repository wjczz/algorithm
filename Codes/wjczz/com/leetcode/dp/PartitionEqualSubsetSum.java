package com.leetcode.dp;

import java.util.Arrays;

/**
 * @Descrption https://leetcode.com/problems/partition-equal-subset-sum/description/
 * @Author stark
 * @Date 2017/11/26
 */
public class PartitionEqualSubsetSum {

    /**
     * DP做法——01背包
     * @param nums
     * @return
     */
    public static  boolean canPartition(int[] nums) {
        int avg = 0;
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        } else {
            avg = sum / 2;
        }
        //只要能够找一个符合avg的,剩余的,肯定也是符合的.
        //dp[i][j] 表示 总和为j, 前i个元素 的情况下,最接近avg的左值
        int[][] dp = new int[nums.length][avg+1];
        for(int i = avg; i >= nums[0]; i--){
            dp[0][i] = nums[0];
        }

        for(int j = 1; j <= avg; j++){
            for(int i = 1; i < nums.length; i++){
                int w = j - nums[i] <= 0 ? 0 : j-nums[i];
                int a = dp[i - 1][w] + nums[i];
                int b = dp[i - 1][j];
                if(a > j){
                    dp[i][j] = b;
                }else{
                    dp[i][j] = Math.max(a, b);
                }
                if(dp[i][j] == avg){
                    return true;
                }
            }
        }
        return false;
    }

    

    public static void main(String[] arg){
//        int[] nums = new int[]{3,5,3,4,1,2};
//        int[] nums = new int[]{1, 5, 11, 5};
        int[] nums = new int[]{
               66,90,7,6,32,16,2,78,69,88,
               85,26,3,9,58,65,30,96,11,31,
                99,49,63,83,79,97,20,64,81,
                80,25,69,9,75,23,70,26,71,25,
                54,1,40,41,82,32,10,26,33,50,
                71,5,91,59,96,9,15,46,70,26,
                32,49,35,80,21,34,95,51,66,17,
                71,28,88,46,21,31,71,42,2,98,
                96,40,65,92,43,68,14,98,38,13,77,14,13,60,79,52,46,9,13,25,8
        };
//        int[] nums = new int[]{1, 2, 3 , 5};
        System.out.println(canPartition(nums));
    }
}
