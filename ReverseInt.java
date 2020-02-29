package leetcode.prac;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//        示例 1:
//
//        输入: 123
//        输出: 321
//         示例 2:
//
//        输入: -123
//        输出: -321
//        示例 3:
//
//        输入: 120
//        输出: 21
//        注意:
//
//        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
//


public class ReverseInt {
    public int reverse(int x) {
        int minus = x < 0 ? -1 : 1;
        long rev = 0;
        for (int tmp = Math.abs(x);tmp > 0;tmp = tmp / 10) {
            rev = rev * 10 + (tmp % 10);
        }
        long result = rev * minus;
        if (result > Integer.MAX_VALUE || result < -1 * (Integer.MAX_VALUE + 1)) {
            return 0;
        }
        return (int)result;
    }
}
