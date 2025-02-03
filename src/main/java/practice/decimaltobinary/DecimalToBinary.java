package practice.decimaltobinary;

public class DecimalToBinary {
    public String convert(int number){
        StringBuilder binaryBuilder = new StringBuilder();
        if(number ==0) return "0";
        while (number>0){
            binaryBuilder.append(number%2);
            number/=2;
        }
        return binaryBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        // gives remainder
        System.out.println(""+5%2);
        // gives quotient
        System.out.println(""+5/2);
    }
}
