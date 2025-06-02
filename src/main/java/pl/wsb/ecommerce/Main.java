package pl.wsb.ecommerce;
import java.util.Scanner;

// NOWA GŁÓWNA KLASA Z INTERAKTYWNYM MENU
public class Main {
    private Catalog catalog;
    private ShoppingCart cart;
    private Scanner scanner;
    
    public Main() {
        this.catalog = new Catalog();  // Produkty dodawane automatycznie w konstruktorze
        // Jeśli chcielibyśmy rozbudować funkcjonalność aplikacji o np. dodawanie nowych produktów do koszyka przez administratora
        // to wtedy można dopisać tutaj wczytywanie produktów z pliku tekstowego
        // iterowanie po każdej linii i tworzenie nowych produktów
        // wczytywanie produktów z pliku tekstowego można zrobić w osobnej metodzie w klasie Catalog
        // np. loadProductsFromFile(String filename)
        

        this.cart = new ShoppingCart();
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        System.out.println("=== WITAMY W SKLEPIE ONLINE ===");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    catalog.displayAllProducts();
                    break;
                case 2:
                    displayProductsByCategory();
                    break;
                case 3:
                    addProductToCart();
                    break;
                case 4:
                    removeProductFromCart();
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    applyPromotion();
                    break;
                case 7:
                    cart.displayAvailablePromotions();
                    break;
                case 0:
                    running = false;
                    System.out.println("Dziękujemy za zakupy!");
                    break;
                case -999:  // Handle quit
                    running = false;
                    System.out.println("Dziękujemy za zakupy!");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór!");
            }
            
            if (running) {
                System.out.println("\nNaciśnij Enter aby kontynuować...");
                scanner.nextLine();
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n=== MENU GŁÓWNE ===");
        System.out.println("1. Wyświetl wszystkie produkty");
        System.out.println("2. Wyświetl produkty według kategorii");
        System.out.println("3. Dodaj produkt do koszyka");
        System.out.println("4. Usuń produkt z koszyka");
        System.out.println("5. Wyświetl koszyk");
        System.out.println("6. Zastosuj promocję");
        System.out.println("7. Wyświetl dostępne promocje");
        System.out.println("0. Zakończ");
        System.out.print("Wybierz opcję: ");
    }
    
    private int getChoice() {
    try {
        String input = scanner.nextLine();
        
        // Check if user wants to quit
        if (input.equalsIgnoreCase("q")) {
            return -999;  // Special value for quit
        }
        
        // Otherwise try to parse as integer
        int choice = Integer.parseInt(input);
        return choice;
        } catch (NumberFormatException e) {
        return -1;  // Invalid input
        }
    }
    
    private void displayProductsByCategory() {
        System.out.println("Dostępne kategorie:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println("- " + categories[i]);
        }
        
        System.out.print("Wprowadź nazwę kategorii: ");
        String categoryName = scanner.nextLine().toUpperCase();
        
        try {
            Category category = Category.valueOf(categoryName);
            catalog.displayProductsByCategory(category);
        } catch (IllegalArgumentException e) {
            System.out.println("Nieprawidłowa kategoria!");
        }
    }
    
    private void addProductToCart() {
        System.out.print("Wprowadź nazwę produktu: ");
        String productName = scanner.nextLine();
        
        // Najpierw sprawdź czy produkt w ogóle istnieje
        Product product = catalog.findProductAny(productName);
        if (product == null) {
            System.out.println("Nie znaleziono produktu: " + productName);
        } else if (!product.isAvailable()) {
            System.out.println("Produkt " + productName + " nie jest dostępny!");
        } else {
            cart.addProduct(product);
        }
    }
    
    private void removeProductFromCart() {
        if (cart.isEmpty()) {
            System.out.println("Koszyk jest pusty!");
            return;
        }
        
        cart.displayCart();
        System.out.print("Wprowadź nazwę produktu do usunięcia: ");
        String productName = scanner.nextLine();
        cart.removeProduct(productName);
    }
    
    private void applyPromotion() {
        if (cart.isEmpty()) {
            System.out.println("Koszyk jest pusty! Dodaj produkty przed zastosowaniem promocji.");
            return;
        }
        
        cart.displayAvailablePromotions();
        System.out.print("Wprowadź kod rabatowy: ");
        String code = scanner.nextLine();
        cart.applyPromotion(code);
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}