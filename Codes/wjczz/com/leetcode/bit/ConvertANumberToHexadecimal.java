package com.leetcode.bit;

/**
 * 10进制转16进制, 采用辗转相除法/位运算
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 * @author stark
 * @Date 2017/12/17
 */
public class ConvertANumberToHexadecimal {

    public static String toHex(int num) {

        StringBuilder result = new StringBuilder();
        if(num < 0){


        } else if(num > 0){
            while(num != 0){
                int i = num % (16);
                result.append(oneToHex(i));
                num = num >> 4;

            }
        }

        if(result.length() == 0){
            return "0";
        }
        return result.reverse().toString();
    }

    public static char oneToHex(int i){
        if(0 <= i && i <= 9){
            char c = (char)( '0' + i);
            return c;
        }
        if(i >= 10 && i <= 15){
            char c = (char)( 'a' + i%10);
            return c;
        }
        return '0';
    }

    public static char negativeOneToHex(int i){
        if(-6 <= i && i <= -1){
            char c = (char)( 'f' + i);
            return c;
        }
        if(i >= -15 && i <= -7){
            char c = (char)( '9' + i%10);
            return c;
        }
        return '0';
    }

    public static void main(String[] agr){
//        System.out.println(toHex(-1));
        //负数 其实就是 正数 按位取反 + 1
        int num = -160;
        num = ~num ;
        System.out.println(num);

//         int num = -16;
//         while(num != -1){
//             num = num >> 4;
//             System.out.println(num);
//         }
//        System.out.println(-16 >> 4);
    }
}
