package seventeen.group.Service;

import seventeen.group.Entity.Customer;

import java.io.IOException;

/**
 * @className: Customer
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Customer service.
 */
public interface CustomerService {

    /**
     * Chk customer customer.
     *
     * @param customer the customer
     * @return the customer
     */
    Customer chkCustomer(Customer customer);

    /**
     * Sets customer msg.
     *
     * @param customer the customer
     * @return the customer msg
     * @throws IOException the io exception
     */
    Customer setCustomerMsg(Customer customer) throws IOException;

    /**
     * Save customer int.
     *
     * @param customer the customer
     * @return the int
     * @throws IOException the io exception
     */
    int saveCustomer(Customer customer) throws IOException;

    /**
     * Gets cust msg.
     *
     * @param uid the uid
     * @return the cust msg
     * @throws IOException the io exception
     */
    Customer getCustMsg(String uid) throws IOException;

    /**
     * Chk exist customer.
     *
     * @param customer the customer
     * @return the customer
     * @throws IOException the io exception
     */
    Customer chkExist(Customer customer) throws IOException;
}
