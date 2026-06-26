package SingletonPatternExample;

public class SingeltonTest {

        public static void main(String[] args) {

            // Get first instance
            logger logger1 = logger.getInstance();
            logger1.log("First log message");

            // Get second instance
            logger logger2 = logger.getInstance();
            logger2.log("Second log message");

            // Verify both references point to same object
            if (logger1 == logger2) {
                System.out.println("Both logger instances are the same.");
            } else {
                System.out.println("Different logger instances created.");
            }
        }

}
