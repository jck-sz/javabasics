package pl.wsb.ecommerce;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testToString() {
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        assertEquals("Test produkt - 10.0 zł", product.toString());
    }

    @Test
    public void testIsAvailable() {
        Product product = new Product("Test produkt", 10.0, Category.INNE, false);
        assertFalse(product.isAvailable());
    }


}
