package practice.generics;

public class DoublePrinter {
    private final Double thingToPrint;

    public DoublePrinter(Double thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
