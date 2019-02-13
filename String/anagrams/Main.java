package anagrams;

import java.util.Arrays;

/*
 * Given two strings, write a function to determine wheter 
 * they are anagrams
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Debit card and Bad credit are anagrams : " + areStringsAnagrams("Debit card", "Bad credit"));
		System.out.println("Python and typhon are anagrams : " + areStringsAnagrams("Python", "typhon"));
		System.out.println("Astronomer and Moon starrer are anagrams : " + areStringsAnagrams("Astronomer", "Moon starrer"));
		
	}
	
	public static boolean areStringsAnagrams(String string1, String string2) {
		boolean areAnagrams = true;
		if(string1.length() != string2.length())
			areAnagrams = false;
		else {
			String array1[] = string1.toLowerCase().replaceAll(" ", "").split("");
			String array2[] = string2.toLowerCase().replaceAll(" ", "").split("");
			Arrays.sort(array1);
			Arrays.sort(array2);
			int counter = 0;
			while(counter < array1.length && areAnagrams) {
				if(!array1[counter].equals(array2[counter]))
					areAnagrams = false;
				else
					counter++;
			}
		}
		return areAnagrams;
	}
}
