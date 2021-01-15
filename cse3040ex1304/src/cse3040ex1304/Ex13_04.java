package cse3040ex1304;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex13_04 {
	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("..\\cse3040ex1204\\src\\cse3040ex1204\\myfile1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			return;
		}

		while (true) {
			try {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
