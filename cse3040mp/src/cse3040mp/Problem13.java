package cse3040mp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Text {
	private BufferedReader br;
	private String chStr;

	Text() {
		chStr="";
	}

	public boolean readTextFromFile(String str) {
		try {
			br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found.");
			return false;
		}
		
		while (true) {
			String buffer;
			try {
				buffer = br.readLine();
				if (buffer == null)
					break;
				chStr += buffer.toLowerCase();
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int countChar(char c) {
		int pos = -1;
		int ans = 0;
		while ((pos=chStr.indexOf(c,pos+1))!=-1) {
			ans++;
		}
		return ans;
	}

}

public class Problem13 {
	public static void main(String[] args) {
		Text t = new Text();
		if (t.readTextFromFile("input_prob13.txt"))
			for (char c = 'a'; c <= 'z'; c++) {
				System.out.println(c + ": " + t.countChar(c));
			}
	}
}