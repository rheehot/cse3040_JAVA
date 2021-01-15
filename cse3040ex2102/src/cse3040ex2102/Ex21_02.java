package cse3040ex2102;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex21_02 {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {
			ip=InetAddress.getByName("www.naver.com");
			
			byte[] ipAdder = ip.getAddress();
			System.out.println("getAddress(): "+Arrays.toString(ipAdder));
			
			String result="";
			for(int i = 0 ;i<ipAdder.length;++i) {
				result+=(ipAdder[i]<0)?ipAdder[i]+256:ipAdder[i];
				result+=".";
			}
			System.out.println("dotted decimal: "+ result);
			System.out.println();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
