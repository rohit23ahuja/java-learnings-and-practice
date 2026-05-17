package practice.generics;

public class IntegerPrinter {
    private final Integer thingToPrint;

    public IntegerPrinter(Integer thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
