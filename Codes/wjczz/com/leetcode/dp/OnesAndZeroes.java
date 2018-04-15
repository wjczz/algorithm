package com.leetcode.dp;


/**
 * @Descrption  https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * @author wjczz
 * @date 2017/11/18
 */
public class OnesAndZeroes {

    /**
     * 贪心做法:先把String[] 直接按长度排序,然后逐个遍历。
     * 这种算法复杂度是log(n),时间复杂度还可以,但是有bug,比如 ["111","1000","1000","1000"]  m = 9, n=3 就会有问题
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
//            //得出s有多少个 0 和 1
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
     * 01背包扩展题
     *
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        //dp表示 i个0和 j个1组成的最大值
        //动态方程为 dp[i][j] = Max(dp[i-a][j-b] + 1,  dp[i][j]) , a 为字符串 0 的个数, b为字符串 1的个数
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
            //重点-------------
            //对每一个字符串都重新计算dp的值
            for(int i = m; i >=a; i--){
                for(int j = n; j >=b; j--){
                    dp[i][j] = Math.max(dp[i - a][j - b] + 1, dp[i][j]);
                }
            }
            //-------------重点
        }
        return dp[m][n];
    }


        public static void main(String[] arg){
        String[] strs = new String[]{"111","1000","1000","1000"};
        System.out.println(findMaxForm(strs, 9,3));
    }
}
