package cse3040ex1203;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_03 {
	public static void main(String[] args) throws IOException{
		String str="Hello, my name is Harry Poter.\nI am a student in the Java language class. \n";
		FileOutputStream output = new FileOutputStream("src/cse3040ex1203/myfile1.txt");
		byte[] bytes = new byte[1024];
		
		bytes = str.getBytes();
		output.write(bytes);
		output.close();
		
		FileWriter fw=new FileWriter("src/cse3040ex1203/myfile2.txt");
		fw.write(str);
		fw.close();
		
		PrintWriter pw = new PrintWriter("src/cse3040ex1203/myfile3.txt");
		pw.println(str);
		pw.close();
	}
}
