package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Statistics;
import seventeen.group.Service.Impl.BillServiceImpl;
import seventeen.group.Service.BillService;

import java.io.IOException;

/**
 * @className: BillServiceTest
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Bill service test.
 */
public class BillServiceTest {

    private BillService BillService = new BillServiceImpl();
    private Bill Bill = new Bill();

    /**
     * Test chk bill msg.
     */
    @Test
    public void testChkBillMsg() {
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
        if(BillService.chkBillMsg(Bill)==1){
            System.out.println("Right!");
        }else{
            System.out.println("Error!");
        }
        System.out.println(Bill.getSoup() + "/r/n");
        System.out.println(Bill.getNood() + "/r/n");
        System.out.println(Bill.getOnion() + "/r/n");
        System.out.println(Bill.getNori() + "/r/n");
        System.out.println(Bill.getChashu() + "/r/n");
        System.out.println(Bill.getBoiledEgg() + "/r/n");
    }

    /**
     * Test set bill msg.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSetBillMsg() throws IOException {
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
        System.out.println(myBill.getDate() + "/r/n");
        System.out.println(myBill.getPrice() + "/r/n");
    }

    /**
     * Test get bill msg.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testGetBillMsg() throws IOException {
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
        System.out.println(BillService.getBillMsg(myBill));

    }

    /**
     * Test get self most.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testGetSelfMost() throws IOException {
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
        BillService.saveBillMsg(myBill);
        Statistics myStatistic = BillService.getStatistic();
        System.out.println(BillService.getSelfMost(myStatistic,"Soup").getName() + ' ' + BillService.getSelfMost(myStatistic,"Soup").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Noodles").getName() + ' ' + BillService.getSelfMost(myStatistic,"Noodles").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Spring onion").getName() + ' ' + BillService.getSelfMost(myStatistic,"Spring Onion").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Nori").getName() + ' ' + BillService.getSelfMost(myStatistic,"Nori").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Chashu").getName() + ' ' + BillService.getSelfMost(myStatistic,"Chashu").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Boiled egg").getName() + ' ' + BillService.getSelfMost(myStatistic,"Boiled egg").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Spiciness").getName() + ' ' + BillService.getSelfMost(myStatistic,"Spiciness").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Extra Nori").getName() + ' ' + BillService.getSelfMost(myStatistic,"Extra Nori").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Extra boiled egg").getName() + ' ' + BillService.getSelfMost(myStatistic,"Extra boiled egg").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Bamboo shoots").getName() + ' ' + BillService.getSelfMost(myStatistic,"Bamboo shoots").getValue());
        System.out.println(BillService.getSelfMost(myStatistic,"Extra Chashu").getName() + ' ' + BillService.getSelfMost(myStatistic,"Extra Chashu").getValue());
    }

    /**
     * Test save bill msg.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSaveBillMsg() throws IOException {
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
        System.out.println(BillService.saveBillMsg(myBill));
    }

    /**
     * Test get statistic.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testGetStatistic() throws IOException {
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
        BillService.saveBillMsg(myBill);
        Statistics myStatistic = BillService.getStatistic();
        System.out.println(myStatistic.getSoupShio() + "/r/n");
        System.out.println(myStatistic.getNoodleMedium() + "/r/n");
        System.out.println(myStatistic.getOnionNo() + "/r/n");
        System.out.println(myStatistic.getNoriY() + "/r/n");
        System.out.println(myStatistic.getChashuY() + "/r/n");
        System.out.println(myStatistic.getBoiledEggY() + "/r/n");
        System.out.println(myStatistic.getSpiciness2() + "/r/n");
        System.out.println(myStatistic.getExtraNoriN() + "/r/n");
        System.out.println(myStatistic.getExtraBoiledEggN() + "/r/n");
        System.out.println(myStatistic.getBambooShootsN() + "/r/n");
        System.out.println(myStatistic.getExtraChashuN() + "/r/n");
        System.out.println(myStatistic.getIfFreeN() + "/r/n");
        System.out.println(myStatistic.getPayOption() + "/r/n");
        System.out.println(myStatistic.getPacketEatIn() + "/r/n");
    }
}
