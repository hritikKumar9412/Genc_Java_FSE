public class EmployeeManagementSystem {

        static Employee[] employees = new Employee[10];
        static int count = 0;


        public static void main(String[] args) {

            // Add Employees
            addEmployee(new Employee(101, "Hritik", "Developer", 50000));
            addEmployee(new Employee(102, "Daksh", "Tester", 40000));
            addEmployee(new Employee(103, "Vaibhav", "Manager", 70000));

            System.out.println("All Employees:");
            traverseEmployees();

            // Search Employee
            System.out.println("\nSearching Employee ID 102:");
            Employee emp = searchEmployee(102);

            if (emp != null)
                System.out.println(emp);
            else
                System.out.println("Employee not found");

            // Delete Employee
            deleteEmployee(102);

            System.out.println("\nAfter Deleting Employee ID 102:");
            traverseEmployees();
        }

        // Add Employee
        public static void addEmployee(Employee employee) {

            if (count < employees.length) {
                employees[count] = employee;
                count++;
                System.out.println("Employee Added Successfully");
            } else {
                System.out.println("Array is Full");
            }
        }

        // Search Employee
        public static Employee searchEmployee(int employeeId) {

            for (int i = 0; i < count; i++) {

                if (employees[i].employeeId == employeeId) {
                    return employees[i];
                }
            }

            return null;
        }

        // Traverse Employees
        public static void traverseEmployees() {

            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }

        // Delete Employee
        public static void deleteEmployee(int employeeId) {

            int index = -1;

            for (int i = 0; i < count; i++) {

                if (employees[i].employeeId == employeeId) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Employee Not Found");
                return;
            }

            // Shift Elements Left
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }

            employees[count - 1] = null;
            count--;

            System.out.println("Employee Deleted Successfully");
        }
    }

    // Employee Class
    class Employee {

        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name,
                        String position, double salary) {

            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {

            return "Employee ID: " + employeeId +
                    ", Name: " + name +
                    ", Position: " + position +
                    ", Salary: " + salary;
        }
    }

