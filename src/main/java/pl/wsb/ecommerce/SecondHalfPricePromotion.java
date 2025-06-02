// SecondHalfPricePromotion.java - PROMOCJA 2 ZA 1.5
package pl.wsb.ecommerce;
import java.util.ArrayList;

class SecondHalfPricePromotion implements Promotion {
    @Override
    public String getPromoCode() {
        return "HALF2ND";
    }
    
    @Override
    public double calculateDiscountedPrice(ArrayList<CartItem> items) {
        double totalPrice = 0;
        
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            int quantity = item.getQuantity();
            double unitPrice = item.getProduct().getPrice();
            
            
            int pairs = quantity / 2; // Obliczamy liczbę par produktów
            int remaining = quantity % 2; // Obliczamy liczbę produktów, które nie tworzą pełnej pary - są w pełnej cenie
            
            // Pary produktów: pierwszy pełna cena, drugi połowa ceny i mnożymy przez ilość par
            totalPrice += pairs * (unitPrice + (unitPrice * 0.5));
            // Pozostałe produkty pełna cena
            totalPrice += remaining * unitPrice;
        }
        
        return totalPrice;
    }
    
    @Override
    public String getDescription() {
        return "Przy zakupie 2 takich samych produktów, drugi za połowę ceny";
    }
}