package seventeen.group.Service.Impl;

import seventeen.group.Dao.CustomerDao;
import seventeen.group.Dao.Impl.CustomerDaoImpl;
import seventeen.group.Entity.Customer;
import seventeen.group.Service.CustomerService;

import java.io.IOException;

/**
 * @className: CustomerServiceImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Customer service.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    public Customer chkCustomer(Customer customer) {
        // Get the message from customer.
        String firname = customer.getFirname().toLowerCase().trim();
        String surname = customer.getSurname().toLowerCase().trim();
        String email = customer.getEmail().trim();
        String mobile = customer.getMobile().trim();
        // Judge whether the input is null.
        if (firname.isEmpty() || surname.isEmpty()) {
            // JudgeCode = 001 indicates that the information is incomplete.
            customer.setJudgeCode("111");
            return customer;
        } else if (email.isEmpty() && mobile.isEmpty()) {
            // JudgeCode = 001 indicates that the information is incomplete.
            customer.setJudgeCode("001");
            return customer;
        }
        // Judge whether the firname is incorrect.
        for (int i = 0; i < firname.length(); i++) {
            char ch = firname.charAt(i);
            if (ch < 'a' || ch > 'z') {
                // JudgeCode = 010 indicates the firname is incorrect.
                customer.setJudgeCode("010");
                return customer;
            }
        }
        // First letter of firname uppercase to adjust format.
        firname = firname.substring(0, 1).toUpperCase() + firname.substring(1);
        // Judge whether the firname is incorrect.
        for (int i = 0; i < surname.length(); i++) {
            char ch = surname.charAt(i);
            if (ch < 'a' || ch > 'z') {
                // JudgeCode = 011 indicates the surname is incorrect.
                customer.setJudgeCode("011");
                return customer;
            }
        }
        // First letter of firname uppercase to adjust format.
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        // Judge whether the E-mail is incorrect.
        if (!email.isEmpty()) {
            int countAt = 0;    // Save the number of '@'
            int indexAt = 0;    // Save the position of '@'
            int indexPoint = 0; // Save the position of '.'
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '@') {
                    countAt++;
                    indexAt = i;
                }
                if (ch == '.') {
                    indexPoint = i;
                }
            }
            int judgeNum1 = 0;
            for (int i = 0; i < indexAt; i++) {
                char ch = email.charAt(i);
                if ('a' <= ch && ch <= 'z') {
                    judgeNum1 = 0;
                } else if ('A' <= ch && ch <= 'Z') {
                    judgeNum1 = 0;
                } else if ('0' <= ch && ch <= '9') {
                    judgeNum1 = 0;
                } else if (ch == '.' && i != 0 && i != indexAt - 1) {
                    judgeNum1 = 0;
                } else {
                    judgeNum1 = 1;
                    break;
                }
            }
            if (judgeNum1 == 1) {
                // JudgeCode = 100 indicates the E-mail is incorrect.
                customer.setJudgeCode("100");
                return customer;
            }
            int judgeNum2 = 0;
            int pointCount = 0;
            for (int i = indexAt + 1; i < email.length(); i++) {
                char ch = email.charAt(i);
                if ('a' <= ch && ch <= 'z') {
                    judgeNum2 = 0;
                } else if ('A' <= ch && ch <= 'Z') {
                    judgeNum2 = 0;
                } else if ('0' <= ch && ch <= '9') {
                    judgeNum2 = 0;
                } else if (ch == '.') {
                    judgeNum2 = 0;
                    pointCount++;
                } else {
                    judgeNum2 = 1;
                    break;
                }
            }
            int judgeNum3 = 0;
            for (int i = indexPoint + 1; i < email.length(); i++) {
                char ch = email.charAt(i);
                if ('a' <= ch && ch <= 'z') {
                    judgeNum3 = 0;
                } else if ('A' <= ch && ch <= 'Z') {
                    judgeNum3 = 0;
                } else {
                    judgeNum3 = 1;
                    break;
                }
            }
            if (judgeNum2 == 1) {
                // JudgeCode = 100 indicates the E-mail is incorrect.
                customer.setJudgeCode("100");
                return customer;
            }
            if (judgeNum3 == 1) {
                // JudgeCode = 100 indicates the E-mail is incorrect.
                customer.setJudgeCode("100");
                return customer;
            }
            if (pointCount != 1) {
                // JudgeCode = 100 indicates the E-mail is incorrect.
                customer.setJudgeCode("100");
                return customer;
            }
            if (countAt != 1 || indexAt >= indexPoint - 1
                    || indexAt == 0 || indexPoint == email.length() - 1) {
                // JudgeCode = 100 indicates the E-mail is incorrect.
                customer.setJudgeCode("100");
                return customer;
            }
        }
        // Judge whether the mobile number is incorrect.
        if (!mobile.isEmpty()) {
            if (mobile.length() > 15) {
                // JudgeCode = 101 indicates the mobile number is incorrect.
                customer.setJudgeCode("101");
                return customer;
            }
            for (int i = 0; i < mobile.length(); i++) {
                char ch = mobile.charAt(i);
                if (ch < '0' || ch > '9') {
                    // JudgeCode = 101 indicates the mobile number is incorrect.
                    customer.setJudgeCode("101");
                    return customer;
                }
            }
        }
        // JudgeCode = 000 indicates the input is correct.
        customer.setJudgeCode("000");
        if (mobile.isEmpty()) {
            customer.setMobile("No-imformation");
        }
        if (email.isEmpty()) {
            customer.setEmail("No-imformation");
        }
        customer.setFirname(firname);
        customer.setSurname(surname);
        return customer;
    }

    public Customer setCustomerMsg(Customer customer) throws IOException {
        // Get the message from Dao.
        return customerDao.setCustomerMsg(customer);
    }

    public int saveCustomer(Customer customer) throws IOException {
        // Get the message from Dao.
        return customerDao.saveCustomer(customer);
    }

    public Customer getCustMsg(String uid) throws IOException {
        // Get the message from Dao.
        return customerDao.getCustMsg(uid);
    }

    public Customer chkExist(Customer customer) throws IOException {
        // Get the message from Dao.
        return customerDao.chkExist(customer);
    }
}
