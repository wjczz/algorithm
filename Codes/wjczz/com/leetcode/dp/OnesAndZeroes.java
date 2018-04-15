package com.leetcode.dp;


/**
 * @Descrption  https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * @author wjczz
 * @date 2017/11/18
 */
public class OnesAndZeroes {

    /**
     * ̰������:�Ȱ�String[] ֱ�Ӱ���������,Ȼ�����������
     * �����㷨���Ӷ���log(n),ʱ�临�ӶȻ�����,������bug,���� ["111","1000","1000","1000"]  m = 9, n=3 �ͻ�������
     */
//    public static int findMaxForm(String[] strs, int m, int n) {
//        final int mm = m;
//        final int nn = n;
//        Arrays.sort(strs, (s1, s2) -> {
//            if(s1.length() > s2.length()){
//                return 0;
//            } else if(s1.length() < s2.length()){
//                return -1;
//            }else {
//
//                    return s1.compareTo(s2);
//                } else {
//                    return s2.compareTo(s1);
//                }
//            }
//        });
//        int num = 0;
//        for(String s:strs){
//            //�ó�s�ж��ٸ� 0 �� 1
//            int zeroNum = 0;
//            int oneNum = 0;
//            for(char c:s.toCharArray()){
//                if(c == '0'){
//                    zeroNum++;
//                }else if(c == '1'){
//                    oneNum++;
//                }
//            }
//            if(m-zeroNum >= 0  && n-oneNum >= 0 ){
//                m -= zeroNum;
//                n -= oneNum;
//                num++;
//            }else {
//                break;
//            }
//        }
//        return num;
//    }


    /**
     * 01������չ��
     *
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        //dp��ʾ i��0�� j��1��ɵ����ֵ
        //��̬����Ϊ dp[i][j] = Max(dp[i-a][j-b] + 1,  dp[i][j]) , a Ϊ�ַ��� 0 �ĸ���, bΪ�ַ��� 1�ĸ���
        int[][] dp = new int[m+1][n+1];
        for(String s:strs){
            int a = 0;
            int b = 0;
            for(char c:s.toCharArray()){
                if(c == '0'){
                    a++;
                }
                if(c == '1'){
                    b++;
                }
            }
            //�ص�-------------
            //��ÿһ���ַ��������¼���dp��ֵ
            for(int i = m; i >=a; i--){
                for(int j = n; j >=b; j--){
                    dp[i][j] = Math.max(dp[i - a][j - b] + 1, dp[i][j]);
                }
            }
            //-------------�ص�
        }
        return dp[m][n];
    }


        public static void main(String[] arg){
        String[] strs = new String[]{"111","1000","1000","1000"};
        System.out.println(findMaxForm(strs, 9,3));
    }
}
