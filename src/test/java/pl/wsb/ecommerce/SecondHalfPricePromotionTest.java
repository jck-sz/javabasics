package pl.wsb.ecommerce;
import org.junit.Test;
import static org.junit.Assert.*;

public class SecondHalfPricePromotionTest {
    @Test
    public void testCalculateDiscountedPrice() {
        SecondHalfPricePromotion promotion = new SecondHalfPricePromotion();
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromotion(promotion.getPromoCode());
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(15.0, cart.calculateTotalPrice(), 0.0001);
    }

    @Test
    public void testCalculateDiscountedPriceWithThreeProducts() {
        SecondHalfPricePromotion promotion = new SecondHalfPricePromotion();
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromotion(promotion.getPromoCode());
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(25.0, cart.calculateTotalPrice(), 0.0001);
    }
}