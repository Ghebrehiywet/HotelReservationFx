package application;

import java.util.HashMap;

import business.exception.ValidationException;
import business.factories.UserFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class AddUserWindow extends Stage implements LibWindow {
	public static final AddUserWindow INSTANCE = new AddUserWindow();
	private HashMap<String, User> usersMap;
	private TableView<User> tbv;
	private TextField txtFirstname;
	private TextField txtLastname;
	private TextField txtTelephone;
	private TextField txtEmail;
	private TextField txtStreet;
	private TextField txtCity;
	private ComboBox<String> txtState;
	private TextField txtZip;
	private boolean isInitialized = false;
	private Button editbtn;
	private Button subimtbtn;
	private Button cancelBtn;
	private TextField userEmail;
	private Text noUserText = new Text();

	public boolean isInitialized() {
		return isInitialized;
	}

	@Override
	public void setInitialized(boolean val) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		GridPane mainGrid = new GridPane();
		GridPane grid = new GridPane();

		grid.setAlignment(Pos.TOP_LEFT);
		mainGrid.setHgap(10);
		mainGrid.setVgap(10);

		grid.setHgap(10);
		grid.setVgap(10);
		userEmail = new TextField();

		String searchInfo = "Search User by email";
		this.noUserText.setText(searchInfo);
		userEmail.textProperty().addListener((observable, oldValue, newValue) -> {
			if (tbv != null) {
				tbv.getItems().clear();
				userEmail.setText(newValue);

				this.usersMap.forEach((r, v) -> {
					if (v.getUserEmail().contains(userEmail.getText().trim().toUpperCase())) {
						this.userEmail.setText(newValue.trim().toUpperCase());
						// tbv.getItems().clear();
						String s = "User exists with " + newValue.trim().toUpperCase();
						this.noUserText.setText(s);
						if (!v.equals(null)) {
							tbv.getItems().add(v);
						}
					}
				});
			}
			if (newValue.isEmpty()) {
				this.noUserText.setText(searchInfo);
				refreshUserList();
			}
		});

		HBox hboxTop = new HBox(10);
		hboxTop.getChildren().add(userEmail);
		hboxTop.getChildren().add(noUserText);

		mainGrid.add(hboxTop, 1, 0);
		mainGrid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
		Text scenetitle = new Text("Add User Form");
		scenetitle.setFont(Font.font("optima", FontWeight.NORMAL, 30));
		mainGrid.add(scenetitle, 0, 0);

		Button back = new Button("Back");
//		back.setDisable(true);
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// TODO:
//				HomePage.hideAllWindows();
//				HomePage.showAdminWindow();
			}
		});
		grid.add(back, 0, 0);

		Label firstName = new Label("First Name:");
		firstName.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label lastName = new Label("Last Name:");
		lastName.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label phoneNumber = new Label("Phone Number:");
		phoneNumber.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label email = new Label("Email:");
		email.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label address = new Label("Address");
		address.setFont(Font.font("Gotham", FontWeight.NORMAL, 17));
		Label street = new Label("Street:");
		street.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label city = new Label("City:");
		city.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label state = new Label("State:");
		state.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		Label zip = new Label("Zip:");
		zip.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		grid.add(firstName, 0, 1);
		grid.add(lastName, 0, 2);
		grid.add(phoneNumber, 0, 3);
		grid.add(email, 0, 4);
		grid.add(address, 0, 5);
		grid.add(street, 0, 6);
		grid.add(city, 0, 7);
		grid.add(state, 0, 8);
		grid.add(zip, 0, 9);

		txtFirstname = new TextField();
		txtFirstname.setPromptText("Enter First Name");
		txtFirstname.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtFirstname.setPrefWidth(300.0);
		txtFirstname.setPrefHeight(40.0);

		txtLastname = new TextField();
		txtLastname.setPromptText("Enter Last Name");
		txtLastname.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtLastname.setPrefWidth(300.0);
		txtLastname.setPrefHeight(40.0);

		txtTelephone = new TextField();
		txtTelephone.setPromptText("Enter Phone Name");
		txtTelephone.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtTelephone.setPrefWidth(300.0);
		txtTelephone.setPrefHeight(40.0);

		txtEmail = new TextField();
		txtEmail.setPromptText("Enter Email");
		txtEmail.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtEmail.setPrefWidth(300.0);
		txtEmail.setPrefHeight(40.0);

		txtStreet = new TextField();
		txtStreet.setPromptText("Enter Street Name");
		txtStreet.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtStreet.setPrefWidth(300.0);
		txtStreet.setPrefHeight(40.0);

		txtCity = new TextField();
		txtCity.setPromptText("Enter City");
		txtCity.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtCity.setPrefWidth(300.0);
		txtCity.setPrefHeight(40.0);

		txtState = new ComboBox<String>();
		txtState.getItems().addAll("Iowa", "NewYork", "Washington", "Ohaio", "Illinois", "Colorado", "California",
				"Illinois", "Texas", "Florida");
		txtState.setPromptText("Select State");
		txtState.setPrefWidth(300.0);
		txtState.setPrefHeight(40.0);

		txtZip = new TextField();
		txtZip.setPromptText("Enter Zip Code");
		txtZip.setFont(Font.font("Gotham", FontWeight.NORMAL, 15));
		txtZip.setPrefWidth(300.0);
		txtZip.setPrefHeight(40.0);

		grid.add(txtFirstname, 1, 1);
		grid.add(txtLastname, 1, 2);
		grid.add(txtTelephone, 1, 3);
		grid.add(txtEmail, 1, 4);
		grid.add(txtStreet, 1, 6);
		grid.add(txtCity, 1, 7);
		grid.add(txtState, 1, 8);
		grid.add(txtZip, 1, 9);

		subimtbtn = new Button("Submit");
		editbtn = new Button("Update");
		cancelBtn = new Button("Cancle");

		cancelBtn.setDisable(true);
		editbtn.setDisable(true);
		subimtbtn.setDisable(false);

		HBox hbxBtn = new HBox(10);

		hbxBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbxBtn.getChildren().add(subimtbtn);
		hbxBtn.getChildren().add(editbtn);
		hbxBtn.getChildren().add(cancelBtn);
		grid.add(hbxBtn, 1, 10);
		hbxBtn.setPrefWidth(200.0);

		// tableview
		tbv = new TableView<User>();
		tbv.setMaxWidth(600);
		tbv.setEditable(true);

		TableColumn<User, String> colUserId = new TableColumn<User, String>("User Email");
		TableColumn<User, String> colfirstName = new TableColumn<User, String>("First Name");
		TableColumn<User, String> colLastName = new TableColumn<User, String>("Last Name");
		TableColumn<User, String> telephone = new TableColumn<User, String>("Telephone");
		TableColumn<User, String> colAddress = new TableColumn<User, String>("Address");

		colfirstName.setCellValueFactory(new PropertyValueFactory<>("User"));
		tbv.getColumns().addAll(colUserId, colfirstName, colLastName, telephone, colAddress);

		// colfirstName.prefWidthProperty().bind(tbv.widthProperty().multiply(0.9));
		tbv.prefWidthProperty().bind(tbv.widthProperty().multiply(4));
		colLastName.prefWidthProperty().bind(tbv.widthProperty().multiply(0.16));
		telephone.prefWidthProperty().bind(tbv.widthProperty().multiply(0.23));
		// first.prefWidthProperty().bind(tbv.widthProperty().multiply(0.22));
		// nameCol.prefWidthProperty().bind(tbv.widthProperty().multiply(0.19));

		tbv.setRowFactory(tv -> {
			TableRow<User> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 1 && (!row.isEmpty())) {
					cancelEdit();
					editForm();
					User rowData = row.getItem();
					txtEmail.setText(rowData.getUserEmail());
					txtFirstname.setText(rowData.getFirstName());
					txtLastname.setText(rowData.getLastName());
					txtTelephone.setText(rowData.getTelephone());
					txtCity.setText(rowData.getAddress().getCity());
					txtState.setValue(rowData.getAddress().getState());
					txtStreet.setText(rowData.getAddress().getStreet());
					txtZip.setText(rowData.getAddress().getZip());
				}
			});
			return row;
		});

		colUserId.setCellValueFactory(data -> {
			User rowValue = data.getValue();
			String cellValue = rowValue.getUserEmail();
			return new ReadOnlyStringWrapper(cellValue);
		});
		colfirstName.setCellValueFactory(data -> {
			User rowValue = data.getValue();
			String cellValue = rowValue.getFirstName();
			return new ReadOnlyStringWrapper(cellValue);
		});
		colLastName.setCellValueFactory(data -> {
			User rowValue = data.getValue();
			String cellValue = rowValue.getLastName();
			return new ReadOnlyStringWrapper(cellValue);
		});
		telephone.setCellValueFactory(data -> {
			User rowValue = data.getValue();
			String cellValue = rowValue.getTelephone();
			return new ReadOnlyStringWrapper(cellValue);
		});
		colAddress.setCellValueFactory(data -> {
			User rowValue = data.getValue();
			String cellValue = rowValue.getAddress().getCity() + "," + rowValue.getAddress().getState() + ","
					+ rowValue.getAddress().getStreet() + "," + rowValue.getAddress().getStreet();
			return new ReadOnlyStringWrapper(cellValue);
		});
		mainGrid.add(grid, 0, 1);
		mainGrid.add(tbv, 1, 1);
		updateUser();
		addUser();
		// Button handler

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		// Context Menu for error messages

		Scene scene = new Scene(mainGrid, 1050, 700);
		// scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
		setScene(scene);

	}

	void addUser() {
		subimtbtn.setOnAction((e) -> {
			System.out.println("------- " + txtEmail);
			try {
				UserFactory.of().validateAddUserForm(txtEmail.getText(), txtFirstname.getText(), txtLastname.getText(),
						txtTelephone.getText(), txtStreet.getText(), txtCity.getText(), txtState.getValue(),
						txtZip.getText());
			} catch (ValidationException ex) {
				Alert alert = new Alert(AlertType.ERROR, ex.getMessage(), ButtonType.OK);
				alert.setTitle("Add Hotel Membership");
				alert.setHeaderText("Validation error");
				alert.show();
				return;
			}
			UserFactory.of().addUser(txtEmail.getText().trim(), txtFirstname.getText().trim(),
					txtLastname.getText().trim(), txtTelephone.getText().trim(), txtStreet.getText().trim(),
					txtCity.getText().trim(), txtState.getValue(), txtZip.getText().trim());

			updateUsersMap(UserFactory.of().getUsersMap());
			refreshUserList();

			resetFields();
			Alert alert = new Alert(AlertType.INFORMATION, "The Add Hotel Membership with email of '"
					+ txtEmail.getText().trim() + "' has been created successfully!", ButtonType.OK);
			alert.setTitle("Add Hotel Membership");
			alert.setHeaderText(" Hotel Membership was created");
			alert.show();
			// hideUpdateBtn();
		});
	}

	void updateUser() {
		editbtn.setOnAction((e) -> {
			System.out.println("------- " + txtEmail);
			try {
				UserFactory.of().validateUpdateUserForm(txtEmail.getText().trim(), txtFirstname.getText().trim(),
						txtLastname.getText().trim(), txtTelephone.getText().trim(), txtStreet.getText().trim(),
						txtCity.getText().trim(), txtState.getValue().trim(), txtZip.getText().trim());
			} catch (ValidationException ex) {
				Alert alert = new Alert(AlertType.ERROR, ex.getMessage(), ButtonType.OK);
				alert.setTitle("Add Hotel Membership");
				alert.setHeaderText("Validation error");
				alert.show();
				return;
			}
			UserFactory.of().addUser(txtEmail.getText().trim(), txtFirstname.getText().trim(),
					txtLastname.getText().trim(), txtTelephone.getText().trim(), txtStreet.getText().trim(),
					txtCity.getText().trim(), txtState.getValue().toString().trim(), txtZip.getText().trim());

			updateUsersMap(UserFactory.of().getUsersMap());
			refreshUserList();

			resetFields();
			Alert alert = new Alert(AlertType.INFORMATION, "Add Hotel Membership with email of '"
					+ txtEmail.getText().trim() + "' has been updated successfully!", ButtonType.OK);
			alert.setTitle("Updated Hotel Membership");
			alert.setHeaderText(" Hotel Membership was updated");
			alert.show();
			// hideUpdateBtn();
		});
	}

	void validateFieldsUser() {

		final ContextMenu fnameValidator = new ContextMenu();
		fnameValidator.setAutoHide(true);
		final ContextMenu lnameValidator = new ContextMenu();
		lnameValidator.setAutoHide(true);
		final ContextMenu passValidator = new ContextMenu();
		passValidator.setAutoHide(true);
		final ContextMenu phoneValidator = new ContextMenu();
		phoneValidator.setAutoHide(true);
		final ContextMenu streetValidator = new ContextMenu();
		streetValidator.setAutoHide(true);
		final ContextMenu cityValidator = new ContextMenu();
		cityValidator.setAutoHide(true);
		final ContextMenu zipValidator = new ContextMenu();
		zipValidator.setAutoHide(true);
		subimtbtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("this is first name " + txtFirstname.getText());
				if (!txtFirstname.getText().matches("[A-Za-z\\s]+")) {
					fnameValidator.getItems().clear();
					fnameValidator.getItems().add(new MenuItem("Please Write your Name correctly"));
					fnameValidator.show(txtFirstname, Side.RIGHT, 10, 0);
				}

				else if (!txtLastname.getText().matches("[A-Za-z\\s]+")) {
					lnameValidator.getItems().clear();
					lnameValidator.getItems().add(new MenuItem("Write your Last Name correctly"));
					lnameValidator.show(txtLastname, Side.RIGHT, 10, 0);
				} else if (!txtTelephone.getText().matches("[0-9]+")) {
					phoneValidator.getItems().clear();
					phoneValidator.getItems().add(new MenuItem("Your phone number is not valid"));
					phoneValidator.show(txtTelephone, Side.RIGHT, 10, 0);
				} else if (!txtStreet.getText().matches("[A-Za-z\\s]+")) {
					streetValidator.getItems().clear();
					streetValidator.getItems().add(new MenuItem("Write your Last Name"));
					streetValidator.show(txtStreet, Side.RIGHT, 10, 0);
				} else if (!txtCity.getText().matches("[A-Za-z\\s]+")) {
					cityValidator.getItems().clear();
					cityValidator.getItems().add(new MenuItem("Write your City"));
					cityValidator.show(txtCity, Side.RIGHT, 10, 0);
				} else if (!txtZip.getText().matches("[0-9]+")) {
					zipValidator.getItems().clear();
					zipValidator.getItems().add(new MenuItem("Write your zip code"));
					zipValidator.show(txtZip, Side.RIGHT, 10, 0);
				} else {
					try {
						UserFactory.of().validateAddUserForm(txtEmail.getText().trim(), txtFirstname.getText().trim(),
								txtLastname.getText().trim(), txtTelephone.getText().trim(), txtStreet.getText().trim(),
								txtCity.getText().trim(), txtState.getValue().toString().trim(),
								txtZip.getText().trim());
					} catch (ValidationException ex) {
						Alert alert = new Alert(AlertType.ERROR, ex.getMessage(), ButtonType.OK);
						alert.setTitle("Add a new library book");
						alert.setHeaderText("Validation error");
						alert.show();
						return;
					}
					UserFactory.of().addUser(txtEmail.getText().trim(), txtFirstname.getText().trim(),
							txtLastname.getText().trim(), txtTelephone.getText().trim(), txtStreet.getText().trim(),
							txtCity.getText().trim(), txtState.getValue().toString().trim(), txtZip.getText().trim());

					updateUsersMap(UserFactory.of().getUsersMap());
					refreshUserList();

					resetFields();
					Alert alert = new Alert(AlertType.INFORMATION, "Add Hotel Membership with email of '"
							+ txtEmail.getText().trim() + "' was added successfully.", ButtonType.OK);
					alert.setTitle("Add Hotel Membership");
					alert.setHeaderText("New Hotel Membership was added");
					alert.show();
				}

			}
		});
	}

	public void getAll() {
		this.usersMap = UserFactory.of().getUsersMap();

		refreshUserList();
	}

	public void updateUsersMap(HashMap<String, User> usersMap) {
		this.usersMap = usersMap;
	}

	public void refreshUserList() {
		if (tbv != null) {
			tbv.getItems().clear();
			this.usersMap.forEach((r, v) -> {
				tbv.getItems().add(v);
			});
		}
	}

	public void resetFields() {
		txtEmail.setText("");
		txtFirstname.setText("");
		txtLastname.setText("");
		txtTelephone.setText("");
		txtStreet.setText("");
		txtCity.setText("");
		txtState.setValue(null);
		txtZip.setText("");
	}

	void cancelEdit() {

		cancelBtn.setOnAction((e) -> {
			resetFields();
			cancelBtn.setDisable(true);
			editbtn.setDisable(true);
			subimtbtn.setDisable(false);
			userEmail.setText("");
		});
	}

	void editForm() {
		cancelBtn.setDisable(false);
		editbtn.setDisable(false);
		subimtbtn.setDisable(true);
	}
}
