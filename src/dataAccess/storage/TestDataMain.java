package dataAccess.storage;

import dataAccess.DataAccess;
import dataAccess.DataAccessFacade;

public class TestDataMain {
	public static void main(String[] args) {
		AdminData adminData = new AdminData();
		adminData.adminData();

		UserData userData = new UserData();
		userData.userData();

		DataAccess da = new DataAccessFacade();
		System.out.println(da.readAdminMap());
		System.out.println(da.readUserMap());
	}
}
