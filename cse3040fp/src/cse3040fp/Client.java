package cse3040fp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;



public class Client {

	static class ClientSender extends Thread {
		private DataOutputStream out;
		private String name;

		ClientSender(Socket socket, String name) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void run() {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String title, author, order, sender = "";
			
			// 총 6가지 경우에 대해서 입력을 받게 됨
			try {
				if (out != null) {
					out.writeUTF(name);
					sleep(100);
				}
				while (out != null) {
					System.out.print("\n"+name + ">> ");
					order = scanner.nextLine().trim().toLowerCase();
					
					switch (order) {
					case "add":
						System.out.print("add-title> ");
						title = scanner.nextLine().trim();
						System.out.print("add-author> ");
						author = scanner.nextLine().trim();
						if (title.equals(" ") || title.equals("") || author.equals("") || author.equals(" ")) {
						} else {
							sender = "add" + "\t" + title + "\t" + author;
							try {
								out.writeUTF(sender);
								sleep(100);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						break;
					case "borrow":
						System.out.print("borrow-title> ");
						title = scanner.nextLine().trim();
						if (title.equals(" ") || title.equals("")) {
						} else {
							sender = "borrow" + "\t" + title;
							try {
								out.writeUTF(sender);
								sleep(100);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						break;
					case "return":
						System.out.print("return-title> ");
						title = scanner.nextLine().trim();
						if (title.equals(" ") || title.equals("")) {
						} else {
							sender = "return" + "\t" + title;
							try {
								out.writeUTF(sender);
								sleep(100);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						break;
					case "info":
						sender = "info"+"\t"+name;
						try {
							out.writeUTF(sender);
							sleep(100);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "search":
						while(true) {
							System.out.print("search-string> ");
							title=scanner.nextLine().trim();
							if(title.length()<3) {
								System.out.println("Search string must be longer than 2 characters.");
							}else if(title.equals("") || title.equals(" ")) {}
							else {
								sender="search"+"\t"+title;
								try {
									out.writeUTF(sender);
									sleep(100);
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							}
						}
						break;
					default:
						System.out.println("[available commands]\n" + "add: add a new book to the list of books.\n"
								+ "borrow: borrow a book from the library.\n"
								+ "return: return a book to the library.\n"
								+ "info: show list of books I am currently borrowing.\n" + "search: search for books.");
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	static class ClientReceiver extends Thread {
		private DataInputStream in;

		ClientReceiver(Socket socket) {
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String Line;
			String order[];
			//총 8가지 경우에 대해서 출력을 맡게 됨
			while (in != null) {
				try {
					Line=in.readUTF();
					order=Line.split("\t");
					switch(order[0]) {
					case "addS":
						System.out.println("A new book added to the list.");
						break;
					case "addF":
						System.out.println("The book already exists in the list.");
						break;
					case "borrowS":
						System.out.println("You borrowed a book. - "+order[1]);
						break;
					case "borrowF":
						System.out.println("The book is not available.");
						break;
					case "returnS":
						System.out.println("You returned a book. - "+order[1]);
						break;
					case "returnF":
						System.out.println("You did not borrow the book.");
						break;
					case "info":
						System.out.println("You are currently borrowing "+(order.length-1)+ " books:");
						for (int i = 1 ; i<order.length;++i) {
							System.out.println((i)+". "+order[i]);
						}
						break;
					case "search":
						System.out.println("Your search matched "+(order.length-1)+ "  results.");
						for (int i = 1 ; i<order.length;++i) {
							System.out.println((i)+". "+order[i]);
						}
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Please give the IP address and port number as arguments.");
			System.exit(0);
		}

		try {
			Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
			String name = "";
			while (true) {
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter UserID>> ");
				name = scan.nextLine();
				if (name.contains(" ") || !name.matches("^[0-9|a-z]*$") || name.equals("")) {
					System.out.print("UserID must be a single word with lowercase alphabets and numbers.\n");
				} else {
					System.out.println("Hello "+name + "!");
					break;
				}
			}
			Thread sender = new Thread(new ClientSender(socket, name));
			Thread receiver = new Thread(new ClientReceiver(socket));
			sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
