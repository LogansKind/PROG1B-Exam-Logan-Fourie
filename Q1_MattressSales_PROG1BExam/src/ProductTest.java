import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest {
    // Test data from screenshot
    String[] products = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
    int[][] sales = {
            {25, 18, 20}, //Monarch= 63
            {15, 10, 12},//Barbados= 37
            {18, 15, 20} //Phuket= 53
    };

    @Test
    public void GetTotalProductsSales_WithValidData_ReturnCorrectValue() {
        Product product = new Product(products, sales);
        int expected = 153;
        int actual = product.GetTotalProductsSold();
        assertEquals(expected, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnCorrectValue() {
        Product product = new Product(products, sales);
        double expected = 17.0;
        double actual = product.GetAverageProductSold();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void GetMostPopularProduct_WithValidData_ReturnCorrectValue() {
        Product product = new Product(products, sales);
        String expected = "Cozy Nights Monarch mattress";
        String actual = product.GetMostPopularProduct();
        assertEquals(expected, actual);
    }
}
