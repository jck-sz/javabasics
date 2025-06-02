package pl.wsb.ecommerce;
import java.util.HashMap;
import java.util.ArrayList;

/*
Zaprojektuj i zaimplementuj potrzebne klasy dla Koszyka zakupów.
a. Domyślnie Koszyk jest pusty i możliwe jest dodawanie do niego Produktów. W koszyku może znaleźć się więcej niż jeden ten sam Produkt. -> addProduct()
b. Z Koszyka można usuwać Produkty. -> removeProduct()
c. Można wyświetlić nazwy wszystkich Produktów znajdujących się obecnie w Koszyku oraz ich liczbę (np. Cytryna, 2 szt.). -> displayCart()
d. Koszyk umożliwia obliczenie oraz wyświetlenie ceny koszyka, czyli sumy cen wszystkich znajdujących się w nim Produktów. -> calculateTotalPrice()
 */


public class ShoppingCart {
    private HashMap<String, CartItem> items;
    private Promotion activePromotion;
    private HashMap<String, Promotion> availablePromotions;
    
    public ShoppingCart() {
        this.items = new HashMap<String, CartItem>();
        this.availablePromotions = new HashMap<String, Promotion>();
        initializePromotions();
    }
    
    private void initializePromotions() {
        Promotion tenPercent = new TenPercentPromotion();
        Promotion threeForTwo = new ThreeForTwoPromotion();
        Promotion secondHalf = new SecondHalfPricePromotion();
        
        availablePromotions.put(tenPercent.getPromoCode(), tenPercent);
        availablePromotions.put(threeForTwo.getPromoCode(), threeForTwo);
        availablePromotions.put(secondHalf.getPromoCode(), secondHalf);
    }
    
    public void addProduct(Product product) {
        if (!product.isAvailable()) {
            System.out.println("Produkt " + product.getName() + " nie jest dostępny!");
            return;
        }
        
        String key = product.getName();
        if (items.containsKey(key)) {
            CartItem item = items.get(key);
            item.setQuantity(item.getQuantity() + 1);
        } else {
            items.put(key, new CartItem(product, 1));
        }
        System.out.println("Dodano do koszyka: " + product.getName());
    }
    
    public void removeProduct(String productName) {
        if (items.containsKey(productName)) {
            CartItem item = items.get(productName);
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                System.out.println("Usunięto 1 szt. " + productName + " z koszyka");
            } else {
                items.remove(productName);
                System.out.println("Usunięto " + productName + " z koszyka");
            }
        } else {
            System.out.println("Produkt " + productName + " nie znajduje się w koszyku");
        }
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Koszyk jest pusty");
            return;
        }
        
        System.out.println("=== ZAWARTOŚĆ KOSZYKA ===");
        
        // Traditional iteration over HashMap values
        String[] keys = items.keySet().toArray(new String[0]);
        for (int i = 0; i < keys.length; i++) {
            CartItem item = items.get(keys[i]);
            System.out.println(item);
        }
        
        if (activePromotion != null) {
            System.out.println("Aktywna promocja: " + activePromotion.getDescription());
        }
        
        System.out.println("Cena koszyka: " + String.format("%.2f", calculateTotalPrice()) + " zł");
    }
    
    public double calculateTotalPrice() {
        if (items.isEmpty()) {
            return 0;
        }
        
        ArrayList<CartItem> itemList = new ArrayList<CartItem>();
        
        // Traditional iteration to collect values
        String[] keys = items.keySet().toArray(new String[0]);
        for (int i = 0; i < keys.length; i++) {
            itemList.add(items.get(keys[i]));
        }
        
        if (activePromotion != null) {
            return activePromotion.calculateDiscountedPrice(itemList);
        } else {
            double sum = 0;
            for (int i = 0; i < itemList.size(); i++) {
                sum += itemList.get(i).getTotalPrice();
            }
            return sum;
        }
    }
    
    public boolean applyPromotion(String promoCode) {
        if (availablePromotions.containsKey(promoCode)) {
            activePromotion = availablePromotions.get(promoCode);
            System.out.println("Zastosowano promocję: " + activePromotion.getDescription());
            return true;
        } else {
            System.out.println("Nieprawidłowy kod rabatowy: " + promoCode);
            return false;
        }
    }
    
    public void removePromotion() {
        activePromotion = null;
        System.out.println("Usunięto promocję");
    }
    
    public void displayAvailablePromotions() {
        System.out.println("=== DOSTĘPNE PROMOCJE ===");
        
        // Traditional iteration over HashMap values
        String[] promoCodes = availablePromotions.keySet().toArray(new String[0]);
        for (int i = 0; i < promoCodes.length; i++) {
            Promotion p = availablePromotions.get(promoCodes[i]);
            System.out.println(p.getPromoCode() + " - " + p.getDescription());
        }
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public int getUniqueProductCount() {
        return items.size();
    }
    
    public HashMap<String, CartItem> getItems() {
        return new HashMap<String, CartItem>(items);
    }
}