package leetcode.prac;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//        你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: [1,2,4]
//        解释: 输入数组表示数字 123。
//        示例 2:
//
//        输入: [4,3,2,1]
//        输出: [4,3,2,2]
//        解释: 输入数组表示数字 4321。


public class PlusOne {

    public int[] plusOne(int[] digits) {
        int resLen = digits.length;
        boolean allNine = true;
        for (int digit : digits) {
            if (digit != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] res = new int[resLen+1];
            res[0] = 1;
            for (int i=1;i<res.length;i++) {
                res[i] = 0;
            }
            return res;
        } else {
            int[] res = new int[resLen];
            boolean up = false;
            for (int i=resLen-1;i>=0;i--) {
                int digit = digits[i];
                if (i == resLen-1) {
                    digit++;
                }
                if (up) {
                    digit = digit + 1;
                }
                if (digit >= 10) {
                    up = true;
                    digit = digit % 10;
                } else {
                    up = false;
                }
                res[i] = digit;
            }
            return res;
        }

    }
}
