package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Login_controller {
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent e) throws ClassNotFoundException {
		Alert a=new Alert(AlertType.WARNING);
		String myemail=email.getText();
		String mypass=password.getText();
	     String newline = System.lineSeparator();
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     if(myemail.isEmpty()) {
   		  a.setContentText("Email Field cannot be Empty");
   		  a.show();
   		  
   	  }
   	  else if(mypass.isEmpty()) {
   		  a.setContentText("Password Field cannot be Empty");
   		  a.show();
   		  
   	  }
   	  else {
	     
		
		try {
			  int f=0;
    		  for (int i = 0; i < myemail.length(); i++) {
    			     if(myemail.charAt(i)=='@') {f=1; break;}
    	        }
    		  if(f==0) {
    			  a.setContentText("Email not valid");
        		  a.show();
    			  
    		  }
    		  else {
    		  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
        	String stm = "Select * From users";
        				
        		Statement st=con.createStatement();
        	ResultSet rs=	st.executeQuery(stm);
        	int match_found=0;
        	while(rs.next()) {
        		String demail=rs.getString("email");
        		String dpass=rs.getString("password");
        		if(demail.equals(myemail)&&dpass.equals(mypass)) {match_found=1; }
        		//System.out.println(newline);
        		//System.out.println(myemail+" "+demail+" "+mypass+" "+ dpass);
        	}
        	
        		st.close();
        	   con.close();
        	   System.out.println(match_found);
        	   if(match_found==0) {
        		   a.setContentText("Wrong Email or Password !!!!!");
           		a.show();
        		   
        	   }
        	   else {
        	   
        	   FXMLLoader loader= new FXMLLoader(getClass().getResource("Demo.fxml"));
        	    try {
       				root= loader.load();
       			} catch (IOException e1) {
       				// TODO Auto-generated catch block
       				e1.printStackTrace();
       			}
       	   
        	    stage=(Stage)((Node)e.getSource()).getScene().getWindow();
       	        scene = new Scene(root,1080,800);
       			stage.setTitle("E-Auction"); 
       	        stage.setScene(scene);
       			stage.show();
        	   }
		}
		}
    		  
		catch(SQLException e1) {
    		e1.printStackTrace();
    		  
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
