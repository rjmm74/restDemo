package com.robert.millar.hebDemo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.robert.millar.hebDemo.Dao.InventoryDao;
import com.robert.millar.hebDemo.model.Inventory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//test route
@RestController
public class InventoryController {
	@RequestMapping("/testInventory")
	public List<Inventory> getTestInventory()
	{
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		inventoryList.add(new Inventory(753542,"banana",new Date(9/5/2017),"4d","Produce",
				2.99 ,"lb",1, 0.44));
		return inventoryList;
	}

	@CrossOrigin(origins = "http://localhost:63343")
	@RequestMapping("/inventory/{param}" )
	public List<Inventory> getInventory(@PathVariable(value = "param") String param) throws SQLException {
		InventoryDao inventory = new InventoryDao();
		return inventory.getInventory(param);
	}

	@CrossOrigin(origins = "http://localhost:63343")
	@RequestMapping("/inventory" )
	public List<Inventory> getInventory( )
	{
		InventoryDao inventory = new InventoryDao();
	List<Inventory> myInventory = inventory.getInventory();
	return myInventory;
	}

	@CrossOrigin(origins = "http://localhost:63343")
	@RequestMapping("/departments" )
	public List<String> getDepartment() throws SQLException {
		InventoryDao inventory = new InventoryDao();
		List<String> list = inventory.getDepartment();
		return list;
	}


}
