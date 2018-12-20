package view.code;

public class StringToInt {

	public int strToInt(String str) {
		str = str.trim();
		int result = 0;
		// 是否为负数
		boolean minusFlag = false;
		// 异常判断
		if (null == str || str.length() == 0) {
			return 0;
		}
		// 首字母是否为负号
		if (str.charAt(0) == '-') {
			minusFlag = true;
		}
		// 存在非数字字符判断
		for (int i = 0; i < str.length(); i++) {
			// 首字符为负号正常处理
			if (minusFlag && i == 0) {
				continue;
			}
			if (str.charAt(i) < '0' || str.charAt(i) - '0' > 9) {
				return 0;
			}
		}
		// 判断是否整型溢出
		if ((!minusFlag && str.length() > 10) || (minusFlag && str.length() > 11)) {
			int prefix = str.length() - 10;
			for (int i = prefix; i < str.length(); i++) {
				if (minusFlag && i == prefix) {
					continue;
				}
				result = result * 10 + str.charAt(i) - '0';
			}
		} else {
			for (int i = 0; i < str.length() - 1; i++) {
				if (minusFlag && i == 0) {
					continue;
				}
				result = result * 10 + str.charAt(i) - '0';
			}
			// 判断是否溢出
			if (result > Integer.MAX_VALUE / 10) {
				return 0;
			}
			if (result == Integer.MAX_VALUE / 10) {
				if ((str.charAt(str.length() - 1) - '0') > Integer.MAX_VALUE % 10 && !minusFlag
						|| (str.charAt(str.length() - 1) - '0') > (Integer.MAX_VALUE % 10 + 1) && minusFlag) {
					return 0;
				} else {
					result = result * 10 + str.charAt(str.length() - 1) - '0';
				}
			} else {
				result = result * 10 + str.charAt(str.length() - 1) - '0';
			}
		}

		if (minusFlag) {
			result = result * -1;
		}

		return result;
	}

	public static void main(String[] args) {
		StringToInt demo = new StringToInt();
		String str1 = "";
		String str2 = "1234567";
		String str3 = "1234stra12341";
		String str4 = "0";
		String str5 = "-123412341";
		String str6 = "2147483647";
		String str7 = "-2147483648";
		String str8 = "11111111222222";
		String str9 = "2147483649";
		System.out.println(demo.strToInt(str1));
		System.out.println(demo.strToInt(str2));
		System.out.println(demo.strToInt(str3));
		System.out.println(demo.strToInt(str4));
		System.out.println(demo.strToInt(str5));
		System.out.println(demo.strToInt(str6));
		System.out.println(demo.strToInt(str7));
		System.out.println(demo.strToInt(str8));
		System.out.println(demo.strToInt(str9));
	}

}
