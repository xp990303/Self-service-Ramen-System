package seventeen.group.Dao.Impl;

import seventeen.group.Dao.AvailableDao;
import seventeen.group.Entity.Available;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: AvailableDaoImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Available dao.
 */
public class AvailableDaoImpl implements AvailableDao {

    public Available getAvailableMsg() throws IOException {
        Available available = new Available();
        // Open the directory and check
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                available.setJudgeCode("01");
                return available;
            }
        }
        // Open the file and check
        File file = new File("./file/available.txt");
        if (!file.exists()) {
            // If file cannot be created, return 01.
            if (!file.createNewFile()) {
                available.setJudgeCode("01");
                return available;
            } else {
                // Create a new file and write the basic message to it.
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter2.write("soupTonkotsu " + "true" + "\r\n");
                bufferedWriter2.write("soupShoyu " + "true" + "\r\n");
                bufferedWriter2.write("soupShio " + "true" + "\r\n");
                bufferedWriter2.write("noodleSoft " + "true" + "\r\n");
                bufferedWriter2.write("noodleMedium " + "true" + "\r\n");
                bufferedWriter2.write("noodleFirm " + "true" + "\r\n");
                bufferedWriter2.write("onion " + "true" + "\r\n");
                bufferedWriter2.write("nori " + "true" + "\r\n");
                bufferedWriter2.write("chashu " + "true" + "\r\n");
                bufferedWriter2.write("boiledEgg " + "true" + "\r\n");
                bufferedWriter2.write("spiciness " + "true" + "\r\n");
                bufferedWriter2.write("bambooShoot " + "true" + "\r\n");
                bufferedWriter2.write("extraBoiledEgg " + "true" + "\r\n");
                bufferedWriter2.write("extraChashu " + "true" + "\r\n");
                bufferedWriter2.write("extraNori " + "true" + "\r\n");
                bufferedWriter2.flush();
                bufferedWriter2.close();
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
        if (StringList.size() == 0) {
            available.setJudgeCode("10");
            return available;
        } else {
            // Get the basic message stored in available.txt.
            available.setSoupTonkotsu(StringList.get(0));
            available.setSoupShoyu(StringList.get(1));
            available.setSoupShio(StringList.get(2));
            available.setNoodleSoft(StringList.get(3));
            available.setNoodleMedium(StringList.get(4));
            available.setNoodleFirm(StringList.get(5));
            available.setOnion(StringList.get(6));
            available.setNori(StringList.get(7));
            available.setChashu(StringList.get(8));
            available.setBoiledEgg(StringList.get(9));
            available.setSpiciness(StringList.get(10));
            available.setBambooShoot(StringList.get(11));
            available.setExBoiledEgg(StringList.get(12));
            available.setExChashu(StringList.get(13));
            available.setExNori(StringList.get(14));
            available.setJudgeCode("00");
            return available;
        }
    }

    public int setAvailable(Available available) throws IOException {
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                available.setJudgeCode("01");
                return 0;
            }
        }
        File file = new File("./file/available.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                return 0;
            }
        }
        // Set the message changed by user.
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file));
        bufferedWriter1.write("");
        bufferedWriter1.flush();
        bufferedWriter1.close();
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter2.write("soupTonkotsu " + available.getSoupTonkotsu() + "\r\n");
        bufferedWriter2.write("soupShoyu " + available.getSoupShoyu() + "\r\n");
        bufferedWriter2.write("soupShio " + available.getSoupShio() + "\r\n");
        bufferedWriter2.write("noodleSoft " + available.getNoodleSoft() + "\r\n");
        bufferedWriter2.write("noodleMedium " + available.getNoodleMedium() + "\r\n");
        bufferedWriter2.write("noodleFirm " + available.getNoodleFirm() + "\r\n");
        bufferedWriter2.write("onion " + available.getOnion() + "\r\n");
        bufferedWriter2.write("nori " + available.getNori() + "\r\n");
        bufferedWriter2.write("chashu " + available.getChashu() + "\r\n");
        bufferedWriter2.write("boiledEgg " + available.getBoiledEgg() + "\r\n");
        bufferedWriter2.write("spiciness " + available.getSpiciness() + "\r\n");
        bufferedWriter2.write("bambooShoot " + available.getBambooShoot() + "\r\n");
        bufferedWriter2.write("extraBoiledEgg " + available.getExBoiledEgg() + "\r\n");
        bufferedWriter2.write("extraChashu " + available.getExChashu() + "\r\n");
        bufferedWriter2.write("extraNori " + available.getExNori() + "\r\n");
        bufferedWriter2.flush();
        bufferedWriter2.close();
        return 1;
    }

    public Available changeState(Available available, String name, String state) throws IOException {
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                available.setJudgeCode("01");
                return available;
            }
        }
        File file = new File("./file/available.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                available.setJudgeCode("01");
                return available;
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
        if(name.equals("soupTonkotsu")) available.setSoupTonkotsu(state);
        if(name.equals("soupShoyu")) available.setSoupShoyu(state);
        if(name.equals("soupShio")) available.setSoupShio(state);
        if(name.equals("noodleSoft")) available.setNoodleSoft(state);
        if(name.equals("noodleMedium")) available.setNoodleMedium(state);
        if(name.equals("noodleFirm")) available.setNoodleFirm(state);
        if(name.equals("onion")) available.setOnion(state);
        if(name.equals("nori")) available.setNori(state);
        if(name.equals("chashu")) available.setChashu(state);
        if(name.equals("boiledEgg")) available.setBoiledEgg(state);
        if(name.equals("spiciness")) available.setSpiciness(state);
        if(name.equals("Bamboo_Shoots")) available.setBambooShoot(state);
        if(name.equals("Extra_Boiled_Egg")) available.setExBoiledEgg(state);
        if(name.equals("Extra_Chashu")) available.setExChashu(state);
        if(name.equals("Extra_Nori")) available.setExNori(state);
        available.setJudgeCode("00");
        return available;
    }

    public String searchState(Available available, String name) throws IOException {
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                available.setJudgeCode("01");
                return "File Available cannot found";
            }
        }
        File file = new File("./file/available.txt");
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
        if(name.equals("soupTonkotsu")) return StringList.get(0);
        if(name.equals("soupShoyu")) return StringList.get(1);
        if(name.equals("soupShio")) return StringList.get(2);
        if(name.equals("noodleSoft")) return StringList.get(3);
        if(name.equals("noodleMedium")) return StringList.get(4);
        if(name.equals("noodleFirm")) return StringList.get(5);
        if(name.equals("onion")) return StringList.get(6);
        if(name.equals("nori")) return StringList.get(7);
        if(name.equals("chashu")) return StringList.get(8);
        if(name.equals("boiledEgg")) return StringList.get(9);
        if(name.equals("spiciness")) return StringList.get(10);
        if(name.equals("Bamboo_Shoots")) return StringList.get(11);
        if(name.equals("Extra_Boiled_Egg")) return StringList.get(12);
        if(name.equals("Extra_Chashu")) return StringList.get(13);
        if(name.equals("Extra_Nori")) return StringList.get(14);
        return "";
    }
}