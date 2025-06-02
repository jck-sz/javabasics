// Promotion.java - INTERFEJS
package pl.wsb.ecommerce;
import java.util.ArrayList;

interface Promotion {
    String getPromoCode();
    double calculateDiscountedPrice(ArrayList<CartItem> items);
    String getDescription();
}

