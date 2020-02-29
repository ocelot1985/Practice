package leetcode.prac;

import java.util.Stack;
import java.util.EmptyStackException;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 1:
//
//        输入: "()"
//        输出: true
//        示例 2:
//
//        输入: "()[]{}"
//        输出: true
//        示例 3:
//
//        输入: "(]"
//        输出: false
//        示例 4:
//
//        输入: "([)]"
//        输出: false
//        示例 5:
//
//        输入: "{[]}"
//        输出: true


public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() < 1) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(Character.valueOf(c));
            } else if (')' == c || ']' == c || '}' == c) {
                char prev = 0;
                try {
                    prev = stack.pop().charValue();
                } catch (EmptyStackException e) {
                    return false;
                }
                if (c == ')' && prev != '(') {
                    return false;
                }
                if (c == ']' && prev != '[') {
                    return false;
                }
                if (c == '}' && prev != '{') {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
