package leetcode.prac;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//        说明：本题中，我们将空字符串定义为有效的回文串。
//
//        示例 1:
//
//        输入: "A man, a plan, a canal: Panama"
//        输出: true
//        示例 2:
//
//        输入: "race a car"
//        输出: false


import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c<='Z' || c >='a' && c <= 'z' || c >= '0' && c <= '9') {
                if (c >= 'A' && c <= 'Z') {
                    c += 32;
                }
                list.add(c);
            }
        }
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            if (list.get(low).charValue() == list.get(high).charValue()) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

}
