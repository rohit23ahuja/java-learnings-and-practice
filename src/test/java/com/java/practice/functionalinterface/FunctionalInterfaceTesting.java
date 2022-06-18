package com.java.practice.functionalinterface;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import com.java.practice.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalInterfaceTesting {

	@Test
	public void givenBooks_thenSortAndThenGetMiddleElement() {
		List<Book> books = Lists.newArrayList(new Book("Make Time", "Jake Knapp", 600),
				new Book("Atomic Habits", "James Clear", 500), new Book("Obesity Code", "Jason Fung", 400));
		ListFunctionalInterface<Book> li1 = (bs) -> {
			bs.sort((b1, b2) -> {
				if (b1.getPrice() < b2.getPrice()) {
					return -1;
				} else if (b1.getPrice() > b2.getPrice()) {
					return 1;
				} else {
					return 0;
				}
			});
			return bs;
		};
		ListFunctionalInterface<Book> li2 = (bs2) -> {
			bs2.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
			return bs2;
		};
		List<Book> result = li2.accept(li1.accept(books));
		Assertions.assertNotNull(result);
		log.info("Title of first item {}", result.get(0).getTitle());
		Assertions.assertEquals("Atomic Habits", result.get(0).getTitle());
	}

}
