package pl.wsb.ecommerce;
import java.util.ArrayList;

class ThreeForTwoPromotion implements Promotion {
    @Override
    public String getPromoCode() {
        return "BUY3PAY2";
    }
    
    @Override
    public double calculateDiscountedPrice(ArrayList<CartItem> items) {
        ArrayList<Double> productPrices = new ArrayList<Double>();
        
        // Zbierz wszystkie ceny produktów
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            for (int j = 0; j < item.getQuantity(); j++) {
                productPrices.add(item.getProduct().getPrice());
            }
        }
        
        // BUBBLE SORT od najdroższych do najtańszych
        for (int i = 0; i < productPrices.size() - 1; i++) {
            for (int j = 0; j < productPrices.size() - 1 - i; j++) {
                if (productPrices.get(j) < productPrices.get(j + 1)) {
                    Double temp = productPrices.get(j);
                    productPrices.set(j, productPrices.get(j + 1));
                    productPrices.set(j + 1, temp);
                }
            }
        }
        
        // Ile razy trzeba zastosować promocje (ile jest grup po 3 produktów)
        int numberOfDiscounts = productPrices.size() / 3;
        
        double totalPrice = 0;
        for (int i = 0; i < productPrices.size(); i++) {
            // Jeśli iterujemy już po numberOfDiscounts najtanszych przedmiotach, to są one po 1 zł
            if (i >= productPrices.size() - numberOfDiscounts) {
                totalPrice += 1.0;
            } else {
                totalPrice += productPrices.get(i);  // Full price
            }
        }
        
        return totalPrice;
    }
    
    @Override
    public String getDescription() {
        return "Przy zakupie 3 produktów najtańszy za 1 zł";
    }
}