package seventeen.group.Dao.Impl;

import seventeen.group.Dao.PriceDao;
import seventeen.group.Entity.Price;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @className: PriceDaoImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Price dao.
 */
public class PriceDaoImpl implements PriceDao {

    public int setPrice(Price price) throws IOException {
        // Get the "price.txt" file.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return 0;
            }
        }
        File file = new File("./file/price.txt");
        if (!file.exists()) {
            if(!file.createNewFile()) {
                return 0;
            }
        }
        // Write the price with the price Object.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Ramen " + price.getRamen() + "\r\n");
        bufferedWriter.write("Extra_Nori " + price.getExNori() + "\r\n");
        bufferedWriter.write("Extra_Boiled_Egg " + price.getExEgg() + "\r\n");
        bufferedWriter.write("Bamboo_Shoots " + price.getExBamboo() + "\r\n");
        bufferedWriter.write("Extra_Chashu " + price.getExChashu() + "\r\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        return 1;
    }

    public Price getPrice() throws IOException {
        // Get the weekday of today.
        Calendar calendar = Calendar.getInstance();
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        // Get the "price.txt" file.
        Price price = new Price();
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                price.setJudgeCode("01");
                return price;
            }
        }
        File file = new File("./file/price.txt");
        if (!file.exists()) {
            if(!file.createNewFile()) {
                price.setJudgeCode("01");
                return price;
            } else {
                // Create the file with the basic price message.
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("Ramen " + "9.99" + "\r\n");
                bufferedWriter.write("Extra_Nori " + "1.00" + "\r\n");
                bufferedWriter.write("Extra_Boiled_Egg " + "1.00" + "\r\n");
                bufferedWriter.write("Bamboo_Shoots " + "1.00" + "\r\n");
                bufferedWriter.write("Extra_Chashu " + "1.00" + "\r\n");
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String priMsg;
        String[] priArr;
        List<Double> priList = new ArrayList<>();
        while((priMsg = bufferedReader.readLine()) != null) {
            priArr = priMsg.split(" ");
            priList.add(Double.parseDouble(priArr[1]));
        }
        bufferedReader.close();
        if (weekDay == 4) {
            price.setRamen(priList.get(0)/2);
            price.setExNori(priList.get(1)/2);
            price.setExEgg(priList.get(2)/2);
            price.setExBamboo(priList.get(3)/2);
            price.setExChashu(priList.get(4)/2);
            price.setJudgeCode("00");
            price.setChkDiscount(1);
            return price;
        } else {
            price.setRamen(priList.get(0));
            price.setExNori(priList.get(1));
            price.setExEgg(priList.get(2));
            price.setExBamboo(priList.get(3));
            price.setExChashu(priList.get(4));
            price.setJudgeCode("00");
            price.setChkDiscount(0);
            return price;
        }
    }

    public String searchPrice(Price price, String name) throws IOException {
        // Open the directory.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return "File Available cannot found";
            }
        }
        // Open the file.
        File file = new File("./file/price.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                return "File Available cannot found";
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String avail = "";
        List<String> StringList = new ArrayList<>();
        String[] availMsg;
        while ((avail = bufferedReader.readLine()) != null) {
            availMsg = avail.split(" ");
            StringList.add(availMsg[1]);
        }
        bufferedReader.close();
        // Get the price which the GUI need.
        if(name.equals("Extra_Nori")) return StringList.get(1);
        if(name.equals("Extra_Boiled_Egg")) return StringList.get(2);
        if(name.equals("Bamboo_Shoots")) return StringList.get(3);
        if(name.equals("Extra_Chashu")) return StringList.get(4);
        return "";
    }

    public Price changePrice(Price price, String name, double change) throws IOException {
        // Open the directory.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return price;
            }
        }
        // Open the file.
        File file = new File("./file/available.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                price.setJudgeCode("01");
                return price;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String avail = "";
        List<String> StringList = new ArrayList<>();
        String[] availMsg;
        while ((avail = bufferedReader.readLine()) != null) {
            availMsg = avail.split(" ");
            StringList.add(availMsg[1]);
        }
        // Set the price which the GUI need.
        bufferedReader.close();
        if(name.equals("Extra_Nori")) price.setExNori(change);
        if(name.equals("Extra_Boiled_Egg")) price.setExEgg(change);
        if(name.equals("Bamboo_Shoots")) price.setExBamboo(change);
        if(name.equals("Extra_Chashu")) price.setExChashu(change);
        return price;
    }
}
