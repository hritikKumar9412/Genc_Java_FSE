public class Logger {

    // Private static instance of Logger
    private static Logger instance;

    // Private constructor
    private Logger() {
        System.out.println("Logger Instance Created");
    }

    // Public static method to get the single instance
    public static Logger getInstance() {
        // Create object only if it does not exist
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}