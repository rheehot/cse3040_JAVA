package cse3040mp20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	public static ArrayList<BookInfo> readBooksJsoup(String path) {
		Document doc = null;
		ArrayList<BookInfo> bi = new ArrayList<>();

		try {
			doc = Jsoup.connect(path).get();
			Elements data = doc.select("ol.product-shelf-list.product-list-view").select("div.col-lg-9.product-info-listView");
			int rank =1;
			for(Element list:data) {
				String title=list.select("h3.product-info-title").select("a").first().text();
				String author = list.select("div.product-shelf-author.contributors").select("a").first().text();
				String price = list.select("span.current").select("a").first().text();
				bi.add(new BookInfo(rank++,title,author,price));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return bi;
	}
}

public class Problem20 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooksJsoup("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for (int i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}
