package com.leetcode.dp;


/**
 * @Descrption �����������  https://leetcode.com/problems/maximum-subarray/description/
 *
 * @author wjczz
 * @date 2017/11/4
 */
public class MaximumSubarray {

    /**
     * �����ƽ� ʱ�临�Ӷ�Ϊ O(n*n)  Time Limit Exceeded
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//        int sum = nums[0];
//        for(int i = 0; i < nums.length; i++){
//            int cur = nums[i];
//            if(cur > sum){
//                sum = cur;
//            }
//            for(int j = i+1; j < nums.length; j++){
//                cur += nums[j];
//                if(cur > sum){
//                    sum = cur;
//                }
//            }
//        }
//        return sum;
//    }

    /**
     * ��¼��ÿ�β��������¼,����ά��û���Ż���,ʱ�临�Ӷ���Ϊ O(n*n)  Time Limit Exceeded
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//        int sum = Integer.MIN_VALUE;
//        int[] maxSum = new int[nums.length];
//        Arrays.fill(maxSum, 0);
//        int cur = 0;
//        for(int i = 0; i < nums.length; i++){
//            cur += nums[i];
//            maxSum[i] = cur;
//            if(nums[i] > sum){
//                sum = nums[i];
//            }
//            if(cur > sum){
//                sum = cur;
//            }
//        }
//
//        for(int i = 1; i < nums.length; i++){
//            for(int j = i+1; j < nums.length; j++){
//                int subCur = maxSum[j] - nums[i - 1];
//                if (subCur > sum) {
//                    sum = subCur;
//                }
//                maxSum[j] = subCur;
//            }
//        }
//        return sum;
//    }

    /**
     * ʱ�临�Ӷ�ΪO(n)
     * ��ռ�:������ ��ÿ����Ϊ<b>�յ�</b>���������������
     * ��̬״̬ת�Ʒ���
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        //��¼ÿһ����Ϊ�յ���������������
        int[] maxSum = new int[nums.length];

        //��һ����Ϊ�յ��ʱ��
        maxSum[0] = nums[0];
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++){
            maxSum[i] =  Math.max(maxSum[i-1]+nums[i], nums[i]);
            if(sum < maxSum[i]){
                sum = maxSum[i];
            }
        }
        return sum;
    }



    public static void main(String[] arg){
          int[] demo = new int[]{-2,1,-3,4,-1,2,1,-5,4};
          System.out.println(maxSubArray(demo));
    }
}
