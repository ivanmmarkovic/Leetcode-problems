import java.io.*;

public class WordCounter {

	public static void main(String[] args) {
		
	}
	
	public static int wordCounter(String src,String word) {
		int count = 0, index = src.indexOf(word);
		while(index >= 0) {
			count++;
			index = src.indexOf(word, index += word.length());
		}
		return count;
	}
	
	public static int wordCounterFromEnd(String src, String word) {
		int count = 0, index = src.lastIndexOf(word);
		while(index >= 0) {
			count++;
			index = src.lastIndexOf(word, index -= word.length());
		}
		return count;
	}
	
	public static int wordCounterInFile(String fileName, String word) {
		String text = "";
		try {
			FileReader f = new FileReader(fileName);
			BufferedReader b = new BufferedReader(f);
			String line;
			while((line = b.readLine()) != null)
				text += line;
			b.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return wordCounter(text, word);
	}
}
