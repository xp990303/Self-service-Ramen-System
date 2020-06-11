package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Available;
import seventeen.group.Service.AvailableService;
import seventeen.group.Service.Impl.AvailableServiceImpl;

import java.io.IOException;

/**
 * @className: AvailableServiceTest
 * @author: Group 17
 * @date: 2020/5/22
 * @description: The type Available service test.
 */
public class AvailableServiceTest {

    private AvailableService availableService = new AvailableServiceImpl();

    /**
     * Test get available msg.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testGetAvailableMsg() throws IOException {
        Available myAvailable = availableService.getAvailableMsg();
        System.out.println(myAvailable.getJudgeCode());
    }

    /**
     * Test change state.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testChangeState() throws IOException {
        Available myAvailable = new Available();
        myAvailable.setNori("nori");
        availableService.changeState(myAvailable,"nori","false");
        System.out.println(myAvailable.getJudgeCode());
    }

    /**
     * Test search state.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testSearchState() throws IOException {
        Available myAvailable = new Available();
        availableService.searchState(myAvailable, "nori");
        System.out.println(myAvailable.getNori());
    }
}
