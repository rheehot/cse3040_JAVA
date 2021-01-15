package cse3040ex2104;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Ex21_04 {
	public static void main(String[] args) {
		try {
			//URL url = new URL("http://www.google.com");
			URL url = new URL("https://en.wikipedia.org/wiki/Java_(programming_language)#Syntax");
			
			System.out.println("authority: "+url.getAuthority());
			System.out.println("content: "+url.getContent());
			System.out.println("default port: "+url.getDefaultPort());
			System.out.println("port: "+ url.getPort());
			System.out.println("file: "+url.getFile());
			System.out.println("host: "+url.getHost());
			System.out.println("path: "+url.getPath());
			System.out.println("protocol: "+url.getProtocol());
			System.out.println("query: "+url.getQuery());
			System.out.println("ref: "+url.getRef());
			System.out.println("userinfo: "+url.getUserInfo());
			System.out.println("external form: "+url.toExternalForm());
			System.out.println("url: "+url.toURI());
		}catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
