package practice.generics;

public class GenericsPractice {
    public static void main(String[] args) {
        Printer<Integer> ip = new Printer<>(23);
        ip.print();

        Printer<Double> dp = new Printer<>(23.0);
        dp.print();

        Printer<String> sp = new Printer<>("23");
        sp.print();
        
    }
}
