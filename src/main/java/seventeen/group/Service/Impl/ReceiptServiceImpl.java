package seventeen.group.Service.Impl;

import seventeen.group.Dao.Impl.ReceiptDaoImpl;
import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;
import seventeen.group.Service.ReceiptService;

/**
 * @className: ReceiptServiceImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Receipt service.
 */
public class ReceiptServiceImpl implements ReceiptService {

    private ReceiptDaoImpl receiptDao = new ReceiptDaoImpl();

    public int setReceipt(Bill bill, Customer customer) throws Exception {
        // Get the message from Dao.
        return receiptDao.setReceipt(bill, customer);
    }
}
