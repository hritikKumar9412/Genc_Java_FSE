import java.util.Arrays;
import java.util.Comparator;

public class eCommerce {

    public static void main(String[] args) {

        EProduct[] products = {
                new EProduct(101, "Laptop", "Electronics"),
                new EProduct(102, "Mobile", "Electronics"),
                new EProduct(103, "Shoes", "Fashion"),
                new EProduct(104, "Watch", "Accessories"),
                new EProduct(105, "Bag", "Fashion")
        };

        System.out.println(" Linear Search --->");
        EProduct result1 = linearSearch(products, "Shoes");

        if (result1 != null)
            System.out.println("Product Found: " + result1);
        else
            System.out.println("Product Not Found");

        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        System.out.println("\n Binary Search --->");
        EProduct result2 = binarySearch(products, "Watch");

        if (result2 != null)
            System.out.println("Product Found: " + result2);
        else
            System.out.println("Product Not Found");
    }

    public static EProduct linearSearch(EProduct[] products, String name) {

        for (EProduct product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    public static EProduct binarySearch(EProduct[] products, String name) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison =
                    products[mid].productName.compareToIgnoreCase(name);

            if (comparison == 0)
                return products[mid];
            else if (comparison < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}

class EProduct {

    int productId;
    String productName;
    String category;

    public EProduct(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Product Name: " + productName +
                ", Category: " + category;
    }
}