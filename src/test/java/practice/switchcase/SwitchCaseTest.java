package practice.switchcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SwitchCaseTest {

    @Test
    public void whenValidValue1_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = "Petrol";
        String o = s.getShortCode(i);
        assertEquals("P", o);
    }

    @Test
    public void whenValidValue2_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = "Diesel";
        String o = s.getShortCode(i);
        assertEquals("D", o);
    }
    
    @Test
    public void whenArgumentMixedCase_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = "petRoL";
        String o = s.getShortCode(i);
        assertEquals("P", o);
    }


    @Test
    public void whenArgumentInvalidValue_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = "rohit";
        String o = s.getShortCode(i);
        assertEquals("U", o);
    }

    @Test
    public void whenArgumentNull_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = null;
        String o = s.getShortCode(i);
        assertEquals("U", o);
    }

    @Test
    public void whenArgumentEmpty_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = "";
        String o = s.getShortCode(i);
        assertEquals("U", o);
    }

    @Test
    public void whenArgumentNumber_thenReturnShortCode() {
        SwitchCase s = new SwitchCase();
        String i = "123";
        String o = s.getShortCode(i);
        assertEquals("U", o);
    }
}
