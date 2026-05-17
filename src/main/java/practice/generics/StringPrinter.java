package practice.generics;

public class StringPrinter {
    private final String thingToPrint;

    public StringPrinter(String thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
