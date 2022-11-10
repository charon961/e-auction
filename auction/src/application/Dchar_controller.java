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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Dchar_controller {
	
	@FXML
	private TextField tf1;
	@FXML
	private Text tx1;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void submit(ActionEvent e) throws ClassNotFoundException {
		
		  int id=Integer.parseInt(tf1.getText());
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  String s1="\"delete.jpg\"";
		  System.out.println(s1);
			

			 
			 try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
		        	String stm = "update item set address="+s1+" where id = "+id+";";
		        				
		        		Statement st=con.createStatement();
		        		st.executeUpdate(stm);
		        	
		        		
		        	    st.close();
		        	   con.close();
		        	   
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
		 tx1.setText("Character is Deleted!!!!");
		 tf1.setText("");
		 
	}
	
	
	public void back(ActionEvent e) {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Admin_page.fxml"));
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
