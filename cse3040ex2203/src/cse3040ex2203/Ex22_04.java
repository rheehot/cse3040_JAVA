package cse3040ex2203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class Ex22_04 {
	static ArrayList<String> lines = new ArrayList<String>();
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
        
        // ���������� ����Ʈ�������� �����ִ� �������� ���Ϸ� �Ǿ� �ִ�.
		String address = "http://www.kyobobook.co.kr/bestSellerNew/bestseller.laf";
		String line = "";
        
        // ����Ʈ ������ ������ �̾Ƴ���
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
            
            // �ϴ� �о�鿩�� Line by Line���� �����Ѵ�.
			while((line=input.readLine()) != null) {
				if(line.trim().length() > 0) lines.add(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
        
		int rank = 1;
		int status = 0;
        
        // ���پ� ������ ���鼭 �����͸� �м��Ѵ�.
		for(int i=0; i<lines.size(); i++) {
			String l = lines.get(i);
			if(status == 0) {
				if(l.contains("div class=\"detail\"")) status = 1;
			} else if(status == 1) {
				if(l.contains("div class=\"title\"")) status = 2;
			} else if(status == 2) {
				if(l.contains("a href")) {
					int begin = l.indexOf("<strong>") + "<strong>".length();
					int end = l.indexOf("</strong>");
					System.out.println(rank + "��: " + l.substring(begin, end));
					status = 0;
					rank++;
				}
			}
		}
	}
}
