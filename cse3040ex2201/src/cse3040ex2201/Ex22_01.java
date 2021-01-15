package cse3040ex2201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex22_01 {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address="https://icslsogang.github.io/courses/cse3040/hello.html";
		//String address="https://www.naver.com";
		String line="";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while((line=input.readLine())!=null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
