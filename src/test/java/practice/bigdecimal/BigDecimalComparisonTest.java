package practice.bigdecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigDecimalComparisonTest {

    @Test
    public void givenBigDecimalValue1_thenDoComparison() {
        BigDecimal input = new BigDecimal("161");

        Boolean result = input != null
                && input.compareTo(new BigDecimal("1169")) == 1
                && input.compareTo(new BigDecimal("1181")) == -1;

        assertEquals(false, result);
    }

    @Test
    public void givenBigDecimalValue2_thenDoComparison() {
        BigDecimal input = new BigDecimal("1178");

        Boolean result = input != null
                && input.compareTo(new BigDecimal("1169")) == 1
                && input.compareTo(new BigDecimal("1181")) == -1;

        assertEquals(true, result);
    }

    @Test
    public void givenBigDecimalValue3_thenDoComparison() {
        BigDecimal input = new BigDecimal("2000");

        Boolean result = input != null
                && input.compareTo(new BigDecimal("1169")) == 1
                && input.compareTo(new BigDecimal("1181")) == -1;

        assertEquals(false, result);
    }
}
