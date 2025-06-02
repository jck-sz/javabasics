package pl.wsb.ecommerce;
import java.util.ArrayList;

/*Zaprojektuj i zaimplementuj potrzebne klasy do obsługi Katalogu produktów.
a. Katalog zawiera wszystkie Produkty możliwe do kupienia w Sklepie.
b. Podczas uruchomienia aplikacji Katalog uzupełniany jest z góry zdefi niowanymi Produktami. -> initializeCatalog()
c. Katalog umożliwia na pobranie i wyświetlenie nazw oraz cen wszystkich Produktów w Katalogu sortując je alfabetycznie. -> displayAllProducts()
d. Katalog umożliwia na pobranie i wyświetlenie nazw oraz cen wszystkich Produktów o podanej Kategorii sortując je od najtańszych do najdroższych. -> displayProductsByCategory()
Ponadto odfiltrowane są te Produkty, które są oznaczone jako niedostępne do zakupu. -> displayProductsByCategory() plus komentarz */

public class Catalog {
    private ArrayList<Product> allTheProducts;  

    // CONSTRUCTOR //
    public Catalog() {
        allTheProducts = new ArrayList<Product>();
        initializeCatalog();  // PRODUKTY DODAWANE W KONSTRUKTORZE
    }

    // PRZENIESIONA INICJALIZACJA Z Main.java
    private void initializeCatalog() {
        allTheProducts.add(new Product("Pasta do zebow", 10.33, Category.ZDROWIE, false));
        allTheProducts.add(new Product("Laptop", 4099.99, Category.LAPTOPY, true));
        allTheProducts.add(new Product("Zmywarka", 255.99, Category.AGD, true));
        allTheProducts.add(new Product("Bulbulator", 99990.99));
        allTheProducts.add(new Product("Samsung Galaxy s48", 5999.99, Category.TELEFONY, false));
        allTheProducts.add(new Product("Apple iPad Pro", 9499.99, Category.TABLETY));
        allTheProducts.add(new Product("Telewizor LG 97M48LA 4K", 130999.99, Category.RTV));
        allTheProducts.add(new Product("Szpadel", 99.99, Category.DOM_I_OGROD, false));
        allTheProducts.add(new Product("Koszula Vistula", 1999.99, Category.MODA));
        allTheProducts.add(new Product("Witamina D3 8000 IU", 49.99, Category.ZDROWIE));
        allTheProducts.add(new Product("Subskrypcja XBOX Game Pass", 99.99, Category.ROZRYWKA));
        allTheProducts.add(new Product("Usługa transportowa", 199.99, Category.INNE));
    }

    // METHODS //
    public void addProduct(Product product) {
        allTheProducts.add(product);
    }

    public void removeProduct(Product product) {
        allTheProducts.remove(product);
    }

    // Wszystkie produkty sortowane alfabetycznie (BUBBLE SORT)
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> sorted = new ArrayList<Product>();
        
        // Kopiowanie wszystkich produktów
        for (int i = 0; i < allTheProducts.size(); i++) {
            sorted.add(allTheProducts.get(i));
        }
        
        // BUBBLE SORT alfabetycznie
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - 1 - i; j++) {
                if (sorted.get(j).getName().compareTo(sorted.get(j + 1).getName()) > 0) {
                    Product temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        
        return sorted;
    }

    public void displayAllProducts() {
        System.out.println("=== WSZYSTKIE PRODUKTY (alfabetycznie) ===");
        ArrayList<Product> all = getAllProducts();
        for (int i = 0; i < all.size(); i++) {
            Product p = all.get(i);
            String status;
            // Jeśli w ogóle nie chcemy wyświetlać produktów niedostępnych, to wtedy:
            // nie potrzebna zmienna status i należy zmienić kod na:
            // if (!p.isAvailable()) { continue; }
            // else { System.out.println(p);}
            // 
            if (p.isAvailable()) { status = "(dostępny)";}
            else { status = "(niedostępny)";}
            System.out.println(p + " " + status);
        }
    }

    // NOWA: Produkty według kategorii sortowane po cenie (BUBBLE SORT)
    public ArrayList<Product> getProductsByCategory(Category category) {
        ArrayList<Product> categoryProducts = new ArrayList<Product>();
        
        // Znajdowanie produktów z danej kategorii (tylko dostępne) - traditional for loop
        for (int i = 0; i < allTheProducts.size(); i++) {
            Product p = allTheProducts.get(i);
            if (p.getCategory() == category && p.isAvailable()) {
                categoryProducts.add(p);
            }
        }
        
        // BUBBLE SORT według ceny (od najtańszych)
        for (int i = 0; i < categoryProducts.size() - 1; i++) {
            for (int j = 0; j < categoryProducts.size() - 1 - i; j++) {
                if (categoryProducts.get(j).getPrice() > categoryProducts.get(j + 1).getPrice()) {
                    Product temp = categoryProducts.get(j);
                    categoryProducts.set(j, categoryProducts.get(j + 1));
                    categoryProducts.set(j + 1, temp);
                }
            }
        }
        
        return categoryProducts;
    }

    public void displayProductsByCategory(Category category) {
        System.out.println("=== PRODUKTY Z KATEGORII: " + category + " (od najtańszych) ===");
        ArrayList<Product> categoryProducts = getProductsByCategory(category);
        for (int i = 0; i < categoryProducts.size(); i++) {
            System.out.println(categoryProducts.get(i));
        }
        if (categoryProducts.isEmpty()) {
            System.out.println("Brak dostępnych produktów w tej kategorii.");
        }
    }

    // POMOCNICZA: Znajdowanie produktu po nazwie (tylko dostępne)
    public Product findProduct(String name) {
        for (int i = 0; i < allTheProducts.size(); i++) {
            Product p = allTheProducts.get(i);
            if (p.getName().equalsIgnoreCase(name) && p.isAvailable()) {
                return p;
            }
        }
        return null;
    }
    
    // NOWA: Sprawdzanie czy produkt istnieje (niezależnie od dostępności)
    public Product findProductAny(String name) {
        for (int i = 0; i < allTheProducts.size(); i++) {
            Product p = allTheProducts.get(i);
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}