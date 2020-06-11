package seventeen.group.Service.Impl;

import seventeen.group.Dao.Impl.PriceDaoImpl;
import seventeen.group.Entity.Price;
import seventeen.group.Service.PriceService;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @className: PriceServiceImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Price service.
 */
public class PriceServiceImpl implements PriceService {

    private PriceDaoImpl priceDao = new PriceDaoImpl();

    public void chgPriceData(Price price) {
        // Set the data format as A.BC to each price.
        DecimalFormat df = new DecimalFormat("0.00");
        String num;
        num = df.format(price.getRamen());
        price.setRamen(Double.parseDouble(num));

        num = df.format(price.getExNori());
        price.setExNori(Double.parseDouble(num));

        num = df.format(price.getExEgg());
        price.setExEgg(Double.parseDouble(num));

        num = df.format(price.getExBamboo());
        price.setExBamboo(Double.parseDouble(num));

        num = df.format(price.getExChashu());
        price.setExChashu(Double.parseDouble(num));
        return;
    }

    public Double chkPriceData(String price) {
        // Check whether the price obtain the format
        if(price.matches("^^\\d+(\\.\\d+)?$")) {
            return Double.parseDouble(price);
        } else {
            return -1.00;
        }
    }

    public int setPrice(Price price) throws IOException {
        // Get the message from Dao.
        return priceDao.setPrice(price);
    }

    public Price getPrice() throws IOException {
        // Get the message from Dao.
        return priceDao.getPrice();
    }

    public String searchPrice(Price price, String name) throws IOException {
        // Get the message from Dao.
        return priceDao.searchPrice(price, name);
    }

    public Price changePrice(Price price, String name, double change) throws IOException {
        // Get the message from Dao.
        return priceDao.changePrice(price, name, change);
    }
}
