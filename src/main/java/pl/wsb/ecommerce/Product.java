package pl.wsb.ecommerce;  // 

/* Zaimplementuj klasę reprezentującą Produkt.
a. Produkt zawiera m.in. swoją nazwę, cenę oraz jedną z dostępnych kategorii. -> name, price, category
b. Produkt może być oznaczony jako dostępny lub niedostępny do zakupu -> isAvailable
*/
public class Product {  // 
    private String name;
    private double price;
    private Category category;
    private boolean isAvailable;

    // CONSTRUCTORS //
    public Product(String name, double price, Category category, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.isAvailable = true;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.category = Category.INNE;
        this.isAvailable = true;
    }

    // GETTERS //
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // SETTERS //
    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // DODANY toString() - przydatny do wyświetlania
    @Override
    public String toString() {
        return name + " - " + price + " zł";
    }
}