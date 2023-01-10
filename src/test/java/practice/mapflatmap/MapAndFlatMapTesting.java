package practice.mapflatmap;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import practice.model.Book;

@Slf4j
public class MapAndFlatMapTesting {

	@Test
	public void givenListOfBooks_thenCapitalizeBookAuthors() {
		List<Book> books = Lists.newArrayList(new Book("East India Company", "William Darylmple", 700),
				new Book("Make Time", "Jake Knapp", 600), new Book("Atomic Habits", "James Clear", 500),
				new Book("Obesity Code", "Jason Fung", 400));

		List<String> authors = books.stream().map(book -> book.getAuthor().toUpperCase()).collect(Collectors.toList());

		Assertions.assertEquals(4, authors.size());
		Assertions.assertEquals("WILLIAM DARYLMPLE", authors.get(0));
	}

	@Test
	public void givenListOfListOfBooks_thenCapitalizeBookAuthors() {
		List<List<Book>> booksOfBooks = Lists.newArrayList(
				Lists.newArrayList(new Book("Make Time", "Jake Knapp", 600),
						new Book("Atomic Habits", "James Clear", 500)),
				Lists.newArrayList(new Book("Obesity Code", "Jason Fung", 400)),
				Lists.newArrayList(new Book("Shambala Sutras", "Abijit Banerjee", 200), new Book("East India Company", "William Darylmple", 700)));
		List<String> authors = booksOfBooks.stream().flatMap(Collection::stream).map(book-> book.getAuthor().toUpperCase()).collect(Collectors.toList());
		log.info("{}", authors);
		Assertions.assertEquals(5, authors.size());
		Assertions.assertEquals("JAKE KNAPP", authors.get(0));
	}
}
