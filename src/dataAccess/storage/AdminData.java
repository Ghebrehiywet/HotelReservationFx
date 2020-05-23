package dataAccess.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dataAccess.Auth;
import dataAccess.DataAccessFacade;
import dataAccess.Admin;

public class AdminData {
	/// create Admins
	public void adminData() {
		DataAccessFacade.loadAdminMap(allAdmins);
	}

	@SuppressWarnings("serial")
	private List<Admin> allAdmins= new ArrayList<Admin>() {
		{
			add(new Admin("001", "123", Auth.ADMINISTRATOR));
			add(new Admin("002", "123", Auth.USER));
			add(new Admin("003", "123", Auth.BOTH));
		}
	};
}
