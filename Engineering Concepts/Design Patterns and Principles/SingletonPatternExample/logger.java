package SingletonPatternExample;

public class logger {


        // Private static instance of Logger
        private static logger instance;

        // Private constructor
        private logger() {
            System.out.println("Logger Instance Created");
        }

        // Public static method to get the single instance
        public static logger getInstance() {

            // Create object only if it does not exist
            if (instance == null) {
                instance = new logger();
            }

            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("LOG: " + message);
        }

}
