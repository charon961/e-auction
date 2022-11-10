package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root=FXMLLoader.load(getClass().getResource("admin_page.fxml"));
			//Parent root=FXMLLoader.load(getClass().getResource("Admin_page_delete_char.fxml"));
			//Parent root=FXMLLoader.load(getClass().getResource("demo1.fxml"));
		Parent root=FXMLLoader.load(getClass().getResource("login_signup.fxml"));
		//Parent root=FXMLLoader.load(getClass().getResource("client_signup.fxml"));
			
		//Parent root=FXMLLoader.load(getClass().getResource("client_login.fxml"));
		//	Parent root=FXMLLoader.load(getClass().getResource("Demo.fxml"));
			//BorderPane root = new BorderPane();
			//Parent root=FXMLLoader.load(getClass().getResource("Demo.fxml"));
 Scene scene = new Scene(root);
		//Scene scene = new Scene(root,1080,800); //for main
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("E-Auction"); 
	        primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	//	System.out.println("Hello_world");
		launch(args);
	}
}












