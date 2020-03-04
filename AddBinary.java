package leetcode.prac;

//给定两个二进制字符串，返回他们的和（用二进制表示）。
//
//        输入为非空字符串且只包含数字 1 和 0。
//
//        示例 1:
//
//        输入: a = "11", b = "1"
//        输出: "100"
//        示例 2:
//
//        输入: a = "1010", b = "1011


public class AddBinary {
    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int up = 0;
        StringBuilder sb = new StringBuilder();
        while (lenA >=0 || lenB >= 0) {
            if (lenA >= 0) {
                up = up + (a.charAt(lenA--) - '0');
            }
            if (lenB >= 0) {
                up = up + (b.charAt(lenB--) - '0');
            }
            sb.append(up % 2);
            up = up / 2;
        }
        String res = sb.reverse().toString();
        return up > 0 ? '1' + res : res;
    }
}
