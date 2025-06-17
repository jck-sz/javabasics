package pl.wsb.ecommerce;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class CatalogTest {
    Catalog catalog = new Catalog();
    
    @Test
    public void testGetAllProducts() {
        ArrayList<Product> allProducts = catalog.getAllProducts();
        assertEquals(13, allProducts.size());
    }
    
    @Test 
    public void testGetProductsByCategoryAvailable() {
        ArrayList<Product> categoryProducts = catalog.getProductsByCategory(Category.INNE);
        assertEquals(3, categoryProducts.size());
    }

    @Test
    public void testGetProductsByCategoryNotAvailable() {
        ArrayList<Product> categoryProducts = catalog.getProductsByCategory(Category.TELEFONY);
        assertEquals(0, categoryProducts.size());
    }
    
    
}