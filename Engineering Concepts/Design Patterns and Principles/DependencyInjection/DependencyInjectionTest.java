package DependencyInjection;

public class DependencyInjectionTest {

    public static void main(String[] args) {

        // Create Repository Object
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        // Inject dependency using constructor
        CustomerService service =
                new CustomerService(repository);

        // Use Service
        service.displayCustomer(101);
    }
}