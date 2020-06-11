package seventeen.group.Service;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.MostPopMeal;
import seventeen.group.Entity.Statistics;

import java.io.IOException;

/**
 * @className: Bill
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Bill service.
 */
public interface BillService {

    /**
     * Chk bill msg int.
     *
     * @param bill the bill
     * @return the int
     */
    int chkBillMsg(Bill bill);

    /**
     * Sets bill msg.
     *
     * @param bill the bill
     * @return the bill msg
     * @throws IOException the io exception
     */
    Bill setBillMsg(Bill bill) throws IOException;

    /**
     * Gets bill msg.
     *
     * @param bill the bill
     * @return the bill msg
     */
    String getBillMsg(Bill bill);

    /**
     * Gets self most.
     *
     * @param statistics the statistics
     * @param string     the string
     * @return the self most
     */
    MostPopMeal getSelfMost(Statistics statistics, String string);

    /**
     * Save bill msg int.
     *
     * @param bill the bill
     * @return the int
     * @throws IOException the io exception
     */
    int saveBillMsg(Bill bill) throws IOException;

    /**
     * Gets statistic.
     *
     * @return the statistic
     * @throws IOException the io exception
     */
    Statistics getStatistic() throws IOException;
}
