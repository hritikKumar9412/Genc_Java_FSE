import java.util.HashMap;

// Product Class
class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display Product Details
    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: ₹" + price;
    }
}

// Inventory Management Class
class InventoryManager {

    // Using HashMap to store products
    private HashMap<Integer, Product> inventory;

    // Constructor
    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product with ID " +
                    product.getProductId() + " already exists.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        }
    }

    // Update Product
    public void updateProduct(int id, int quantity, double price) {

        Product product = inventory.get(id);

        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Search Product
    public void searchProduct(int id) {

        Product product = inventory.get(id);

        if (product != null) {
            System.out.println("Product Found:");
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display All Products
    public void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n----- Inventory -----");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

// Main Class
public class InventoryManagementSystem {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        // Adding Products
        manager.addProduct(new Product(101, "Laptop", 20, 50000));
        manager.addProduct(new Product(102, "Mouse", 100, 500));
        manager.addProduct(new Product(103, "Keyboard", 50, 1500));

        // Display Products
        manager.displayProducts();

        // Search Product
        System.out.println("\nSearching Product with ID 102:");
        manager.searchProduct(102);

        // Update Product
        System.out.println("\nUpdating Product with ID 101:");
        manager.updateProduct(101, 25, 52000);

        // Delete Product
        System.out.println("\nDeleting Product with ID 103:");
        manager.deleteProduct(103);

        // Final Inventory
        System.out.println("\nFinal Inventory:");
        manager.displayProducts();
    }
}