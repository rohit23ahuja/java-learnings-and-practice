package com.java.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import com.java.practice.model.Book;

public class PreLambdaSorting {

	@Test
	public void givenPreLambda_whenSortingBooksByTitle_thenCorrectlySorted() {
		List<Book> books = Lists.newArrayList(new Book("Atomic Habits", "James Clear"), new Book("Make Time", "Jake Knapp"));
		
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		
		Assertions.assertEquals(new Book("Atomic Habits", "James Clear"), books.get(0));
	}
}
