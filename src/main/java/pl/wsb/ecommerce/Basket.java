package src.main.java.pl.wsb.ecommerce;
import java.util.ArrayList;

/*
Zaprojektuj i zaimplementuj potrzebne klasy dla Koszyka zakupów.
a. Domyślnie Koszyk jest pusty i możliwe jest dodawanie do niego
Produktów. W koszyku może znaleźć się więcej niż jeden ten sam
Produkt.
b. Z Koszyka można usuwać Produkty.
c. Można wyświetlić nazwy wszystkich Produktów znajdujących się
obecnie w Koszyku oraz ich liczbę (np. Cytryna, 2 szt.).
d. Koszyk umożliwia obliczenie oraz wyświetlenie ceny koszyka, czyli
sumy cen wszystkich znajdujących się w nim Produktów.
 */

public class Basket {
    private ArrayList<Product> productList;

    Basket() {
        productList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

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
