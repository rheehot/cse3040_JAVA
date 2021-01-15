package cse3040ex2404;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("server is ready.");
			socket = serverSocket.accept();
            
            //Sender와 Reciver 객체를 만들어서 시작한다.
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Sender extends Thread {
	//소켓, DataOutputStream, name이 존재
	Socket socket;
	DataOutputStream out;
	String name;
    
    //초기화
	Sender(Socket socket) {
		this.socket = socket;
		try {
        //DataOutputStream을 제작하고 사용한다.
			out = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getLocalAddress()+":"+socket.getLocalPort()+"]";
		} catch(Exception e) {}
	}

	public void run() {
    	//사용자가 입력하면 그걸 output으로 보내주는 거이다.
		Scanner scanner = new Scanner(System.in);
		while (out != null) {
			try {
				out.writeUTF(name+scanner.nextLine());
			} catch(IOException e) {}
		}
	}
}

class Receiver extends Thread {
	Socket socket;
	DataInputStream in;
    
	Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch(IOException e) {}
	}
    
	public void run() {
    	//network에서 메세지가 오면 계속 출력한다.
		while ( in != null ) {
			try {
            //네트워크로부터 데이터를 읽어온다.
				System.out.println(in.readUTF());
			} catch(IOException e) {}
		}
	}
}

