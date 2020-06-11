package seventeen.group.Service;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;

/**
 * @className: Receipt
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Receipt service.
 */
public interface ReceiptService {

    /**
     * Sets receipt.
     *
     * @param bill     the bill
     * @param customer the customer
     * @return the receipt
     * @throws Exception the exception
     */
    int setReceipt(Bill bill, Customer customer) throws Exception;
}
