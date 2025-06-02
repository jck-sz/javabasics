// TenPercentPromotion.java - PROMOCJA 10%
package pl.wsb.ecommerce;
import java.util.ArrayList;

class TenPercentPromotion implements Promotion {
    @Override
    public String getPromoCode() {
        return "SAVE10";
    }
    
    @Override
    public double calculateDiscountedPrice(ArrayList<CartItem> items) {
        double basePrice = 0;
        // Iterujemy po każdym itemie w ArrayList i sumujemy cene a nastepnie mnozymy przez 0.9
        for (int i = 0; i < items.size(); i++) {
            basePrice += items.get(i).getTotalPrice();
        }
        return basePrice * 0.9;
    }
    
    @Override
    public String getDescription() {
        return "10% taniej na wszystkie produkty";
    }
}