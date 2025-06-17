package pl.wsb.ecommerce;
import org.junit.Test;
import static org.junit.Assert.*;

public class TenPercentPromotionTest {
    @Test
    public void testCalculateDiscountedPrice() {
        TenPercentPromotion promotion = new TenPercentPromotion();
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromotion(promotion.getPromoCode());
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(18.0, cart.calculateTotalPrice(), 0.0001);
    }

    @Test
    public void testCalculateDiscountedPriceWithThreeProducts() {
        TenPercentPromotion promotion = new TenPercentPromotion();
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromotion(promotion.getPromoCode());
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(27.0, cart.calculateTotalPrice(), 0.0001);
    }
}
