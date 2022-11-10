package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
  

public class Controller {
	
	@FXML
	private TextField name;
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	
      public void submit(ActionEvent e) throws ClassNotFoundException {
    	  Alert a=new Alert(AlertType.WARNING);
    	  String myname=name.getText();
    	  String myemail=email.getText();
    	  String pass=password.getText();
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  if(myname.isEmpty()) {
    		  a.setContentText("Name Field cannot be Empty");
    		  a.show();
    	  }
    	  else if(myemail.isEmpty()) {
    		  a.setContentText("Email Field cannot be Empty");
    		  a.show();
    		  
    	  }
    	  else if(pass.isEmpty()) {
    		  a.setContentText("Password Field cannot be Empty");
    		  a.show();
    		  
    	  }
    	  else {
    		  int f=0;
    		  for (int i = 0; i < myemail.length(); i++) {
    			     if(myemail.charAt(i)=='@') {f=1; break;}
    	        }
    		  if(f==0) {
    			  a.setContentText("Email not valid");
        		  a.show();
    			  
    		  }
    		  else {
    	  
    	  System.out.print("Hello "+myname+" you are registered in our database!");
    	  try {
    			
    		  
        		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
        	String stm = "INSERT INTO users VALUES ('"+myname+"', '"+myemail+"', '"+pass+"')";
        				
        		Statement st=con.createStatement();
        		st.executeUpdate(stm);
        		st.close();
        	   con.close();
        	   FXMLLoader loader= new FXMLLoader(getClass().getResource("client_login.fxml"));
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
    	  catch(SQLException e1) {
    		System.out.println("Email already in use");
    		
    		a.setContentText("Email Already in Use");
    		a.show();
    		  
    	  }
    	    //System.out.print("Hello "+myname+" you are registered in our database!");
   
    		  }
    	  
    	    
    	  }    
    	   
			
   	    
      }
      public void back(ActionEvent e){
    	 
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


