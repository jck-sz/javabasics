// ThreeForTwoPromotion.java - PROMOCJA 3 ZA 2
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
        
        // Zbierz wszystkie ceny produktów (traditional for loop)
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
        
        double totalPrice = 0;
        for (int i = 0; i < productPrices.size(); i++) {
            if ((i + 1) % 3 == 0) {
                // Każdy trzeci produkt (najtańszy w grupie) za 1 zł
                totalPrice += 1.0;
            } else {
                totalPrice += productPrices.get(i);
            }
        }
        
        return totalPrice;
    }
    
    @Override
    public String getDescription() {
        return "Przy zakupie 3 produktów najtańszy za 1 zł";
    }
}