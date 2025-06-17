package pl.wsb.ecommerce;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {
    @Test
    public void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        assertEquals(1, cart.getUniqueProductCount());
    }

    @Test
    public void testAddProductTwice() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(1, cart.getUniqueProductCount());
    }

    @Test
    public void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.removeProduct("Test produkt");
        assertEquals(0, cart.getUniqueProductCount());
    }

    @Test
    public void testRemoveProductTwice() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.removeProduct("Test produkt");
        cart.removeProduct("Test produkt");
        assertEquals(0, cart.getUniqueProductCount());
    }

    @Test
    public void testCalculateTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(20.0, cart.calculateTotalPrice(), 0.0001);
    }

    @Test
    public void testCalculateTotalPriceWithPromotion() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.applyPromotion("SAVE10");
        assertEquals(18.0, cart.calculateTotalPrice(), 0.0001);
    }



}
