package com.example.myfirstproject.service;

import com.example.myfirstproject.dao.CustomerDAO;
import com.example.myfirstproject.exception.CustomerNotFoundException;
import com.example.myfirstproject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> customerOptional = customerDAO.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("There is no Customer with this ID...");
        }

        return customerDAO.findById(customerId).get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId); //if the id is there it updates the object
                                            //else it will add it to the database
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){

        customerDAO.deleteById(customerId);
    }
}
