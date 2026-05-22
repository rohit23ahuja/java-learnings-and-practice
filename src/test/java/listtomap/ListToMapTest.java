package listtomap;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapTest {

    @Test
    public void givenListOfStrings_ThenConvertToMapWithCountAsValue(){

        List<String> input = Lists.newArrayList("Marty", "Jonah", "Wendy", "Marty", "Charlotte", "Marty", "Jonah");

        Map<String, Long> output = input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Assertions.assertEquals(3, output.get("Marty"));
        Assertions.assertEquals(2, output.get("Jonah"));
        Assertions.assertEquals(1, output.get("Wendy"));
    }
}
