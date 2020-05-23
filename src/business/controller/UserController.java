package business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business.exception.ValidationException;
import business.interfaces.UserInterface;
import dataAccess.DataAccess;
import dataAccess.DataAccessFacade;
import model.User;

public class UserController implements UserInterface {
	private DataAccess da = new DataAccessFacade();
	private HashMap<String, User> usersMap;

	public UserController() {
		usersMap = da.readUserMap();
	}

	@Override
	public List<String> allUserEmails() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readUserMap().keySet());
		return retval;
	}

	@Override
	public User getUser(String userEmail) {
		return usersMap.get(userEmail);
	}

	@Override
	public HashMap<String, User> getUsersMap() {
		return usersMap;
	}

	@Override
	public void addUser(String userEmail, String firstName, String lastName, String telephone, String street,
			String city, String state, String zip) {
		model.Address address = new model.Address(street, city, state, zip);
		User user = new User(userEmail, firstName, lastName, telephone, address);
		da.saveNewUser(user);
		usersMap = da.readUserMap();
	}

	@Override
	public void validateAddUserForm(String userEmail, String firstName, String lastName, String telephone,
			String street, String city, String state, String zip) throws ValidationException {

		if (this.usersMap.containsKey(userEmail)) {
			throw new ValidationException("User email already exists!");
		}

		if (userEmail.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || telephone.isEmpty() || street.isEmpty()
				|| city.isEmpty() || state.isEmpty() || zip.isEmpty()) {
			throw new ValidationException("All fields are required!");
		}
	}

	@Override
	public void validateUpdateUserForm(String userEmail, String firstName, String lastName, String telephone,
			String street, String city, String state, String zip) throws ValidationException {

		if (!this.usersMap.containsKey(userEmail)) {
			throw new ValidationException(" User Email does not exists in database!");
		}

		if (userEmail.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || telephone.isEmpty() || street.isEmpty()
				|| city.isEmpty() || state.isEmpty() || zip.isEmpty()) {
			throw new ValidationException("All fields are required!");
		}

	}

	@Override
	public String generateUserEmail() {
		int rand = this.usersMap.size() + 1;
		return "USER-" + rand;
	}

}
