package ivanmarkovic.codingproblems.strings;

public class StringCompression {
	
	public static void main(String args[]) {
		System.out.println("-->" + compress("a"));
		System.out.println("-->" + compress("ab"));
		System.out.println("-->" + compress("aab"));
		System.out.println("-->" + compress("aaabbb"));
		System.out.println("-->" + compress("aaabccddeee"));
	}
	
	public static String compress(String string) {
		if(string.length() < 2)
			return string;
		else {
			StringBuilder sb = new StringBuilder();
			char currentCharacter = string.charAt(0);
			int characterCount =1;
			int count = 1;
			while (count < string.length()) {
				if(currentCharacter == string.charAt(count))
					characterCount++;
				else {
					sb.append(currentCharacter);
					if(characterCount > 1)
						sb.append(characterCount);
					currentCharacter = string.charAt(count);
					characterCount = 1;
				}
				
				if(count == string.length() - 1) {
					sb.append(currentCharacter);
					if(characterCount > 1)
						sb.append(characterCount);
					currentCharacter = string.charAt(count);
					characterCount = 1;
				}
				count++;
			}
			String result = sb.toString();
			return string.length() <= result.length() ? string : result;
		}
	}

}
