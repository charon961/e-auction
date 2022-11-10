package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Admin_login_controller {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void login(ActionEvent e) {
		  FXMLLoader loader= new FXMLLoader(getClass().getResource("admin_page.fxml"));
	 	    try {
					root= loader.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   
	 	    stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene = new Scene(root);
				stage.setTitle("E-Auction"); 
		        stage.setScene(scene);
				stage.show();
		    
	   }
	
	public void back(ActionEvent e) {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("login_signup.fxml"));
 	    try {
				root= loader.load();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   
 	    stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene = new Scene(root);
			stage.setTitle("E-Auction"); 
	        stage.setScene(scene);
			stage.show();
	    
   

		
	}
	
}
