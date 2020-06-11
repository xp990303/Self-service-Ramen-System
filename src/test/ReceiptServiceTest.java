package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;

import seventeen.group.Service.BillService;
import seventeen.group.Service.Impl.BillServiceImpl;
import seventeen.group.Service.ReceiptService;
import seventeen.group.Service.Impl.ReceiptServiceImpl;

/**
 * @className: ReceiptServiceTest
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Receipt service test.
 */
public class ReceiptServiceTest {

    private BillService BillService = new BillServiceImpl();
    private ReceiptService ReceiptService = new ReceiptServiceImpl();
    private Bill Bill = new Bill();
    private Customer customer = new Customer();

    /**
     * Test set.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSet() throws Exception{
        Bill.setSoup("Shio");
        Bill.setNood("Medium");
        Bill.setOnion("No-please");
        Bill.setNori("Yes");
        Bill.setChashu("Yes");
        Bill.setBoiledEgg("Yes");
        Bill.setSpiciness("2");
        Bill.setExtraNori("No");
        Bill.setExtraEgg("No");
        Bill.setBambooShoot("No");
        Bill.setExtraChashu("No");
        Bill.setIfFree("No");
        Bill.setPayoption("cash");
        Bill.setPacket("Eat-in");
        Bill myBill = BillService.setBillMsg(Bill);
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        System.out.println(ReceiptService.setReceipt(myBill,customer));
    }
}
