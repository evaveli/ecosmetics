package view;


import java.util.ArrayList;

import Controller.ProductController;
import Controller.SupplierController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Product;
import model.Supplier;
import model.User;

public class ViewSuppliersS {
    User currentUser;
	private Supplier cp;
	ObservableList<Product> products;
	int level=0;
    
    
	public ViewSuppliersS(User currentUser) {
		this.currentUser = currentUser;
	}

	public Scene showView(Stage st) {
		
		SupplierController sc =new SupplierController();
		ObservableList<Supplier> suppliers = FXCollections.observableArrayList(sc.getSuppliers());
	
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(30,30,30,30));
		
		Label supplier = new Label("Suppliers");
		supplier.setAlignment(Pos.CENTER);
		supplier.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30));
	   	supplier.setStyle("-fx-text-fill: salmon;");
	
        TableView table = new TableView();
		
		TableColumn name=new TableColumn("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(90);
		
		TableColumn email=new TableColumn("Email");
	    email.setCellValueFactory(new PropertyValueFactory<>("email"));
	    email.setMinWidth(150);
		
		TableColumn phone=new TableColumn("Mobile");
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		phone.setMinWidth(90);
		
		table.setItems(suppliers);
		table.setEditable(true);
		table.getColumns().addAll(name,email,phone);
		
		
		table.setRowFactory(tv -> {
            TableRow<Supplier> chosenRow = new TableRow<>();
            chosenRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!chosenRow.isEmpty()) ) {
                    Supplier sup = chosenRow.getItem();
                       Click(st,sup);
                }
            });
            return chosenRow;
        });
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(50,50,50,50));
		hb.setSpacing(10);
		
		Button add = new Button("Add");
		add.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		add.setTextFill(Color.WHITE);
	    add.setStyle("-fx-background-color: linear-gradient(#ff6666 , #ff9999)");
	    
	    add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				(new AddSupplier(currentUser)).showView(st);
				
			}
		});
	    
		Button delete = new Button("Delete");
		delete.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	    delete.setTextFill(Color.WHITE);
	    delete.setStyle("-fx-background-color: linear-gradient(#c50000 , #a60000)");
	    
	    delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SupplierController sc = new SupplierController();
				ProductController pc = new ProductController();
				if(table.getSelectionModel().getSelectedItems().isEmpty()) {
					new Alert(AlertType.ERROR,"Please select a supplier!!").show();;
					
				}else {
					Supplier sup = (Supplier)table.getSelectionModel().getSelectedItem();
					ArrayList<Product> p = pc.getProducts();
					for(int i=0;i<p.size();i++) {
						if( (p.get(i).getSupplier()).equals(sup.getName()))
							pc.deleteProduct(p.get(i));
					}
					int position = sc.getPosition(sup);
					sc.deleteSupplier(position);
					(new ViewSuppliersS(currentUser)).showView(st);
				}}
		});
	    
		
		hb.getChildren().addAll(add,delete);
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(10);
		vb.getChildren().addAll(supplier,table,hb);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        TableView table1 = new TableView();
		
		TableColumn barcode=new TableColumn("Barcode");
		barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		barcode.setMinWidth(90);
		
		TableColumn product = new TableColumn("Product");
		product.setCellValueFactory(new PropertyValueFactory<>("name"));
		product.setMinWidth(90);
		
		TableColumn category=new TableColumn("Category");
	    category.setCellValueFactory(new PropertyValueFactory<>("category"));
	    category.setMinWidth(90);
		
		
		if(level==0) {
		   table1.setDisable(true);
		}else {
		   table1.setDisable(false);
		}
		
		table1.setItems(products);
		table1.setEditable(false);
		table1.getColumns().addAll(barcode,product,category);
		
		Label l1 = new Label("Products");
		l1.setAlignment(Pos.CENTER);
		l1.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30));
	   	l1.setStyle("-fx-text-fill: salmon;");
	    
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setSpacing(10);
		
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(50); 
		gp.setVgap(10);
		gp.setPadding(new Insets(30,30,30,30));
		
		HBox hb1 = new HBox();
		hb1.setPadding(new Insets(50,50,50,50));
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.CENTER);
		vb1.getChildren().addAll(l1,table1,hb1);
	    Button addProduct = new Button("Add Products");
		addProduct.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		addProduct.setTextFill(Color.WHITE);
	    addProduct.setStyle("-fx-background-color: linear-gradient(#ff6666 , #ff9999)");
	    
	    addProduct.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(table.getSelectionModel().getSelectedItems().isEmpty()) {
					new Alert(AlertType.WARNING,"Please select a supplier!").show();;
					
				}else {
					Supplier sup = (Supplier)table.getSelectionModel().getSelectedItem();
	                (new AddProduct(currentUser, sup.getName())).showView(st);
			    }
				
			}
			
		});
	    
		hb1.getChildren().addAll(addProduct);
		gp.addColumn(0, vb);
		gp.addColumn(1, vb1);
		mainPane.setCenter(gp);
		
		HBox bback= new HBox();
		bback.setAlignment(Pos.CENTER);
		Button back = new Button("Back");
		back.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    back.setTextFill(Color.WHITE);
	    back.setStyle("-fx-background-color: linear-gradient(#99003d , #cc0052)");
		
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				    (new AdministratorView(currentUser)).showView(st);
			}
		});
		
		
		bback.getChildren().add(back);
		mainPane.setBottom(bback);
		mainPane.setStyle("-fx-background-image: url('resources/supView.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 800 600") ;
		
		
		Scene scene=new Scene(mainPane,800,600);
		st.setScene(scene);
		st.setTitle("ECOSMETICS");
		scene.getStylesheets().add("/CSS/style.css");
	
		return scene;
	}
	
     void Click(Stage St, Supplier supplier) {
		this.cp=supplier;
		ProductController pc = new ProductController();
		ArrayList<Product> sp = new ArrayList<Product>();
		for(Product i: pc.getProducts()) {
			if(i.getSupplier().equals(supplier.getName())){
				sp.add(i);	}	}
		products = FXCollections.observableArrayList(sp);
		level=1;
		showView(St);
		
	}

}

