package com.leetcode.dp;

import java.util.Arrays;

/**
 * @Descrption https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * @Author stark
 * @Date 2017/11/26
 */
public class PartitiontoKEqualSumSubsets {

    /**
     *  ���仯����+��̬�滮�����Ž�
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        //1.����ÿ��slotӦ������������Ƕ��٣�Ҳ����ƽ����
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
        //2.�ܹ���Ϊk��slot��ǰ��, �϶����ܹ���Ϊ k-1 ��slot
        for(int i = 1; i <= k; i++){

        }


        return true;
    }



    public static void main(String[] arg){

    }
}
