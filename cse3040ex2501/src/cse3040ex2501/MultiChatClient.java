package cse3040ex2501;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	static class ClientSender extends Thread{
		Socket socket;
		DataOutputStream out;
		String name;
		ClientSender(Socket socket, String name){
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			}catch(Exception e) {}
		}
		public void run() {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			try {
				if(out!=null) {
					out.writeUTF(name);
				}
				while(out!=null) {
					out.writeUTF("["+name+"]"+scanner.nextLine());
				}
			}catch(IOException e) {}
		}
	}
	
	static class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket=socket;
			try {
				in=new DataInputStream(socket.getInputStream());
			}catch(IOException e) {}
		}
		public void run() {
			while(in!=null) {
				try {
					System.out.println(in.readUTF());
				}catch(IOException e) {}
			}
		}
	}
	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("usage: java MultiChatClient username");
			System.exit(0);
		}
		try {
			String serverIp = "127.0.0.1";
			Socket socket = new Socket(serverIp,7777);
			System.out.println("connected to server.");
			Thread sender = new Thread(new ClientSender(socket,args[0]));
			Thread receiver = new Thread(new ClientReceiver(socket));
			sender.start();
			receiver.start();
		}catch(Exception e) {}
	}
}
