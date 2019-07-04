import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxesTest {

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"0", new BigDecimal(0)}, {"-1", new BigDecimal(0)}, {"1", new BigDecimal(0)}, {"3091", new BigDecimal(0)}, {"3092", new BigDecimal(1)},
                {"85527", new BigDecimal("14839")}, {"85528", new BigDecimal("14839")}, {"85529", new BigDecimal("14840")}, {"100000", new BigDecimal("19470")}};
    }

    @Test(dataProvider = "getData")
    public void testCalculateTax(String input, BigDecimal output) {

        //Arrange
        //Act
        BigDecimal calculatedTax = Taxes.calculateTax(input);
        //Assert
        assertThat(calculatedTax).isEqualTo(output);
    }
    @Test(expectedExceptions = NumberFormatException.class)
    public void testCalculateTax() {

        //Arrange
        //Act
        BigDecimal calculatedTax = Taxes.calculateTax("a");
        //Assert

    }
}