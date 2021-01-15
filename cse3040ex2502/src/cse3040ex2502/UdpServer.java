package cse3040ex2502;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	@SuppressWarnings("all")
	public void start() throws IOException {
		DatagramSocket socket = new DatagramSocket(7777);
		DatagramPacket inPacket, outPacket;
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		
        //while 문으로 데이터를 계속 받아온다.
		while(true) {
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			socket.receive(inPacket);
			InetAddress address = inPacket.getAddress();
            //데이터를 보내줄때 필요하기 때문에 포트번호도 받아옴
			int port = inPacket.getPort();
            
            //String으로 데이터를 받아와서 패킷을 만들어서 데이터 전송
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes();
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
		}
	}
        
	public static void main(String args[]) {
		try {
			new UdpServer().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}