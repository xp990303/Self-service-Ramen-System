package seventeen.group.Service.Impl;

import seventeen.group.Dao.AvailableDao;
import seventeen.group.Dao.Impl.AvailableDaoImpl;
import seventeen.group.Entity.Available;
import seventeen.group.Service.AvailableService;

import java.io.IOException;

/**
 * @className: AvailableServiceImpl
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Available service.
 */
public class AvailableServiceImpl implements AvailableService {

    private AvailableDao availableDao = new AvailableDaoImpl();

    public Available getAvailableMsg() throws IOException {
        // Get the message from Dao.
        return availableDao.getAvailableMsg();
    }

    public int setAvailable(Available available) throws IOException {
        // Get the message from Dao.
        return availableDao.setAvailable(available);
    }

    public Available changeState(Available available, String name, String state) throws IOException {
        // Get the message from Dao.
        return availableDao.changeState(available, name, state);
    }

    public String searchState(Available available, String name) throws IOException {
        // Get the message from Dao.
        return availableDao.searchState(available, name);
    }
}
