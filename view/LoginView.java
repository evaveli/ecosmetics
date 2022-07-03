package view;

import java.io.File;

import Controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrator;
import model.Cashier;
import model.Manager;
import model.User;
import view.CashierView;

public class LoginView {
    User currentUser;
		
		public Scene showView(Stage primaryStage){
			GridPane root= new GridPane();
			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(50,50,50,50));
			root.setAlignment(Pos.CENTER_RIGHT);
		
			
			Label l1 = new Label("LOGIN");
			l1.setFont(Font.font("Imprint MT Shadow", FontWeight.BOLD, FontPosture.ITALIC, 35));
			l1.setStyle("-fx-text-fill: white;");
			root.add(l1, 2, 0);
			
			
			Label emailLabel= new Label("Username");
			
			TextField emailField= new TextField();
			emailLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
			emailLabel.setStyle("-fx-text-fill: white;");
			emailField.setPromptText("Enter Username");
			root.add(emailLabel, 1, 2);
			root.add(emailField, 2, 2);
			
			Label passwordLabel= new Label("Password");
			PasswordField passwordField= new PasswordField();
			passwordLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
			passwordLabel.setStyle("-fx-text-fill: white;");
			passwordField.setPromptText("Enter Password");
			root.add(passwordLabel, 1, 3);
			root.add(passwordField, 2, 3);
			
			Button login= new Button("Log in");
			login.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			login.setTextFill(Color.SALMON);
			
			Button cancel= new Button("Cancel");
			cancel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			cancel.setTextFill(Color.WHITE);
			cancel.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9)");
			
			HBox h= new HBox();
			h.setPadding(new Insets(5, 5, 5, 5));
			h.setMargin(login, new Insets(0, 10, 0, 10));
			h.getChildren().addAll(login,cancel);
			root.add(h, 2, 4);
			

			Text err = new Text("Something is wrong!!!!");
			err.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
			err.setStyle("-fx-background-color:#F01414");
			err.setFill(Color.RED);
			err.setVisible(false);
			
			root.add(err, 2, 3);
			
			
			cancel.setOnAction(new EventHandler<ActionEvent>()  {
				public void handle (ActionEvent arg0) {
					System.exit(0);
				}
			});
			
			login.setOnAction(e->{
				if(emailField.getText().equals("cashier") && passwordField.getText().equals("cashier"))
				{
					
				    CashierView cashierview = new CashierView(currentUser);
					Scene scene1 = cashierview.showView(primaryStage);
					primaryStage.setScene(scene1);
						
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Successfully logged in as a cashier!");
					alert.showAndWait();
				   
				}
				else if(emailField.getText().equals("manager") && passwordField.getText().equals("manager"))
				{
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Successfully logged in as a manager!");
					alert.show();
					
					ManagerView mv = new ManagerView(currentUser);
					Scene sc = mv.showView(primaryStage);
				}
				else if(emailField.getText().equals("admin") && passwordField.getText().equals("admin"))
				{
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Successfully logged in as a administrator!");
					alert.show();
					AdministratorView av = new AdministratorView(currentUser);
					Scene sc = av.showView(primaryStage);
				}
				
				else {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setTitle("Error");
					errorAlert.setContentText("Please, enter the correct credencials!");
		            errorAlert.show();
				}
				
			});
			
			root.setStyle("-fx-background-image: url('resources/background-image.jpg'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;" +
			           "-fx-background-size: 700 500");
			
			Scene sc= new Scene(root, 700, 500);
			primaryStage.setTitle("Log in");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
	

				@Override
				public void handle(KeyEvent event) {
				    if(emailField.getText().equals("cashier") && passwordField.getText().equals("cashier"))
					{
						
					    CashierView cashierview = new CashierView(currentUser);
						Scene scene1 = cashierview.showView(primaryStage);
						primaryStage.setScene(scene1);
							
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setContentText("Successfully logged in as a cashier!");
						alert.showAndWait();
					   
					}
					else if(emailField.getText().equals("manager") && passwordField.getText().equals("manager"))
					{
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setContentText("Successfully logged in as a manager!");
						alert.show();
						
						ManagerView mv = new ManagerView(currentUser);
						Scene sc = mv.showView(primaryStage);
					}
					else if(emailField.getText().equals("admin") && passwordField.getText().equals("admin"))
					{
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setContentText("Successfully logged in as a administrator!");
						alert.show();
						AdministratorView av = new AdministratorView(currentUser);
						Scene sc = av.showView(primaryStage);
					}
					
					else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setTitle("Error");
						errorAlert.setContentText("Please, enter the correct credencials!");
			            errorAlert.show();
					}
					
				}
				
			});
			return sc;
			
		}
}
			 
	