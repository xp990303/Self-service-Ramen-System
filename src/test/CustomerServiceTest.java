package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Customer;
import seventeen.group.Service.CustomerService;
import seventeen.group.Service.Impl.CustomerServiceImpl;

import java.io.IOException;

/**
 * @className: CustomerServiceTest
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Customer service test.
 */
public class CustomerServiceTest {

    private CustomerService customerService = new CustomerServiceImpl();
    private Customer customer = new Customer();

    /**
     * Test chk customer.
     */
    @Test
    public void testChkCustomer() {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        customerService.chkCustomer(customer);
        System.out.println(customer.getJudgeCode());
    }

    /**
     * Test set customer.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSetCustomer() throws IOException {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        customerService.setCustomerMsg(customer);
        System.out.println(customer.getUid() + "\r\n");
        System.out.println(customer.getStamp() + "\r\n");
    }

    /**
     * Test save customer.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSaveCustomer() throws IOException {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        System.out.println(customerService.saveCustomer(customer));
    }

    /**
     * Test get customer msg.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testGetCustomerMsg() throws IOException {
        Customer myCustomer = new Customer();
        myCustomer = customerService.getCustMsg("JC0001");
        System.out.println(myCustomer.getUid());
    }

    /**
     * Test chk exist.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testChkExist() throws IOException {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        System.out.println(customerService.chkExist(customer));
    }


}
