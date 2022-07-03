package view;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.LoginView;

public class HomeView  {
	
	public Scene showView(Stage St) {
		
		Button b1=new Button("Exit");
		Font font2 = Font.font("Arial", FontWeight.BOLD, 20);
		b1.setFont(font2);
		b1.setTextFill(Color.WHITE);
		b1.setStyle("-fx-background-color: linear-gradient(#BA1DAB,#f79fa9)");
		
		Button b2=new Button("Login");
		Font font4 = Font.font("Arial", FontWeight.BOLD, 20);
		b2.setFont(font4);
		b2.setTextFill(Color.MAGENTA);
		
		HBox hb= new HBox();
		hb.getChildren().addAll(b2 , b1);
		hb.setPadding(new Insets(5, 5, 5, 5));
		hb.setMargin(b2, new Insets(0, 30, 0, 20));
		hb.setAlignment(Pos.CENTER);
	
		VBox vb=new VBox();
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		 
		Text t = new Text();
		t.setEffect(ds);
		t.setCache(true);
		t.setX(10.0f);
		t.setY(270.0f);
		t.setFill(Color.WHITE);
		t.setText("...ECOSMETICS...");
		t.setFont(Font.font(null, FontWeight.BOLD, 50));
		
		Text t1 = new Text();
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		t1.setText(" ECOSMETICS represents a solid, new account in beauty, one"+ System.lineSeparator()
				+ " that lifts up all outflows of independence. We accept there is"+ System.lineSeparator()
				+ " no single format for beauty. Every lady is particularly wonderful" + System.lineSeparator()
				+ " and we might want to be an accomplice in her voyage to discover "+ System.lineSeparator()
				+ " and improve it."); 
	
		vb.getChildren().addAll(t,t1,hb);
		vb.setSpacing(45);
		vb.setAlignment(Pos.CENTER);

		Scene sc=new Scene(vb,700,500);
		
		St.setScene(sc);
		St.setTitle("ECOSMETICS");
		St.getIcons().add(new Image("resources/logo.jpg"));
	    vb.setStyle("-fx-background-image: url('resources/ABOUT.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 700 500");
	    St.setResizable(false);
	
		
		St.show();
		
		b2.setOnAction(new EventHandler<ActionEvent>( ) {
			public void handle (ActionEvent arg0) {
				St.setScene(new LoginView().showView(St));
			}
		});
		
	
		
		b1.setOnAction(new EventHandler<ActionEvent>( ) {
		public void handle (ActionEvent arg0) {
			System.exit(0);
		}
	});
		return sc;

}}
	
	