package cse3040ex2401;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"server is ready.");
		}catch(IOException e) {e.printStackTrace();}
		
		while(true) {
			try {
				System.out.println(getTime()+"waiting for clients.");
				Socket socket = serverSocket.accept();
				
				System.out.println(getTime()+"connection request from "+socket.getInetAddress());
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("{Notice} Test Message1 from Server.");
				System.out.println(getTime()+"sent message.");
				
				dos.close();
				socket.close();
			}catch(IOException e) {e.printStackTrace();}
		}
	}
}
