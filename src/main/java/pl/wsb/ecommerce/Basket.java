package src.main.java.pl.wsb.ecommerce;
import java.util.ArrayList;
/*
Zaprojektuj i zaimplementuj potrzebne klasy dla Koszyka zakupów.
a. Domyślnie Koszyk jest pusty i możliwe jest dodawanie do niego
Produktów. W koszyku może znaleźć się więcej niż jeden ten sam
Produkt. -- zrobione
b. Z Koszyka można usuwać Produkty. -- zrobione
c. Można wyświetlić nazwy wszystkich Produktów znajdujących się
obecnie w Koszyku oraz ich liczbę (np. Cytryna, 2 szt.). -- zrobione
d. Koszyk umożliwia obliczenie oraz wyświetlenie ceny koszyka, czyli
sumy cen wszystkich znajdujących się w nim Produktów. -- zrobione
*/

public class Basket {
    private ArrayList<Product> productList;

    // CONSTRUCTORS //
    Basket() {
        productList = new ArrayList<Product>();
    }

    // METHODS //
    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    // Podliczanie wartości całego koszyka
    public double calculateTotal() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return Math.round(total * 100.00) / 100.00;
    }

    // Metoda do wyświetlania produktów w koszyku plus liczenie ilości każdego z nich
    public void displayBasket() {
        ArrayList<String> productNames = new ArrayList<String>();
        ArrayList<Integer> productQuantities = new ArrayList<Integer>();
        for (Product product : productList) {
            if (!productNames.contains(product.getName())) {
                productNames.add(product.getName());
                productQuantities.add(1);
            } else {
                int index = productNames.indexOf(product.getName());
                productQuantities.set(index, productQuantities.get(index) + 1);
            }
        }
        for (int i = 0; i < productNames.size(); i++) {
            System.out.println(productNames.get(i) + " - " + productQuantities.get(i) + " szt.");
        }
    }
}
