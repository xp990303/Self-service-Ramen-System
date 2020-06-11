package seventeen.group.Dao.Impl;

import seventeen.group.Dao.ReceiptDao;
import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @className: ReceiptDaoImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Receipt dao.
 */
public class ReceiptDaoImpl implements ReceiptDao {

    public int setReceipt(Bill bill, Customer customer) throws Exception {
        // Check whether the customer is temporary
        // If true, create and add basic message
        if (customer.getFirname().equals("null") && customer.getSurname().equals("null")) {
            customer.setSurname("Customer");
            customer.setFirname("Temporary");
            customer.setUid("XX0000");
        }
        // Create string to save the basic message
        String filename = bill.getDate() + " " + customer.getFirname() + " " +customer.getSurname();
        filename = filename.substring(0,13) + filename.substring(14,16) + filename.substring(17);
        File dir = new File("./file/receipts");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return 0;
            }
        }
        File file = new File("./file/receipts/" + filename + ".txt");
        if (file.exists())
            return 0;
        else if (!file.createNewFile())
            return 0;
        // Save the basic message in the file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("User: " + customer.getFirname() + " " + customer.getSurname() + "\r\n");
        bufferedWriter.write("User id: " + customer.getUid() + "\r\n");
        bufferedWriter.write("Date: " + bill.getDate() + "\r\n");
        bufferedWriter.write("Soup: " + bill.getSoup() + "\r\n");
        bufferedWriter.write("Noodle: " + bill.getNood() + "\r\n");
        bufferedWriter.write("Nori: " + bill.getNori() + "\r\n");
        bufferedWriter.write("Chashu: " + bill.getChashu() + "\r\n");
        bufferedWriter.write("BoiledEgg: " + bill.getBoiledEgg() + "\r\n");
        bufferedWriter.write("Spiciness: " + bill.getSpiciness() + "\r\n");
        bufferedWriter.write("Extra Nori: " + bill.getExtraNori() + "\r\n");
        bufferedWriter.write("Extra BoiledEgg:" + bill.getExtraEgg() + "\r\n");
        bufferedWriter.write("BambooShoot: " + bill.getBambooShoot() + "\r\n");
        bufferedWriter.write("Extra Chashu: " + bill.getExtraChashu() + "\r\n");
        bufferedWriter.write("Total Price: " + bill.getPrice() + "\r\n");
        bufferedWriter.write("If Free: " + bill.getIfFree() + "\r\n");
        bufferedWriter.write("Pay Option: " + bill.getPayoption() + "\r\n");
        bufferedWriter.write("Packet: " + bill.getPacket() + "\r\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        return 1;
    }
}