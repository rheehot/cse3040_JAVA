package cse3040ex1204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileReader;

public class Ex12_04 {
	public static void main(String[] args) throws IOException{
		byte[] b= new byte[100];
		FileInputStream input = new FileInputStream("src/cse3040ex1204/myfile1.txt");
		while(true) {
			int rv=input.read(b);
			if(rv==-1) break;
			System.out.print(new String(b).substring(0,rv));
		}
		input.close();
		
		BufferedReader br = new BufferedReader(new FileReader("src/cse3040ex1204/myfile1.txt"));
		while(true) {
			String line = br.readLine();
			if(line==null) break;
			System.out.println(line);
		}
		br.close();
	}
}
