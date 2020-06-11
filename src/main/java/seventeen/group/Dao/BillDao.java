package seventeen.group.Dao;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Statistics;

import java.io.IOException;

/**
 * @className: Bill
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Bill dao.
 */
public interface BillDao {

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
