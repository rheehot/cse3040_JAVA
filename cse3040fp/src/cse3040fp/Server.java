package cse3040fp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
class chMap extends TreeMap<String, List<String>> {

	@Override
	public String toString() {
		String ans = "";
		List<Map.Entry<String, List<String>>> list = new ArrayList<>(super.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, List<String>>>() {
			@Override
			public int compare(Map.Entry<String, List<String>> o1,Map.Entry<String, List<String>> o2) {
				return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
			}
		});
		for(Map.Entry<String, List<String>> entry : list) {
			System.out.println(entry.getKey() + " : " + entry.getValue().get(0)+ " : " + entry.getValue().get(1));
		}
		return ans;
	}
}

public class Server {
	private HashMap<String, DataOutputStream> clients;
	private static Map<String, List<String>> BookList;

	Server() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}

	public void start(int port) {
		// 네트워크를 연결할 serverSocket과
		// 데이터를 받아올 socket
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버단과 함께 입력된 포트 번호를 기준으로 새로운 소켓 제작
			serverSocket = new ServerSocket(port);

			// Client가 올 때마다 소켓을 연결해줌
			while (true) {
				socket = serverSocket.accept();
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readBooks(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (true) {
				String Line = br.readLine();
				if (Line == null)
					break;
				String[] sLine = Line.split("\t");
				List<String> temp = new ArrayList<>();
				temp.add(sLine[1]);
				temp.add(sLine[2]);
				BookList.put(sLine[0], temp);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Input file not found.");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(BookList);
	}

	public static void main(String args[]) {
		// 성분을 제대로 주었을 경우에만 작동
		if (args.length != 1) {
			System.out.println("Please give the port number as an argument.");
			System.exit(0);
		} else {
			//프로그램이 시작되면 라이브러리를 제작함
			BookList =new chMap();
			readBooks("books.txt");
			new Server().start(Integer.parseInt(args[0]));
		}
	}

	synchronized void writeFile() {
		try {
			@SuppressWarnings("resource")
			OutputStream out = new FileOutputStream("books.txt");
			String ans="";
			
			List<Map.Entry<String, List<String>>> list = new ArrayList<>(BookList.entrySet());
			Collections.sort(list,new Comparator<Map.Entry<String, List<String>>>() {
				@Override
				public int compare(Map.Entry<String, List<String>> o1,Map.Entry<String, List<String>> o2) {
					return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
				}
			});
			for(Map.Entry<String, List<String>> entry : list) {
				ans = entry.getKey() + "\t" + entry.getValue().get(0) + "\t" + entry.getValue().get(1) + "\t\n";
				out.write(ans.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	synchronized boolean addBook(String title, String author) {
		Iterator<Map.Entry<String, List<String>>> it = BookList.entrySet().iterator();
		try {
			while (it.hasNext()) {
				Map.Entry<String, List<String>> entry = it.next();
				if (entry.getKey().toString().toLowerCase().equals(title.toLowerCase())) {
					return false;
				}
			}

			List<String> temp = new ArrayList<String>();
			temp.add(author);temp.add("-");
			
			BookList.put(title, temp);
			writeFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		return true;
	}

	synchronized String borrowBook(String title, String borrower) {
		Iterator<Map.Entry<String, List<String>>> it = BookList.entrySet().iterator();
		try {
			while (it.hasNext()) {
				Map.Entry<String, List<String>> entry = it.next();
				String borrowBook = entry.getKey().toString();
				if (borrowBook.toLowerCase().equals(title.toLowerCase()) && entry.getValue().get(1).equals("-")) {
					BookList.get(borrowBook).set(1, borrower);
					writeFile();
					return borrowBook;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

	synchronized String returnBook(String title, String returner) {
		Iterator<Map.Entry<String, List<String>>> it = BookList.entrySet().iterator();
		try {			
			while (it.hasNext()) {
				Map.Entry<String, List<String>> entry = it.next();
				String borrowBook = entry.getKey().toString();
				if (borrowBook.toLowerCase().equals(title.toLowerCase()) && !BookList.get(borrowBook).get(1).equals("-")) {
					BookList.get(borrowBook).set(1, "-");
					writeFile();
					return borrowBook;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

	String infoBook(String name) {
		String ans = "";
		Iterator<Map.Entry<String, List<String>>> it = BookList.entrySet().iterator();
		
		try {
			if (name.equals("-"))
				return "";
			while (it.hasNext()) {
				Map.Entry<String, List<String>> entry = it.next();
				String borrowBook = entry.getKey().toString();
				if (BookList.get(borrowBook).get(1).equals(name)) {
					ans += "\t" + borrowBook + ", " + BookList.get(borrowBook).get(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ans;
	}

	String searchBook(String word) {
		String ans = "";
		Iterator<Map.Entry<String, List<String>>> it = BookList.entrySet().iterator();
		try {
			while (it.hasNext()) {
				Map.Entry<String, List<String>> entry = it.next();
				String borrowBook = entry.getKey().toString();
				if (BookList.get(borrowBook).get(0).toLowerCase().indexOf(word.toLowerCase()) >= 0
						|| borrowBook.toLowerCase().indexOf(word.toLowerCase()) >= 0) {
					ans += "\t" + borrowBook + ", " + BookList.get(borrowBook).get(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ans;
	}

	//////////////////////////////////////
	///// Server Main Function ///////////
	/////////////////////////////////////
	class ServerReceiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;

		// 크라이언트를 받아들이고 Stream을 연결
		ServerReceiver(Socket socket) {
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String name = "";
			String Line, order[];
			String bookname = "";
			try {
				name = in.readUTF();
				clients.put(name, out);
				System.out.println(name + " login");

				while (in != null) {
					Line = in.readUTF();
					if (Line == null)
						break;
					order = Line.split("\t");
					switch (order[0]) {
					case "add":
						if (addBook(order[1], order[2])) {
							System.out.println(name + "added new Book : " + order[1] + ", " + order[2]);
							System.out.println(BookList);
							out.writeUTF("addS");
						} else {
							System.out.println(order[0] + "adding is Blocked");
							out.writeUTF("addF");
						}
						break;
					case "borrow":
						if ((bookname = borrowBook(order[1], name)) != "") {
							System.out.println(name + " borrowed Book : " + order[1]);
							System.out.println(BookList);
							out.writeUTF("borrowS\t" + bookname);
						} else {
							System.out.println(name + " can't borrow book : " + order[1]);
							out.writeUTF("borrowF");
						}
						break;
					case "return":
						if ((bookname = returnBook(order[1], name)) != "") {
							System.out.println(name + " returned Book : " + order[1]);
							System.out.println(BookList);
							out.writeUTF("returnS\t" + bookname);
						} else {
							System.out.println(name + " cant's return book: " + order[1]);
							out.writeUTF("returnF");
						}
						break;
					case "info":
						
						System.out.println(name + " looking for borrowed books");
						out.writeUTF("info" + infoBook(name));
						break;
					case "search":
						System.out.println(name + " looking for specific books");
						out.writeUTF("search" + searchBook(order[1]));
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}finally {
				System.out.println(name + " logout");
				clients.remove(name);
			}
		}

	}
}
