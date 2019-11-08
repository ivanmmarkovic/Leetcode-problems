package ivanmarkovic.codingproblems.strings;

public class LongestCommonSubstring {
	
	public static String longestCommonSubstring(String string1, String string2) {
		if(string1.length() > string2.length())
			return longestCommonSubstringHelper(string1, string2);
		else
			return longestCommonSubstringHelper(string2, string1);
	}
	
	public static String longestCommonSubstringHelper(String string1, String string2) {
		String result = "";
		for(int i= 0; i < string1.length(); i++) {
			for(int j = string1.length(); j > i; j--) {
				if(string2.indexOf(string1.substring(i, j)) != -1) {
					if(string1.substring(i, j).length() > result.length())
						result = string1.substring(i, j);
				}
			}
		}
		return result;
	}

}
