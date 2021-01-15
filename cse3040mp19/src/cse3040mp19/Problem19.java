package cse3040mp19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

class BookInfo implements Comparable<BookInfo> {
	private String title;
	private String author;
	private String price;
	private int rank = 1;

	BookInfo(int rank, String title, String author, String price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public int compareTo(BookInfo o) {
		return o.rank - this.rank;
	}

	public String toString() {
		return "#" + (rank) + " " + title + ", " + author + ", " + price;
	}
}

class BookReader {
	private static ArrayList<String> lines = new ArrayList<>();

	public static ArrayList<BookInfo> readBooks(String path) {
		URL url = null;
		String line = "";
		BufferedReader br = null;
		ArrayList<BookInfo> bk = new ArrayList<>();
		try {
			url = new URL(path);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = br.readLine()) != null) {
				if (line.trim().length() > 0)
					lines.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int rank = 1;
		int status = 0;
		String title = "";
		String author = "";
		String price = "";

		try {
			for (int i = 0; i < lines.size(); ++i) {
				String l = lines.get(i);

				if (status == 0) {
					if (l.contains("div class=\"col-lg-9 product-info-listView\""))
						status = 1;
				} else if (status == 1) {
					if (l.contains("h3 class=\"product-info-title\""))
						status = 2;
				} else if (status == 2) {
					if (l.contains("href=")) {
						int tb = l.indexOf("href=\"") + "href=\"".length();
						int begin = l.indexOf(">", tb) + 1;
						int end = l.indexOf("</a>");
						title = l.substring(begin, end);
						status = 3;
					}
				} else if (status == 3) {
					if (l.contains("div class=\"product-shelf-author contributors\"")) {
						int tb = l.indexOf("<a href=") + "<a href=".length();
						int begin = l.indexOf(">", tb) + 1;
						int end = l.indexOf("</a>");
						author = l.substring(begin, end);
						status = 4;
					}
				} else if (status == 4) {
					if (l.contains("td class=\"buy-new three-column-padding\""))
						status = 5;
				} else if (status == 5) {
					if (l.contains("class=\" current link\"")) {
						int tb = l.indexOf("<a title=") + "<a title=".length();
						int begin = l.indexOf(">", tb) + 1;
						int end = l.indexOf("</a>");
						price = l.substring(begin, end);

						bk.add(new BookInfo(rank++, title, author, price));
						status = 0;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bk;
	}
}

public class Problem19 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooks("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for (int i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}