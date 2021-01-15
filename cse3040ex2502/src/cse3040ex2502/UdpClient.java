package cse3040ex2502;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpClient {
	@SuppressWarnings("all")
	public void start() throws IOException, UnknownHostException {
    //Socket을 먼저 제작 이때 보면 따로 연결한다는 개념이 없다.
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		byte[] msg = new byte[100];
        
        //패킷을 제작해서 메세지를 보내고 받는다.(1byte 짜리)
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		datagramSocket.send(outPacket);
		datagramSocket.receive(inPacket);
		System.out.println("current server time: " + new String(inPacket.getData()));
	}
    
	public static void main(String args[]) {
		try {
			new UdpClient().start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}