package palindromes;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Word kayak is palindrome : " + isPalindrome("kayak"));
		System.out.println("Word kayyak is palindrome : " + isPalindrome("kayyak"));
		System.out.println("Word level is palindrome : " + isPalindrome("level"));
		System.out.println("Word levsel is palindrome : " + isPalindrome("levsel"));
		
		List list = new List();
		String string = "This is m string!";
		for(int i = 0; i < string.length(); i++)
			list.addToHead(Character.toString(string.charAt(i)));
		list.printAll();
		list.deleteFromHead();
		list.deleteFromTail();
		list.printAll();
		
	}
	
	public static boolean isPalindrome(String string) {
		boolean isPalindromeFlag = true;
		List list = new List();
		for(int i = 0; i < string.length(); i++)
			list.addToHead(Character.toString(string.charAt(i)));
		while(list.size() > 1  && isPalindromeFlag) {
			if(!list.deleteFromHead().equals(list.deleteFromTail()))
				isPalindromeFlag = false;
		}
		return isPalindromeFlag;
	}

}
