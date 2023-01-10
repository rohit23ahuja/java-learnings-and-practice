package practice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

	private Long id;

	private String isbn;

	private String title;

	private String author;

	private Integer price;

	private Integer quantity;

	private int version;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public Book(String title, String author, Integer price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	
	public boolean equals(Object o2) {
		if (this == o2) {
			return true;
		}
		if (o2 == null) {
			return false;
		}
		if (getClass() != o2.getClass()) {
			return false;
		}

		Book book2 = (Book) o2;

		if (title.equals(book2.getTitle())) {
			return author.equals(book2.getAuthor());
		} else {
			return false;
		}
	}

	public int hashCode() {
		int hash = 53 * 3;
		hash = hash + (title != null ? title.hashCode() * 3 : 0);
		return hash;
	}

	public static int compareByTitleThenAuthor(Book b1, Book b2) {
		if (b1.getTitle().equals(b2.getTitle())) {
			return b1.getAuthor().compareTo(b2.getAuthor());
		} else {
			return b1.getTitle().compareTo(b2.getTitle());
		}
	}

}