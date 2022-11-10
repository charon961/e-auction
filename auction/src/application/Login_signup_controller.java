package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login_signup_controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void  signup(ActionEvent e) {
		//System.out.println("signup");
		   FXMLLoader loader= new FXMLLoader(getClass().getResource("Signup_client.fxml"));
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
    public void  login(ActionEvent e) {
    	//System.out.println("login");
    	   FXMLLoader loader= new FXMLLoader(getClass().getResource("Login_client.fxml"));
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
    
    public void admin(ActionEvent e) {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("Admin_login.fxml"));
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
