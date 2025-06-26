package practice.reflections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.model.Book;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodReflectionTest {

    @Test
    public void testMethodNamesPresent() {
        Method[] methods = Book.class.getMethods();
        Assertions.assertEquals("equals", Arrays.stream(methods).filter(method -> method.getName().equals("equals")).findAny().get().getName());
    }
}
