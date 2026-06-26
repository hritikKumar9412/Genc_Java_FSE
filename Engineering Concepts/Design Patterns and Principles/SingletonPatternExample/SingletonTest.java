package SingletonPatternExample;
public class SingletonTest {

    public static void main(String[] args) {

        // Get first instance
        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");

        // Get second instance
        Logger logger2 = Logger.getInstance();
        logger2.log("User Logged In");

        // Check if both references point to same object
        if (logger1 == logger2) {
            System.out.println("\nOnly one Logger instance exists.");
        } else {
            System.out.println("\nMultiple Logger instances exist.");
        }

        // Print hash codes
        System.out.println("HashCode of logger1: " + logger1.hashCode());
        System.out.println("HashCode of logger2: " + logger2.hashCode());
    }
}