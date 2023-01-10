package practice.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaStreamsPractice {

	@Test
	public void givenListOfString_ThenCapitalizeEachItemOfListUsingStream() {
		List<String> names = Arrays.asList("john", "doe", "marty", "bryde", "jonah", "marty", "john", "patrik");
		names = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		assertEquals("JOHN", names.get(0));
		assertEquals("PATRIK", names.get(names.size() - 1));
	}

	@Test
	public void givenListOfString_ThenConvertToMapWithValueAsOccurenceCount() {
		List<String> names = Arrays.asList("john", "doe", "marty", "bryde", "jonah", "marty", "john");
		Map<String, Long> countMap = names.stream().collect(Collectors.groupingBy(name -> name, Collectors.counting()));
		Assertions.assertEquals(countMap.get("john"), Long.valueOf("2"));
	}
}
