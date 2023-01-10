package practice.lambdasandstreams;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

import practice.model.Book;

/**
 * Sorting List<Book> using Lambda expressions and Streams. Also trying out new
 * methods of Comparator interface.
 * 
 * @author rohitahuja
 *
 */
public class BookSortingUsingLambdaAndStreams {

	@Test
	public void givenLambda_whenSortingBooksByTitle_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Atomic Habits", "James Clear"),
				new Book("Make Time", "Jake Knapp"));

		books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}

	@Test
	public void givenStaticMethod_whenSortingBooksByTitleAndAuthor_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Atomic Habits", "James Clear"),
				new Book("Make Time", "Jake Knapp"));

		books.sort(Book::compareByTitleThenAuthor);

		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}

	@Test
	public void givenInstanceMethod_whenSortingBooksByTitle_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Atomic Habits", "James Clear"),
				new Book("Make Time", "Jake Knapp"));
		books.sort(Comparator.comparing(Book::getTitle));
		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}

	@Test
	public void whenSortingBooksInReverseOrder_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Atomic Habits", "James Clear"),
				new Book("Make Time", "Jake Knapp"));
		Comparator<Book> titleComparator = (b1, b2) -> b1.getTitle().compareTo(b2.getTitle());

		books.sort(titleComparator.reversed());

		Assertions.assertEquals(new Book("Make Time", "Jake Knapp"), books.get(0));
	}

	@Test
	public void whenSortingBooksByTittleThenAuthor_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Make Time", "Jake Knapp"),
				new Book("Obesity Code", "Jason Fung"), new Book("Atomic Habits", "James Clear"));

		books.sort((b1, b2) -> {
			if (b1.getTitle().equals(b2.getTitle())) {
				return b1.getAuthor().compareTo(b2.getAuthor());
			} else {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}

	@Test
	public void givenComposition_whenSortingBooksByTittleThenAuthor_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Make Time", "Jake Knapp"),
				new Book("Obesity Code", "Jason Fung"), new Book("Atomic Habits", "James Clear"));

		books.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor));

		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}

	@Test
	public void givenStream_whenSortingBooksByTitleThenAuthor_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Make Time", "Jake Knapp"),
				new Book("Atomic Habits", "James Clear"), new Book("Obesity Code", "Jason Fung"));

		books = books.stream()
				.sorted(Comparator.comparing(Book::getTitle).thenComparing(Comparator.comparing(Book::getAuthor)))
				.collect(Collectors.toList());

		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}

	@Test
	public void whenSortingBooksWithNullItem_thenThrowNullPointerException() {
		List<Book> books = Lists.newArrayList(null, new Book("Obesity Code", "Jason Fung"));

		assertThrows(NullPointerException.class, () -> books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())));
	}

	@Test
	public void givenANullItem_whenSortingBooksByTitle_thenMoveNullsToLast() {
		List<Book> books = Lists.newArrayList(null, new Book("Obesity Code", "Jason Fung"), null);

		books.sort(Comparator.nullsLast(Comparator.comparing(Book::getTitle)));

		Assertions.assertEquals(new Book("Obesity Code", "Jason Fung"), books.get(0));
		Assertions.assertNull(books.get(1));
		Assertions.assertNull(books.get(2));
	}
	
	@Test
	public void whenSortingBooksByIncreasingPrice_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Make Time", "Jake Knapp", 600),
				new Book("Atomic Habits", "James Clear", 500), new Book("Obesity Code", "Jason Fung", 400));

		books.sort((b1, b2) -> {
			if (b1.getPrice() < b2.getPrice()) {
				return -1;
			} else if (b1.getPrice() > b2.getPrice()) {
				return 1;
			} else {
				return 0;
			}
		});
		Assertions.assertEquals(books.get(0).getPrice(), 400);
		Assertions.assertEquals(books.get(1).getPrice(), 500);
		Assertions.assertEquals(books.get(2).getPrice(), 600);
	}
}
