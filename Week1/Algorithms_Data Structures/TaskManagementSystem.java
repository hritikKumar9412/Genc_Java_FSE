public class TaskManagementSystem {


        Node head = null;

        // Add Task
        public void addTask(int taskId,
                            String taskName,
                            String status) {

            Node newNode = new Node(taskId, taskName, status);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;

                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = newNode;
            }

            System.out.println("Task Added Successfully");
        }

        // Search Task
        public void searchTask(int taskId) {

            Node temp = head;

            while (temp != null) {

                if (temp.taskId == taskId) {
                    System.out.println("Task Found");
                    System.out.println(temp);
                    return;
                }

                temp = temp.next;
            }

            System.out.println("Task Not Found");
        }

        // Traverse Tasks
        public void displayTasks() {

            if (head == null) {
                System.out.println("No Tasks Available");
                return;
            }

            Node temp = head;

            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        // Delete Task
        public void deleteTask(int taskId) {

            if (head == null) {
                System.out.println("List is Empty");
                return;
            }

            // Delete first node
            if (head.taskId == taskId) {
                head = head.next;
                System.out.println("Task Deleted Successfully");
                return;
            }

            Node temp = head;

            while (temp.next != null &&
                    temp.next.taskId != taskId) {

                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Task Not Found");
            } else {
                temp.next = temp.next.next;
                System.out.println("Task Deleted Successfully");
            }
        }

        public static void main(String[] args) {

            TaskManagementSystem taskList =
                    new TaskManagementSystem();

            taskList.addTask(101,
                    "Complete Assignment",
                    "Pending");

            taskList.addTask(102,
                    "Prepare Presentation",
                    "In Progress");

            taskList.addTask(103,
                    "Submit Report",
                    "Completed");

            System.out.println("\nAll Tasks:");
            taskList.displayTasks();

            System.out.println("\nSearching Task 102:");
            taskList.searchTask(102);

            System.out.println("\nDeleting Task 102:");
            taskList.deleteTask(102);

            System.out.println("\nTasks After Deletion:");
            taskList.displayTasks();
        }
    }

    // Node Class
    class Node {

        int taskId;
        String taskName;
        String status;

        Node next;

        public Node(int taskId,
                    String taskName,
                    String status) {

            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        @Override
        public String toString() {

            return "Task ID: " + taskId +
                    ", Task Name: " + taskName +
                    ", Status: " + status;
        }
}

