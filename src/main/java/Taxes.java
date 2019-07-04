import java.math.BigDecimal;
import java.math.RoundingMode;

class Taxes {

    static BigDecimal calculateTax(String value) {
        BigDecimal income = new BigDecimal(value);
        BigDecimal output;

        final BigDecimal personalAllowance = new BigDecimal(556.02);
        final BigDecimal threshold = new BigDecimal(85527);

        if (income.compareTo(threshold) > 0) {
            output = new BigDecimal(14839.02);
            output = output.add(new BigDecimal(0.32).multiply(income.subtract(threshold)));
            return output.setScale(0, RoundingMode.HALF_UP);
        } else {
            output = new BigDecimal(0.18).multiply(income).subtract(personalAllowance);
            if (output.compareTo(new BigDecimal(0)) < 0) {
                return new BigDecimal(0);
            } else {
                return output.setScale(0, RoundingMode.HALF_UP);
            }
        }
    }
}
