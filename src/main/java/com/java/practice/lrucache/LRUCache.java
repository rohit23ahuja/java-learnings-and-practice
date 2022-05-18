package com.java.practice.lrucache;

import java.util.LinkedList;
import java.util.NoSuchElementException;


public class LRUCache {
	private LinkedList<Integer> integerCache;

	public LRUCache() {
		integerCache = new LinkedList<Integer>();
	}

	// 1. If item exists, move the item to the front of the list and return it.
	// 2. If item does not exists, return null.
	public Integer get(Integer input) {
		Integer output = null;
		for (Integer i : integerCache) {
			if (input.equals(i)) {
				
				return i;
			}
		}
		return null;
	}

	public void put(Integer b) {
		try {
			integerCache.removeLast();
		} catch (NoSuchElementException e) {
			System.err.println("List is empty");
		}
		integerCache.push(b);
	}
}
