package pl.wsb.ecommerce;

import org.junit.Test;
import static org.junit.Assert.*;


public class CartItemTest {
Product product = new Product("Test produkt", 10.0, Category.INNE);
    
@Test
    public void testGetTotalPrice() {
        CartItem cartItem = new CartItem(product, 3);
        assertEquals(30.0, cartItem.getTotalPrice(), 0.0001);
    }

    @Test
    public void testToString() {
        CartItem cartItem = new CartItem(product, 2);
        assertEquals("Test produkt, 2 szt. (20.0 zł)", cartItem.toString());
    }

}
