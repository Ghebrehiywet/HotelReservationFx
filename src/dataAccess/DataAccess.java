package dataAccess;

import java.util.HashMap;
import java.util.List;

import model.User;

public interface DataAccess {
	HashMap<String, Admin> readAdminMap();

	HashMap<String, User> readUserMap();

	void saveNewUser(User user);

	// void loadUserMap(List<User> userList);

//	HashMap<String, LibraryMember> readMemberMap();
//

}
