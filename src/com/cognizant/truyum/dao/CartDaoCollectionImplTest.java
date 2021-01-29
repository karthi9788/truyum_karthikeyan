package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 4);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		System.out.println(menuItemList);
	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemList = null;
		try {
			menuItemList = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 4);
		List<MenuItem> updatedmenuItem = null;
		try {
			updatedmenuItem = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(updatedmenuItem);

	}

}
