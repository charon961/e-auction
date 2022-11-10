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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Admin_controller {
	  @FXML 
	  private TextField tx1;
	  @FXML 
	  private TextField tx2;
	  @FXML 
	  private TextField tx3;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
public void update(ActionEvent e) throws ClassNotFoundException{
	
	int id=Integer.parseInt(tx1.getText());
	int price=Integer.parseInt(tx2.getText());
	Alert a =new Alert(AlertType.INFORMATION);
	
	System.out.println(price);
	 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
			 String stm ="UPDATE clients "+"SET price ="+price+" WHERE id ="+id;
	        				
	        		Statement st=con.createStatement();
	        		st.executeUpdate(stm);
	        	
	        	    st.close();
	        	   con.close();
	        	   a.setContentText("Price Updated !!!");
	        	   a.show();
	        	   tx1.setText("");
	        	   tx2.setText("");
	 
			 
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
	
		
	}
	public void dchar(ActionEvent e){
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Admin_page_delete_char.fxml"));
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
	
public void deleteclient(ActionEvent e) throws ClassNotFoundException{
	String email=tx3.getText();
	String Email = "\"" + email + "\"";
	System.out.println(Email);
	
	
 Class.forName("com.mysql.cj.jdbc.Driver");
 Alert a =new Alert(AlertType.INFORMATION);
		 
		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
			 String stm =" DELETE FROM users WHERE email="+Email;
	        				
	        		Statement st=con.createStatement();
	        		st.executeUpdate(stm);
	        	
	        	    st.close();
	        	   con.close();
	        	   a.setContentText("Client Deleted !!!");
	        	   a.show();
	        	   tx3.setText("");
	        	   
	 
			 
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
	
		
	}


public void exit(ActionEvent e) {
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
