package cse3040ex2202;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Ex22_02 {
	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		String address="https://icslsogang.github.io/courses/cse3040/sogang_campus.jpg";
		
		int ch = 0;
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("sogang_campus.jpg");
			
			while((ch=in.read()) !=-1) {
				out.write(ch);
			}
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("File download complete.");
	}
}
