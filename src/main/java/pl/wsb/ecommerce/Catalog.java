package src.main.java.pl.wsb.ecommerce;
import java.util.ArrayList;

/*
 Zaprojektuj i zaimplementuj potrzebne klasy do obsługi Katalogu produktów.
 a. Katalog zawiera wszystkie Produkty możliwe do kupienia w Sklepie.
 b. Podczas uruchomienia aplikacji Katalog uzupełniany jest z góry
 zdefiniowanymi Produktami.
 c. Katalog umożliwia na pobranie i wyświetlenie nazw oraz cen
 wszystkich Produktów w Katalogu sortując je alfabetycznie.
 d. Katalog umożliwia na pobranie i wyświetlenie nazw oraz cen
 wszystkich Produktów o podanej Kategorii sortując je od najtańszych
 do najdroższych. Ponadto odfiltrowane są te Produkty, które są
 oznaczone jako niedostępne do zakupu.
*/


public class Catalog {
    ArrayList<Product> allTheProducts;

    Catalog() {
        allTheProducts = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        allTheProducts.add(product);
    }

    public void removeProduct(Product product) {
        allTheProducts.remove(product);
    }

    // Metoda do wyświetlania wszystkich produktów w katalogu posortowanych po nazwie rosnąco
    public void displayAllProductListSortedByName() {
        allTheProducts.sort((arg1, arg2) -> arg1.getName().compareTo(arg2.getName()));
        for (Product product : allTheProducts) {
            System.out.println(product.getName() + " - " + product.getPrice() + " PLN");
        }
    }

    // Metoda do wyświetlania produktów dostępnych w katalogu posortowanych po cenie rosnąco
    public void displayAvailableProductListSortedByPrice() {
        allTheProducts.sort((arg1, arg2) -> Double.compare(arg1.getPrice(), arg2.getPrice()));
        for (Product product : allTheProducts) {
            if (!product.isAvailable()) {
                continue;
            }
            System.out.println(product.getName() + " - " + product.getPrice() + " PLN");
        }
    }

    // Metoda do wyświetlania produktów dostępnych w katalogu posortowanych po cenie malejąco
    public void displayAvailableProductListSortedByPriceDescending() {
        allTheProducts.sort((arg1, arg2) -> Double.compare(arg2.getPrice(), arg1.getPrice()));
        for (Product product : allTheProducts) {
            if (!product.isAvailable()) {
                continue;
            }
            System.out.println(product.getName() + " - " + product.getPrice() + " PLN");
        }
    }
}
