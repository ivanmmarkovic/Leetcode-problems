package stringCompression;

/*
 * Given a string, write a function to compress it by 
 * shortening every sequence of the same character to that 
 * character followerd by the number of repetitions. 
 * If the compressed string is longer than the original, 
 * you should return original string 
 * */

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-->" + compression("a"));
		System.out.println("-->" + compression("ab"));
		System.out.println("-->" + compression("aab"));
		System.out.println("-->" + compression("aaabbb"));
		System.out.println("-->" + compression("aaabccddeee"));
	}
	
	public static String compression(String string) {
		if(string.length() == 1)
			return string;
		else {
			ArrayList<String> compressed = new ArrayList<>();
			int counter = 1, siblingsLength = 1;
			char currentCharacter = string.charAt(0);
			while(counter < string.length()) {
				if(currentCharacter == string.charAt(counter)) {
					siblingsLength++;
				}
				else {
					compressed.add(String.valueOf(currentCharacter));
					if(siblingsLength > 1)
						compressed.add(String.valueOf(siblingsLength));
					currentCharacter = string.charAt(counter);
					siblingsLength = 1;
				}
				// on exit
				if(counter == string.length() - 1) {
					compressed.add(String.valueOf(currentCharacter));
					if(siblingsLength > 1)
						compressed.add(String.valueOf(siblingsLength));
				}
				counter++;
			}
			String result = "";
			for(String s: compressed)
				result += s;
			return result;
		}
	}

}
