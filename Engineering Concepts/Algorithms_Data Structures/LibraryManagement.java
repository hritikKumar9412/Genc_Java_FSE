import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {


        public static void main(String[] args) {

            Book[] books = {
                    new Book(101, "Java", "Herbert Schildt"),
                    new Book(102, "Python", "Guido Van Rossum"),
                    new Book(103, "C++", "Bjarne Stroustrup"),
                    new Book(104, "Data Structures", "Mark Allen")
            };

            // Linear Search
            System.out.println("=== Linear Search ===");

            Book result1 = linearSearch(books, "Python");

            if (result1 != null)
                System.out.println("Book Found: " + result1);
            else
                System.out.println("Book Not Found");

            // Sort array before Binary Search
            Arrays.sort(books, Comparator.comparing(b -> b.title));

            System.out.println("\n=== Binary Search ===");

            Book result2 = binarySearch(books, "Java");

            if (result2 != null)
                System.out.println("Book Found: " + result2);
            else
                System.out.println("Book Not Found");
        }

        // Linear Search
        public static Book linearSearch(Book[] books, String title) {

            for (Book book : books) {

                if (book.title.equalsIgnoreCase(title)) {
                    return book;
                }
            }

            return null;
        }

        // Binary Search
        public static Book binarySearch(Book[] books, String title) {

            int low = 0;
            int high = books.length - 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                int compare =
                        books[mid].title.compareToIgnoreCase(title);

                if (compare == 0)
                    return books[mid];

                else if (compare < 0)
                    low = mid + 1;

                else
                    high = mid - 1;
            }

            return null;
        }
}

    class Book {

        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId +
                    ", Title: " + title +
                    ", Author: " + author;
        }
    }
