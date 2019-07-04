import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {

        BigDecimal income = new BigDecimal(0);
        income = new BigDecimal("85528");
        BigDecimal output;

        //0
        //-1
        //a
        //1
        //556.01
        //556.02
        //556.03
        //85527
        //85528
        //85529

        int firstThreeshold = 18, secondThreshold = 32;

        final BigDecimal personalAllowance = new BigDecimal(556.02);
        final BigDecimal threshold = new BigDecimal(85527);

        if (income.compareTo(threshold) > 0) {
            output = new BigDecimal(14839.02);
            output = output.add(new BigDecimal(0.32).multiply(income.subtract(threshold)));
            System.out.println(output.setScale(0, RoundingMode.HALF_UP));
        } else {
            output = new BigDecimal(0.18).multiply(income).subtract(personalAllowance);
            if (output.compareTo(new BigDecimal(0)) < 0) {
                System.out.println(0);
            } else {
                System.out.println(output.setScale(0, RoundingMode.HALF_UP));
            }
        }

    }

}
