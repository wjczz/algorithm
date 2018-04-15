package com.leetcode.dp;

import java.util.Arrays;

/**
 * @Descrption https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * @Author stark
 * @Date 2017/11/26
 */
public class PartitiontoKEqualSumSubsets {

    /**
     *  记忆化搜索+动态规划求最优解
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        //1.请求每个slot应该满足的总数是多少，也就是平均数
        int avg = 0;
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        if(sum % k != 0){
            return false;
        } else {
            avg = sum / k;
        }
        boolean[] flag = new boolean[nums.length];
        //2.能够分为k个slot的前提, 肯定是能够分为 k-1 个slot
        for(int i = 1; i <= k; i++){

        }


        return true;
    }



    public static void main(String[] arg){

    }
}
