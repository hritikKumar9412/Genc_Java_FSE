package MVCPatternExample;

public class MVCTest {

    public static void main(String[] args) {

        // Create Model
        Student student =
                new Student("Hritik", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller =
                new StudentController(student, view);

        // Display Initial Details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Update Student Details
        controller.setStudentName("Amal");
        controller.setStudentGrade("B+");

        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}