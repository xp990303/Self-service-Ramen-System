package seventeen.group.Dao;

import seventeen.group.Entity.Price;

import java.io.IOException;

/**
 * @className: Price
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Price dao.
 */
public interface PriceDao {

    /**
     * Sets price.
     *
     * @param price the price
     * @return the price
     * @throws IOException the io exception
     */
    int setPrice(Price price) throws IOException;

    /**
     * Gets price.
     *
     * @return the price
     * @throws IOException the io exception
     */
    Price getPrice() throws IOException;

    /**
     * Search price string.
     *
     * @param price the price
     * @param name  the name
     * @return the string
     * @throws IOException the io exception
     */
    String searchPrice(Price price, String name) throws IOException;

    /**
     * Change price price.
     *
     * @param price  the price
     * @param name   the name
     * @param change the change
     * @return the price
     * @throws IOException the io exception
     */
    Price changePrice(Price price, String name, double change) throws IOException;
}
