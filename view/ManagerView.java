package view;
import Controller.CashierController;
import Controller.ManagerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Category;
import Controller.CategoryController;
import model.User;

public class ManagerView {
      User currentUser;
	
	public ManagerView(User currentUser) {
		this.currentUser = currentUser;
	}

	public Scene showView(Stage st) {
		BorderPane mainPane = new BorderPane();
		
		mainPane.setStyle("-fx-background-image: url('resources/menaxher.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 800 600");


		
		MenuBar menuBar = new MenuBar();
		menuBar.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9);");

		
		Menu Suppliers = new Menu("Suppliers");
		Menu Stock = new Menu("Stock");
		Menu Quantity = new Menu("Quantity");
		Menu Category = new Menu("Category");
		
		MenuItem addSup = new MenuItem("Add Suppliers");
		MenuItem viewSup = new MenuItem("View Suppliers");
		MenuItem checkStock=new MenuItem("Low Stocks");
		MenuItem quant = new MenuItem("Quantity of Purchases");
		MenuItem addCat= new MenuItem("Add New Category");
		
		  checkStock.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
				(new viewStockM(currentUser)).showView(st);
					
				}
			});
		
	    quant.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					(new QuantityM(currentUser)).showView(st);
					
				}
			});
	    
		addSup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AddSupplier(currentUser)).showView(st,1);
			}
		});
		
		viewSup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new ViewSuppliersM(currentUser)).showView(st);
			}
		});
		
		addCat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AddCategoryM(currentUser)).showView(st);
				
			}

		});
		
		
		Suppliers.getItems().addAll(addSup, viewSup);
		Stock.getItems().add(checkStock);
		Quantity.getItems().add(quant);
		Category.getItems().add(addCat);
		

		Label label = new Label("NOTE: If you want to see the performance of cashier, as well as logging out " + System.lineSeparator()
		+"you MUST click anywhere with your mouse buttons. ");
		label.setStyle("-fx-background-color:#f79fa9 ; -fx-padding: 20px;");
		label.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
		
		ContextMenu menu= new ContextMenu();
		ImageView i1= new ImageView("resources/performance.png");
		MenuItem performance= new MenuItem("Performance", i1);
		i1.setFitHeight(20);
		i1.setFitWidth(20);
		ImageView i4= new ImageView("resources/logout.png");
		MenuItem logout= new MenuItem("Log Out", i4);
		i4.setFitHeight(20);
		i4.setFitWidth(20);
		ImageView i5= new ImageView("resources/exit.png");
		MenuItem exit= new MenuItem("Exit", i5);
		i5.setFitHeight(20);
		i5.setFitWidth(20);
		menu.getItems().addAll(performance, logout,exit);	
		
		
		performance.setOnAction(e->{
			ManagerController mc = new ManagerController();
			String result = mc.checkCashierPerformance(new CashierController());
			System.out.println(result);
			if(result=="OK") {
				Alert okAlert = new Alert(AlertType.INFORMATION);
				okAlert.setHeaderText("Good performance");
				okAlert.setContentText("The performace of the cashier is satisfying. He has ordered more than 5 bills today. You can always check his bills in the bills folder inside the project folder.");
				okAlert.show();
			}
			else if(result=="FAIL") {
				Alert warningAlert = new Alert(AlertType.WARNING);
				warningAlert.setHeaderText("Bad performance");
				warningAlert.setContentText("The performace of the cashier is not satisfying. He has ordered less than 5 bills today. You can always check his bills in the bills folder inside the project folder.");
				warningAlert.show();
			}
		});
	
	
	logout.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			st.setScene(new LoginView().showView(st));
		}
		
	});
	
	exit.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	});
		
			
		mainPane.setOnMousePressed(e->menu.show(mainPane , e.getScreenX() , e.getScreenY()));
		
	
	    menuBar.getMenus().addAll(Suppliers, Stock, Quantity , Category );
		mainPane.setTop(menuBar);
		mainPane.setCenter(label);
		
		
		
		Scene scene = new Scene(mainPane,800,600);
		st.setScene(scene);
		st.setResizable(false);
		st.setTitle("Manager of ECOSMETICS");
		return scene;
		
			
		}
}