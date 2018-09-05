package test.com.robert.millar.hebDemo.Dao; 

import com.robert.millar.hebDemo.Dao.InventoryDao;
import com.robert.millar.hebDemo.model.Inventory;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import java.util.List;

import static org.junit.Assert.assertTrue;

/** 
* InventoryDao Tester. 
* 
* @author Robert Millar
* @since <pre>Sep 2, 2018</pre> 
* @version 1.0 
*/ 
public class InventoryDaoTest {
    @Before
    public void before() throws Exception {
        //TODO clear test tables and insert test data
    }

    @After
    public void after() throws Exception {
        //TODO clean up database by deleting test data inserted
    }

    /**
     * Method: getInventory()
     */
    @Test
    public void testGetInventory() throws Exception {
        InventoryDao inventory = new InventoryDao();
        List<Inventory> inventoryList = inventory.getInventory();

        assertTrue(inventoryList.size() == 20);

    }

    /**
     * Method: getInventory(String value)
     */
    @Test
    public void testGetInventoryValue() throws Exception {
        InventoryDao inventory = new InventoryDao();
        List<Inventory> inventoryList1 = inventory.getInventory("Grocery");
        List<Inventory> inventoryList2 = inventory.getInventory("Produce");

        assertTrue(inventoryList1.size() == 8);
        assertTrue(inventoryList1.get(0).getDepartment().equals("Grocery"));
        assertTrue(inventoryList2.size() != inventoryList1.size());
        assertTrue(inventoryList2.get(0).getDepartment().equals("Produce"));

    }
}