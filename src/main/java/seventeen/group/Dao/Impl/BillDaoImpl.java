package seventeen.group.Dao.Impl;

import seventeen.group.Dao.BillDao;
import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Statistics;
import seventeen.group.Service.Impl.BillServiceImpl;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @className: BillDaoImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Bill dao.
 */
public class BillDaoImpl implements BillDao {

    public int saveBillMsg(Bill bill) throws IOException {
        // Get the "bill.txt" file.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return 0;
            }
        }
        File file = new File("./file/bill.txt" );
        if (!file.exists()) {
            if(!file.createNewFile()) {
                return 0;
            }
        }
        // Write the bill message.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
        String billMessage = bill.getDate()+" " + bill.getUid() + " "
                +bill.getSoup()+" "+bill.getNood()+" "+bill.getOnion() +" "
                +bill.getNori()+" "+bill.getChashu()+" "+bill.getBoiledEgg() +" "
                +bill.getSpiciness() +" "+bill.getExtraNori()+" "+bill.getExtraEgg()+" "
                +bill.getBambooShoot()+" "+bill.getExtraChashu() +" "+bill.getIfFree()
                +" "+bill.getPrice()+" "+bill.getPayoption() + " "+bill.getPacket()+"\r\n";
        bufferedWriter.write(billMessage);
        bufferedWriter.flush();
        bufferedWriter.close();
        return 1;
    }

    public Statistics getStatistic() throws IOException {
        Statistics statistic = new Statistics();
        int totalBill = 0;
        int soupTonkotsu = 0; int soupShoyu = 0; int soupShio = 0;int noodleSoft = 0; int noodleMedium = 0;
        int noodleFirm = 0;int onionNo = 0; int onionLittle = 0; int onionLot = 0;int noriY = 0; int noriN = 0;int chashuY = 0;
        int chashuN = 0;int boiledEggY = 0; int boiledEggN = 0;int spiciness0 = 0; int spiciness1 = 0; int spiciness2 = 0;
        int spiciness3 = 0; int spiciness4 = 0;int spiciness5 = 0;
        int extraNoriY = 0,extraNoriN = 0,extraBoiledEggY = 0, extraBoiledEggN = 0,
                bambooShootsY = 0,bambooShootsN = 0,extraChashuY = 0, extraChashuN = 0,
                ifFreeY = 0,ifFreeN = 0, payOption = 0,checkNum = 0;
        int packetEatIn = 0; int packetTakeAway = 0;
        double totalPrice = 0.0;
        //
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                statistic.setJudgeCode("01");
                return statistic;
            }
        }
        File file = new File("./file/bill.txt" );
        if (!file.exists()) {
            if(!file.createNewFile()) {
                statistic.setJudgeCode("01");
                return statistic;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String[] billMsg;
        while ((line = bufferedReader.readLine()) != null) {
            billMsg = line.split(" ");

            //read the bill in a week.
            SimpleDateFormat b= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            Date d1 = new Date();
            try{
                d1= b.parse(billMsg[0]);
            }catch(Exception e){
                System.out.println(e);
            }
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, - 7);
            Date d2 = c.getTime();
            if(d1.before(d2)){
                continue;
            }

            totalBill += 1;
            checkNum = 0;
            switch (billMsg[2]) {
                case "Tonkotsu":
                    soupTonkotsu += 1;
                    break;
                case "Shoyu":
                    soupShoyu += 1;
                    break;
                case "Shio":
                    soupShio += 1;
                    break;
                default:
                    checkNum += 1;
                    break;
            }

            switch (billMsg[3]) {
                case "Soft":
                    noodleSoft += 1;
                    break;
                case "Medium":
                    noodleMedium += 1;
                    break;
                case "Firm":
                    noodleFirm += 1;
                    break;
                default:
                    checkNum += 1;
                    break;
            }

            switch (billMsg[4]) {
                case "No-Please":
                    onionNo += 1;
                    break;
                case "Just-a-little":
                    onionLittle += 1;
                    break;
                case "A-lot!":
                    onionLot += 1;
                    break;
                default:
                    checkNum += 1;
                    break;
            }

            if (billMsg[5].equals("Yes")) {
                noriY += 1;
            } else if (billMsg[5].equals("No")) {
                noriN += 1;
            } else {
                checkNum += 1;
            }

            if (billMsg[6].equals("Yes")) {
                chashuY += 1;
            } else if (billMsg[6].equals("No")) {
                chashuN += 1;
            } else {
                checkNum += 1;
            }

            if (billMsg[7].equals("Yes")) {
                boiledEggY += 1;
            } else if (billMsg[7].equals("No")) {
                boiledEggN += 1;
            }
            else{
                checkNum += 1;
            }

            switch (billMsg[8]) {
                case "0":
                    spiciness0 += 1;
                    break;
                case "1":
                    spiciness1 += 1;
                    break;
                case "2":
                    spiciness2 += 1;
                    break;
                case "3":
                    spiciness3 += 1;
                    break;
                case "4":
                    spiciness4 += 1;
                    break;
                case "5":
                    spiciness5 += 1;
                    break;
                default:
                    checkNum += 1;
                    break;
            }

            if (billMsg[9].equals("Yes")) {
                extraNoriY += 1;
            } else if (billMsg[9].equals("No")) {
                extraNoriN += 1;
            } else{
                checkNum += 1;
            }

            if (billMsg[10].equals("Yes")) {
                extraBoiledEggY += 1;
            } else if (billMsg[10].equals("No")) {
                extraBoiledEggN += 1;}
            else {
                checkNum += 1;
            }

            if (billMsg[11].equals("Yes")) {
                bambooShootsY += 1;
            } else if (billMsg[11].equals("No")) {
                bambooShootsN += 1;
            } else {
                checkNum += 1;
            }

            if (billMsg[12].equals("Yes")) {
                extraChashuY += 1;
            } else if (billMsg[12].equals("No")){
                extraChashuN += 1;
            } else {
                checkNum += 1;
            }

            if (billMsg[13].equals("Yes")) {
                ifFreeY += 1;
            } else if (billMsg[13].equals("No")) {
                ifFreeN += 1;
            } else {
                checkNum += 1;
            }
            totalPrice += Double.parseDouble(billMsg[14]);
            if (billMsg[15].equals("cash")) {
                payOption += 1;
            } else {
                payOption += 0;
            }
            if (billMsg[16].equals("Eat-in")){
                packetEatIn += 1;
            }else if(billMsg[16].equals("Take-away")){
                packetTakeAway += 1;
            }
        }
        bufferedReader.close();
        DecimalFormat df = new DecimalFormat("0.00");
        String num;
        num = df.format(totalPrice);

        statistic.setTotalBill(totalBill);
        statistic.setSoupTonkotsu(soupTonkotsu);
        statistic.setSoupShoyu(soupShoyu);
        statistic.setSoupShio(soupShio);
        statistic.setNoodleSoft(noodleSoft);
        statistic.setNoodleMedium(noodleMedium);
        statistic.setNoodleFirm(noodleFirm);
        statistic.setOnionNo(onionNo);
        statistic.setOnionLittle(onionLittle);
        statistic.setOnionLot(onionLot);
        statistic.setNoriY(noriY);
        statistic.setNoriN(noriN);
        statistic.setChashuY(chashuY);
        statistic.setChashuN(chashuN);
        statistic.setBoiledEggY(boiledEggY);
        statistic.setBoiledEggN(boiledEggN);
        statistic.setSpiciness0(spiciness0);
        statistic.setSpiciness1(spiciness1);
        statistic.setSpiciness2(spiciness2);
        statistic.setSpiciness3(spiciness3);
        statistic.setSpiciness4(spiciness4);
        statistic.setSpiciness5(spiciness5);
        statistic.setExtraNoriY(extraNoriY);
        statistic.setExtraNoriN(extraNoriN);
        statistic.setExtraChashuY(extraChashuY);
        statistic.setExtraChashuN(extraChashuN);
        statistic.setBambooShootsY(bambooShootsY);
        statistic.setBambooShootsN(bambooShootsN);
        statistic.setExtraBoiledEggY(extraBoiledEggY);
        statistic.setExtraBoiledEggN(extraBoiledEggN);
        statistic.setIfFreeY(ifFreeY);
        statistic.setIfFreeN(ifFreeN);
        statistic.setTotalPrice(Double.parseDouble(num));
        statistic.setPayOption(payOption);
        statistic.setPacketEatIn(packetEatIn);
        statistic.setPacketTakeAway(packetTakeAway);
        statistic.setCheckNum(checkNum);
        return statistic;
    }

}
