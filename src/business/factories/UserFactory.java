package business.factories;

import business.controller.UserController;
import business.interfaces.UserInterface;

public class UserFactory {
	private static UserInterface controller = new UserController();

	public static UserInterface of() {
		return controller;
	}
}
