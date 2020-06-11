package seventeen.group.Dao.Impl;

import seventeen.group.Dao.CustomerDao;
import seventeen.group.Entity.Customer;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: CustomerDaoImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Customer dao.
 */
public class CustomerDaoImpl implements CustomerDao {

    public Customer setCustomerMsg(Customer customer) throws IOException {
        // Get the "customer.txt" file.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                Customer customerWrong = new Customer();
                return customerWrong;
            }
        }
        File file = new File("./file/customer.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                Customer customerWrong = new Customer();
                return customerWrong;
            }
        }
        // Establish the connection and move to the last line.
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String cust;
        String[] custMsg = null;
        while ((cust = bufferedReader.readLine()) != null) {
            custMsg = cust.split(" ");
        }
        // Get the latest uid
        DecimalFormat df = new DecimalFormat("0000");
        String latestnum;
        if (custMsg != null) {
            String latestUid = custMsg[0];
            latestnum = df.format(Integer.parseInt(latestUid.substring(2)) + 1);
        } else {
            latestnum = "0001";
        }
        String uid = customer.getFirname().substring(0, 1) +
                customer.getSurname().substring(0, 1) + latestnum;
        // Set the uid and stamp of the customer
        customer.setUid(uid);
        customer.setStamp(0);
        bufferedReader.close();
        return customer;
    }

    public int saveCustomer(Customer customer) throws IOException {
        // Get the "customer.txt" file.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return 0;
            }
        }
        File file = new File("./file/customer.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                return 0;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String cust;
        String[] custMsg;
        List<String> custList = new ArrayList<>();
        int judgeNumber = 0;
        while ((cust = bufferedReader.readLine()) != null) {
            custMsg = cust.split(" ");
            // Judge whether the uid is in customer.txt.
            if (!custMsg[0].equals(customer.getUid())) {
                custList.add(cust);
            } else {
                // If true, add the new one in the list.
                custList.add(customer.getUid() + " " + customer.getStamp() + " " +
                        customer.getMsgChk() + " " + customer.getFirname() + " " + customer.getSurname() +
                        " " + customer.getMobile() + " " + customer.getEmail());
                judgeNumber = 1;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("");
        bufferedWriter.flush();
        bufferedWriter.close();

        // If the uid doesn't in customer.txt, add it to the last of the file.
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
        for (String custSave : custList) {
            bufferedWriter2.write(custSave + "\r\n");
        }
        if (judgeNumber == 0) {
            bufferedWriter2.write(customer.getUid() + " " + customer.getStamp() + " " +
                    customer.getMsgChk() + " " + customer.getFirname() + " " + customer.getSurname() +
                    " " + customer.getMobile() + " " + customer.getEmail() + "\r\n");
        }
        bufferedWriter2.flush();
        bufferedWriter2.close();
        return 1;
    }

    public Customer getCustMsg(String uid) throws IOException {
        uid = uid.toUpperCase();
        Customer customer = new Customer();
        // Get the "customer.txt" file.
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                // JudgeCode = 110 indicates the file doesn't exist.
                customer.setJudgeCode("110");
                return customer;
            }
        }
        File file = new File("./file/customer.txt");
        if (!file.exists()) {
            // JudgeCode = 110 indicates the file doesn't exist.
            customer.setJudgeCode("110");
            return customer;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String cust;
        String[] custMsg;
        int judgeCode = 0;
        while ((cust = bufferedReader.readLine()) != null) {
            custMsg = cust.split(" ");
            // Judge whether the uid is in the customer.txt.
            if (custMsg[0].equals(uid)) {
                // Set customer from data in customer.txt.
                customer.setUid(custMsg[0]);
                customer.setStamp(Integer.parseInt(custMsg[1]));
                customer.setMsgChk(custMsg[2]);
                customer.setFirname(custMsg[3]);
                customer.setSurname(custMsg[4]);
                if (custMsg.length > 5) customer.setMobile(custMsg[5]);
                if (custMsg.length > 6) customer.setEmail(custMsg[6]);
                customer.setJudgeCode("000");
                judgeCode = 1;
                break;
            }
        }
        if (judgeCode == 0) {
            // JudgeCode = 111 indicates this uid is not in ".txt".
            customer.setJudgeCode("111");
            bufferedReader.close();
            return customer;
        }
        bufferedReader.close();
        return customer;
    }

    public Customer chkExist(Customer customer) throws IOException {
        File dir = new File("./file");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                // JudgeCode = 001 indicates the file doesn't exist.
                customer.setJudgeCode("001");
                return customer;
            }
        }
        File file = new File("./file/customer.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                // JudgeCode = 001 indicates the customer.txt doesn't exist.
                customer.setJudgeCode("001");
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String cust;
        String[] custMsg;
        while ((cust = bufferedReader.readLine()) != null) {
            custMsg = cust.split(" ");
            if (custMsg[5].equals(customer.getEmail()) && custMsg.equals(customer.getEmail())) {
                // JudgeCode = 010 indicates that this E-mail & Mobile is already existed.
                customer.setJudgeCode("010");
                bufferedReader.close();
                return customer;
            } else if (custMsg[5].equals(customer.getMobile())) {
                // JudgeCode = 011 indicates that this E-mail is already existed.
                customer.setJudgeCode("011");
                customer.setUid(custMsg[0]);
                bufferedReader.close();
                return customer;
            } else if (custMsg[6].equals(customer.getEmail())) {
                // JudgeCode = 100 indicates that this Mobile is already existed.
                customer.setJudgeCode("100");
                customer.setUid(custMsg[0]);
                bufferedReader.close();
                return customer;
            }
            // JudgeCode = 000 indicates that this E-mail & Mobile isn't existed.
            //customer.setJudgeCode("000");
        }
        //System.out.println();
        bufferedReader.close();
        customer.setJudgeCode("000");
        return customer;
    }
}
