package seventeen.group.Service;

import seventeen.group.Entity.Available;

import java.io.IOException;

/**
 * @className: Available
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The interface Available service.
 */
public interface AvailableService {

    /**
     * Gets available msg.
     *
     * @return the available msg
     * @throws IOException the io exception
     */
    Available getAvailableMsg() throws IOException;

    /**
     * Sets available.
     *
     * @param available the available
     * @return the available
     * @throws IOException the io exception
     */
    int setAvailable(Available available) throws IOException;

    /**
     * Change state available.
     *
     * @param available the available
     * @param name      the name
     * @param state     the state
     * @return the available
     * @throws IOException the io exception
     */
    Available changeState(Available available, String name, String state) throws IOException;

    /**
     * Search state string.
     *
     * @param available the available
     * @param name      the name
     * @return the string
     * @throws IOException the io exception
     */
    String searchState(Available available, String name) throws IOException;
}
