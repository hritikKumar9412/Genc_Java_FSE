package DependencyInjection;

public class CustomerRepositoryImpl
        implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        // Simulating database access
        return "Customer ID: " + id +
                ", Name: Hritik Kumar";
    }
}