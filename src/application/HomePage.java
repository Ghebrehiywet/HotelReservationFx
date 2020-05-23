package application;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomePage extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private static Stage primStage = null;

	public static Stage primStage() {
		return primStage;
	}

	public static class Colors {
		static Color green = Color.web("#F18851");
		static Color red = Color.FIREBRICK;
	}

	// TODO:
	private static Stage[] allWindows = { AddUserWindow.INSTANCE };

	public static void hideAllWindows() {
		primStage.hide();
		for (Stage st : allWindows) {
			st.hide();
		}
	}

	public static void destroyAllWindows() {
		for (Stage st : allWindows) {
			((LibWindow) st).setInitialized(false);
		}
	}

	public static void showMemeberPage(Boolean reset) {
		hideAllWindows();
		if (!AddUserWindow.INSTANCE.isInitialized()) {
			AddUserWindow.INSTANCE.init();
		}
		if (reset) {
			AddUserWindow.INSTANCE.resetFields();
			AddUserWindow.INSTANCE.getAll();

		}
		AddUserWindow.INSTANCE.setTitle("User Membership Form");
		AddUserWindow.INSTANCE.show();
	}

	@Override
	public void start(Stage primaryStage) {
		primStage = primaryStage;
		primaryStage.setTitle("Main Page");

		VBox topContainer = new VBox();
		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();
		VBox imageHolder = new VBox();
		Image image = new Image("application/resources/hotel_reservation.JPG", 800, 500, false, false);

		ImageView iv = new ImageView();
		 iv.setImage(image);
		imageHolder.getChildren().add(iv);
		imageHolder.setAlignment(Pos.CENTER);
		HBox splashBox = new HBox();
		Label splashLabel = new Label("Online Hotel Reservation System");
		splashLabel.setFont(Font.font("Trajan Pro", FontWeight.BOLD, 30));
		splashBox.getChildren().add(splashLabel);
		splashBox.setAlignment(Pos.CENTER);

		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(splashBox);
		topContainer.getChildren().add(imageHolder);

		Menu optionsMenu = new Menu("Options");
		MenuItem registerUser = new MenuItem("User Registration");

		registerUser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AddUserWindow.INSTANCE.init();
				AddUserWindow.INSTANCE.setTitle("User Registration Form");
				AddUserWindow.INSTANCE.show();
			}
		});

		optionsMenu.getItems().addAll(registerUser);

		mainMenu.getMenus().addAll(optionsMenu);
		Scene scene = new Scene(topContainer, 900, 670);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
