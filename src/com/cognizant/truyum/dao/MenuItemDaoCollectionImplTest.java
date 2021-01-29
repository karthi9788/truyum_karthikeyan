package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {
	
	public static void main(String[] args) {
		testGetMenuItemListAdmin();
	

	}
	static void testGetMenuItemListAdmin() {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
		List <MenuItem> menuItemList =  menuItemDao.getMenuItemListAdmin();
		for(MenuItem val : menuItemList) {
			System.out.println(val.toString());
		}
	}
	

}
