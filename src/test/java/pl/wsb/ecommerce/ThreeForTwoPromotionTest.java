package pl.wsb.ecommerce;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThreeForTwoPromotionTest {
    @Test
    public void testCalculateDiscountedPrice() {
        ThreeForTwoPromotion promotion = new ThreeForTwoPromotion();
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromotion(promotion.getPromoCode());
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(21.0, cart.calculateTotalPrice(), 0.0001);
    }

    @Test
    public void testCalculateDiscountedPriceWithFourProducts() {
        ThreeForTwoPromotion promotion = new ThreeForTwoPromotion();
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromotion(promotion.getPromoCode());
        Product product = new Product("Test produkt", 10.0, Category.INNE);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.addProduct(product);
        cart.addProduct(product);
        assertEquals(31.0, cart.calculateTotalPrice(), 0.0001);
    }
}
