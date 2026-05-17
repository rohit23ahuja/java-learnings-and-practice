package practice.generics;

public class Printer<T> {
    private final T t;

    public Printer(T t) {
        this.t = t;
    }

    public void print(){
        System.out.println(t);
    }
}
