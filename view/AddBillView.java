package view;


import java.time.LocalDate;
import Controller.BillController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Bill;
import model.User;

public class AddBillView {
    private final User currentUser;
    
    public AddBillView(User user) {
     currentUser = user;
    }

    public Scene showView(Stage primaryStage) {
    	GridPane root  =new GridPane();
   	 root.setAlignment(Pos.CENTER);
   	 root.setHgap(10);
   	 root.setVgap(10);
   	

   	 Label name = new Label("Name of the product");
   	 name.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	 name.setStyle("-fx-text-fill: black;");
   	 Label category = new Label("Category");
   	 category.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	 category.setStyle("-fx-text-fill: black;");
   	 Label supplier = new Label("Supplier");
   	 supplier.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	 supplier.setStyle("-fx-text-fill: black;");
   	 Label quantity = new Label("Quantity");
   	 quantity.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	 quantity.setStyle("-fx-text-fill: black;");
   	 Label price = new Label("Price");
   	 price.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	 price.setStyle("-fx-text-fill: black;");
   	 Label date = new Label("Date");
  	 date.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
  	 date.setStyle("-fx-text-fill: black;");
   	 root.addColumn(0, name, category, supplier,quantity, price, date);
   	 
   	 TextField nameField = new TextField();
   	 TextField catField= new TextField();
   	 TextField supField= new TextField();
   	TextField quantField= new TextField();
   	TextField priceField= new TextField();
   	DatePicker dateP = new DatePicker();
   
   	 root.addColumn(1, nameField, catField, supField , quantField , priceField , dateP);
   	  
   	  
   	 Button create = new Button("Create Bill");
   	 create.setFont(Font.font("Arial", FontWeight.BOLD, 15));
   	 create.setTextFill(Color.LIGHTCORAL);
   	 Button back = new Button("Back");
   	 back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
     back.setTextFill(Color.WHITE);
   	 back.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9)");
   	 
   	 HBox h = new HBox();
   	 h.setSpacing(10);
   	 h.getChildren().addAll(create,back);
   	 root.add(h, 1, 7);
   	 
   	 create.setOnAction(new EventHandler<ActionEvent>() {
   		@Override
		public void handle(ActionEvent event) {
   			int res;
            String name = nameField.getText();
            String supplier = supField.getText();
            String cathegory = catField.getText();
             res = Integer.parseInt(quantField.getText());
            LocalDate datePurchased = dateP.getValue();
            double sellPrice = Double.parseDouble(priceField.getText());
            BillController bc = new BillController();
            Bill bill = new Bill(name, supplier,datePurchased, sellPrice,res); 
            bc.writeFile(bill);
            Alert addBill = new Alert(Alert.AlertType.CONFIRMATION);
            addBill.setHeaderText("The bill was created successfully. You can always check it in the bill folder under the project folder.");
            addBill.showAndWait();
            CashierView cv = new CashierView(currentUser);
            primaryStage.setScene(cv.showView(primaryStage));
   		}
		
	});
   	 
   	 back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			(new CashierView(currentUser)).showView(primaryStage);	
		}
   		 
   	 });
   	root.setStyle("-fx-background-image: url('resources/changepass.jpg'); " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;" +
	           "-fx-background-size: 400 480") ;
     primaryStage.setTitle("Create Bill");
          return new Scene(root, 400, 480);
    
    }
    
}
