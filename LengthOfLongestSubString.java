import java.util.HashSet;

public class LengthOfLongestSubString {

    public static int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int rs = 0, i = 0, j = 0;
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                rs = Math.max(rs, j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        System.out.println(set);
        System.out.println(rs);
        return rs;
    }

    public static void main(String[] args) {
        String str1 = "abcabc";
        String str2 = "bbbb";
        String str3 = "abcaefgba";
        LengthOfLongestSubString.lengthOfLongestSubString(str1);
        LengthOfLongestSubString.lengthOfLongestSubString(str2);
        LengthOfLongestSubString.lengthOfLongestSubString(str3);
    }
}
