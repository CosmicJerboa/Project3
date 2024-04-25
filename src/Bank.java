import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer (Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer (Customer customer) {
        customerList.remove(customer);
    }

    public Customer getCustomer (int pin) {
        Customer foundCustomer = null;
        for (Customer customer : customerList) {
            if(customer.getPin() == pin) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    public List<Customer> getAllCustomers () {
        return customerList;
    }
}
