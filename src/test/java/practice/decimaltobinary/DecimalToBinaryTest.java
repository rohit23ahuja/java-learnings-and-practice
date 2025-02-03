package practice.decimaltobinary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecimalToBinaryTest {

    @Test
    public void givenNumber5_ThenReturnBinaryRepresentation(){
        int number = 5;
        DecimalToBinary dtb = new DecimalToBinary();
        Assertions.assertEquals(Integer.toBinaryString(number), dtb.convert(number));
    }

    @Test
    public void givenNumber3_ThenReturnBinaryRepresentation(){
        int number = 3;
        DecimalToBinary dtb = new DecimalToBinary();
        Assertions.assertEquals(Integer.toBinaryString(number), dtb.convert(number));
    }

    @Test
    public void givenNumber4_ThenReturnBinaryRepresentation(){
        int number = 4;
        DecimalToBinary dtb = new DecimalToBinary();
        Assertions.assertEquals(Integer.toBinaryString(number), dtb.convert(number));
    }

    @Test
    public void givenNumber0_ThenReturnBinaryRepresentation(){
        int number = 0;
        DecimalToBinary dtb = new DecimalToBinary();
        Assertions.assertEquals(Integer.toBinaryString(number), dtb.convert(number));
    }

    @Test
    public void givenNumber343_ThenReturnBinaryRepresentation(){
        int number = 343;
        DecimalToBinary dtb = new DecimalToBinary();
        Assertions.assertEquals(Integer.toBinaryString(number), dtb.convert(number));
    }
}
