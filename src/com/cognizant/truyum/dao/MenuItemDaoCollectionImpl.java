package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			MenuItem menuItem1 = new MenuItem(1, "Sandwich", 99.0f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true);
			MenuItem menuItem2 = new MenuItem(2, "Burger", 129.0f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false);
			MenuItem menuItem3 = new MenuItem(3, "Pizza", 149.0f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false);
			MenuItem menuItem4 = new MenuItem(4, "French Fries", 57.0f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true);
			MenuItem menuItem5 = new MenuItem(5, "Chocolate Brownie", 32.0f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true);
			menuItemList.add(menuItem1);
			menuItemList.add(menuItem2);
			menuItemList.add(menuItem3);
			menuItemList.add(menuItem4);
			menuItemList.add(menuItem5);
		}

	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemListcus = new ArrayList<MenuItem>();
		Date today = new Date();
		for (MenuItem menuitem : menuItemList) {
			if (menuitem.getDateOfLaunch().getTime() <= today.getTime() && menuitem.isActive()) {
				menuItemListcus.add(menuitem);
			}
		}
		return menuItemListcus;
	}

	// submit
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menu : menuItemList) {
			if (menuItem.getId() == menu.getId()) {

				menu.setName(menuItem.getName());
				menu.setPrice(menuItem.getPrice());
				menu.setDateOfLaunch(menuItem.getDateOfLaunch());
				menu.setFreeDelivery(menuItem.isFreeDelivery());
				menu.setCategory(menuItem.getCategory());
				menu.setActive(menuItem.isActive());

			}
		}
	}

	// edit
	public MenuItem getMenuItem(long menuItemId) {

		for (MenuItem menu : menuItemList) {
			if (menu.getId() == menuItemId) {
				return menu;
			}
		}

		return null;

	}
}
