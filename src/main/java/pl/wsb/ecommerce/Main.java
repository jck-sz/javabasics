package src.main.java.pl.wsb.ecommerce;


public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World");
        Catalog catalog = new Catalog();
        generateCatalog(catalog);

        // Tworzenie koszyka i dodawanie do niego produktów - może zrobić na to osobną funkcję?
        Basket basket = new Basket();
        basket.addProduct(catalog.allTheProducts.get(0));
        basket.addProduct(catalog.allTheProducts.get(0));
        basket.addProduct(catalog.allTheProducts.get(0));
        basket.addProduct(catalog.allTheProducts.get(0));
        basket.addProduct(catalog.allTheProducts.get(1));
        basket.addProduct(catalog.allTheProducts.get(2));
        basket.removeProduct(catalog.allTheProducts.get(0));
        basket.displayBasket();
        System.out.println(("Total basket price is: " + basket.calculateTotal() + "PLN"));


    }

    // funkcja do generowania produktów i dodawania ich do katalogu
    public static void generateCatalog(Catalog catalog) {
        catalog.addProduct(new Product("Pasta do zebow", 10.33, Category.ZDROWIE, false));
        catalog.addProduct(new Product("Laptop", 4099.99, Category.LAPTOPY, true));
        catalog.addProduct(new Product("Zmywarka", 255.99, Category.AGD, true));
        catalog.addProduct(new Product("Bulbulator", 99990.99));
        catalog.addProduct(new Product("Samsung Galaxy s48", 5999.99, Category.TELEFONY, false));
        catalog.addProduct(new Product("Apple iPad Pro", 9499.99, Category.TABLETY));
        catalog.addProduct(new Product("Telewizor LG 97M48LA 4K", 130999.99, Category.RTV));
        catalog.addProduct(new Product("Szpadel", 99.99, Category.DOM_I_OGROD, false));
        catalog.addProduct(new Product("Koszula Vistula", 1999.99, Category.MODA));
        catalog.addProduct(new Product("Witamina D3 8000 IU", 49.99, Category.ZDROWIE));
        catalog.addProduct(new Product("Subskrypcja XBOX Game Pass", 99.99, Category.ROZRYWKA));
        catalog.addProduct(new Product("Usługa transportowa", 199.99, Category.INNE));
    }

    


}
