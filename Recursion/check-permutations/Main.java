class Main {
	
	public static void main(String args[]) {
		permute("ivan");
	}
	
	public static void permuteHelper(String s, String chosen) {
		if(s.isEmpty())
			System.out.println(chosen);
		else {
			// choose - explore - unchose
			for(int i = 0; i < s.length(); i++) {
				// choose
				char c = s.charAt(i);
				chosen += c;
				s = s.substring(0, i) + s.substring(i + 1); // remove  character on i
				
				// explore
				permuteHelper(s, chosen);
				
				// un-choose
				s = s.substring(0, i) + c + s.substring(i); // return  character on i
				chosen = chosen.substring(0, chosen.length() - 1); 
			}
		}
	}
	
	public static void permute(String string) {
		permuteHelper(string, "");
	}
	
	
	
}