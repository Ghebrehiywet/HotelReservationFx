package dataAccess.storage;

import java.util.ArrayList;
import java.util.List;

import dataAccess.DataAccessFacade;
import model.Address;
import model.User;

public class UserData {
	// create user members
	public void userData() {
		User user = new User("test@test.com", "Andy", "Rogers", "641-223-2211", addresses.get(4));
		users.add(user);

		user = new User("1002@test.com", "Drew", "Stevens", "702-998-2414", addresses.get(5));
		users.add(user);

		user = new User("1003@test.com", "Sarah", "Eagleton", "451-234-8811", addresses.get(6));
		users.add(user);

		user = new User("1004@test.com", "Ricardo", "Montalbahn", "641-472-2871", addresses.get(7));
		users.add(user);

		DataAccessFacade.loadUsersMap(users);
	}

	///////////// DATA //////////////
	List<User> users = new ArrayList<>();
	@SuppressWarnings("serial")
	private List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};
}
