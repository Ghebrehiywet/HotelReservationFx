package business.interfaces;

import java.util.HashMap;
import java.util.List;

import business.exception.ValidationException;
import model.User;

public interface UserInterface {
	List<String> allUserEmails();

	User getUser(String userEmail);

	HashMap<String, User> getUsersMap();

	void addUser(String userEmail, String firstName, String lastName, String telephone, String street, String city,
			String state, String zip);

//	void updateUsersMap();

	void validateAddUserForm(String userEmail, String firstName, String lastName, String telephone, String street,
			String city, String state, String zip) throws ValidationException;

	void validateUpdateUserForm(String userEmail, String firstName, String lastName, String telephone, String street,
			String city, String state, String zip) throws ValidationException;

	String generateUserEmail();
}