package practice.switchcase;

public class SwitchCase {

    public String getShortCode(String status) {
        if (null == status) return "U";
        return switch (status.toLowerCase()) {
            case "petrol" -> "P";
            case "diesel" -> "D";
            case "electic" -> "E";
            case "cng" -> "C";
            default -> "U";
        };
    }

}
