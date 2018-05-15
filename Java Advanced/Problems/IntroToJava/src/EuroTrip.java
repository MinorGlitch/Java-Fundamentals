import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wurstQuantity = Double.parseDouble(scanner.nextLine());

        BigDecimal conversionRate = new BigDecimal("4210500000000");

        BigDecimal wurstPrice = new BigDecimal(wurstQuantity * 1.2D);
        BigDecimal totalPrice = conversionRate.multiply(wurstPrice);

        System.out.printf("%.2f marks", totalPrice);
    }
}
