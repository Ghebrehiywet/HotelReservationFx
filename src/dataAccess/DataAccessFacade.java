package dataAccess;

import java.util.HashMap;
import java.util.List;

import model.User;

public class DataAccessFacade implements DataAccess {

	// Start ADMIN
	public static void loadAdminMap(List<Admin> admins) {
		HashMap<String, Admin> users = new HashMap<String, Admin>();
		admins.forEach(user -> users.put(user.getId(), user));
		StorageOperation.saveToStorage(StorageType.ADMINISTRATORS, users);
	}

	public HashMap<String, Admin> readAdminMap() {
		// Returns a Map with name/value pairs being
		// userEmail -> User
		return (HashMap<String, Admin>) StorageOperation.readFromStorage(StorageType.ADMINISTRATORS);
	}
	// END ADMIN

	// Start USER
	public static void loadUsersMap(List<User> users) {
		HashMap<String, User> memberUsers = new HashMap<String, User>();
		users.forEach(user -> memberUsers.put(user.getUserEmail(), user));
		StorageOperation.saveToStorage(StorageType.USERS, memberUsers);
	}

	// implement: other save operations
	public void saveNewUser(User user) {
		HashMap<String, User> users = readUserMap();
		String memberId = user.getUserEmail();
		users.put(memberId, user);
		StorageOperation.saveToStorage(StorageType.USERS, users);
	}

	public HashMap<String, User> readUserMap() {
		// Returns a Map with name/value pairs being
		// userEmail -> User
		return (HashMap<String, User>) StorageOperation.readFromStorage(StorageType.USERS);
	}
	// END USER
}
