package practice.switchcase;

public class SwitchCase {

    public String getShortCode(String status) {
        if (null == status) return "U";
        return switch (status) {
            case "Petrol" -> "P";
            case "Diesel" -> "D";
            case "Electic" -> "E";
            case "Cng" -> "C";
            default -> "U";
        };
    }

}
