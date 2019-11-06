package ivanmarkovic.codingproblems.recursion;

public class Permutations {

	public static void main(String[] args) {
		
	}
	
	public static void permutations(String word) {
		permutationsHelper(word, "");
	}
	
	public static void permutationsHelper(String origin, String result) {
		if(origin.length() == 0)
			System.out.println(result);
		else {
			for(int i = 0; i < origin.length(); i++) {
				permutationsHelper(origin.substring(0, i) + origin.substring(i + 1), result + origin.charAt(i));
			}
		}
	}

}
