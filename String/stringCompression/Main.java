/*
 * Given a string, write a function to compress it by 
 * shortening every sequence of the same character to that 
 * character followed by the number of repetitions. 
 * If the compressed string is longer than the original, 
 * you should return original string 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-->" + compress("a"));
		System.out.println("-->" + compress("ab"));
		System.out.println("-->" + compress("aab"));
		System.out.println("-->" + compress("aaabbb"));
		System.out.println("-->" + compress("aaabccddeee"));
	}
	
	public static String compress(String string) {
		if(string.length() == 1)
			return string;
		else {
			String result = "";
			int connectedCount = 1, count = 1;
			char currentCharacter = string.charAt(0);
			while(count < string.length()) {
				if(string.charAt(count) == currentCharacter) {
					connectedCount++;
				}
				else {
					result += currentCharacter;
					if(connectedCount > 1) 
						result += connectedCount;
					currentCharacter = string.charAt(count);
					connectedCount = 1;
				}
				
				if(count == string.length() - 1) { // on exit
					result += string.charAt(count);
					if(connectedCount > 1) 
						result += connectedCount;
				}
				count++;
			}
			return result;
		}
		
	}

}
