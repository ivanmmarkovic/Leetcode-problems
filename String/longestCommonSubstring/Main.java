package longestCommonSubstring;

/*
 * Given two strings, write a function that returns the longest 
 * common substring
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSubstring("ABAB", "BABA"));
		System.out.println(longestCommonSubstring("java", "javascript"));
		System.out.println(longestCommonSubstring("javascripting", "ecmascripting"));
		System.out.println(longestCommonSubstring("scripting", "javascripting"));
	}
	
	public static String longestCommonSubstring(String string1, String string2) {
		if(string1.length() > string2.length())
			return helper(string1, string2);
		else
			return helper(string2, string1);
	}
	
	public static String helper(String string1, String string2) {
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
