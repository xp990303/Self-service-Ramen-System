package seventeen.group.Service;

import seventeen.group.Entity.Price;

import java.io.IOException;

/**
 * @className: Price
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Price service.
 */
public interface PriceService {

    /**
     * Chg price data.
     *
     * @param price the price
     */
    void chgPriceData(Price price);

    /**
     * Chk price data double.
     *
     * @param price the price
     * @return the double
     */
    Double chkPriceData(String price);

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
