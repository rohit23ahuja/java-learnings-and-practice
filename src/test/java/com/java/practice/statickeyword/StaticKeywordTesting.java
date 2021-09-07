package com.java.practice.statickeyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StaticKeywordTesting {

	@Test
	public void givenNullObject_whenAccessingStatic_thenReturnValue(){
		Employee e = null;
		Assertions.assertEquals(25, e.age);
	}
}
