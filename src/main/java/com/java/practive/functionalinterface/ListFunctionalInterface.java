package com.java.practive.functionalinterface;

import java.util.List;

public interface ListFunctionalInterface <T> {

	List<T> accept(List<T> list);
}