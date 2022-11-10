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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main_page_controller {
	
	@FXML
	private TextField data1;
	@FXML
	private TextField data2;
	@FXML
	private TextField data3;
	@FXML
	private TextField data4;
	@FXML
	private ImageView ig1;
	@FXML 
	private Text tx1;
	@FXML
	private ImageView ig2;
	@FXML 
	private Text tx2;
	@FXML
	private ImageView ig3;
	@FXML 
	private Text tx3;
	@FXML
	private ImageView ig4;
	@FXML 
	private Text tx4;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	int tem;
	int tem1;
	int tem2;
	int tem3;
	int tem4;
	int tem5;
	int tem6;
	int tem7;
	
	
  
	public void button1(ActionEvent e) throws ClassNotFoundException {
		  Alert b=new Alert(AlertType.INFORMATION);
		 Class.forName("com.mysql.cj.jdbc.Driver");
		// System.out.println(data1);
		 
		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
	        	String stm = "SELECT * FROM clients where id = '1';";
	        	String stm1= "SELECT * FROM item where id = '1';";
	        				
	        		Statement st=con.createStatement();
	        		Statement st1=con.createStatement();
	        		ResultSet rs=st.executeQuery(stm);
	        		
	        		int val=0; String cur=null;
	        		while(rs.next()) {
	        		 val=rs.getInt("price");
	        			System.out.println(val);
	        			
	        		}
	        		rs=st1.executeQuery(stm1);
	        		while(rs.next()) {
		        		 cur=rs.getString("address");
		        			
		        		}
	        		
	        		//String out=String.valueOf(val);
	        		tem=val;
        		 
	        	    st.close();
	        	   con.close();
	        	   
	        	   if(cur.equals("delete.jpg")) {
	        		   b.setContentText("Character Not available !!!");
	        		   b.show();
	        	   }
	        	   else {
	        	   
    	    b.setContentText("The current value is: "+ String.valueOf(val));
     		b.show();
	        	   }
			 
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
		 
	}
	
	
	public void submit1(ActionEvent e) throws ClassNotFoundException {
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// System.out.println(data1);
		 
		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
	        	String stm = "SELECT * FROM clients where id = '1';";
	        				
	        		Statement st=con.createStatement();
	        		ResultSet rs=st.executeQuery(stm);
	        		int val=0;
	        		while(rs.next()) {
	        		 val=rs.getInt("price");
	        			
	        		}
	        		
	        		tem=val;
        		 
	        	    st.close();
	        	   con.close();
	        	   
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
		
		
		String value=data1.getText();
		 Alert a=new Alert(AlertType.WARNING);
		int entered_value=Integer.parseInt(value);
		System.out.println(tem);
		if(entered_value<=tem) {
			a.setContentText("Please put a value greater than "+ String.valueOf(tem));
			a.show();
		}
		else {
			
			try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
		        	String stm ="UPDATE clients "+"SET price ="+entered_value+" WHERE id =1";
		       
		        	
		        				
		        		Statement st=con.createStatement();
		        		st.executeUpdate(stm);

		        	    st.close();
		        	   con.close();
		        	   
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
			 
			
			
			
			
		}
		
	}
	
	
	
	
	public void button2(ActionEvent e) throws ClassNotFoundException{
		
		  Alert b=new Alert(AlertType.INFORMATION);
			 Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println(data1);
			 
			 
			 try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
		        	
		        		String stm = "SELECT * FROM clients where id = '2';";
			        	String stm1= "SELECT * FROM item where id = '2';";
			        				
			        		Statement st=con.createStatement();
			        		Statement st1=con.createStatement();
			        		ResultSet rs=st.executeQuery(stm);
			        		
			        		int val=0; String cur=null;
			        		while(rs.next()) {
			        		 val=rs.getInt("price");
			        			System.out.println(val);
			        			
			        		}
			        		rs=st1.executeQuery(stm1);
			        		while(rs.next()) {
				        		 cur=rs.getString("address");
				        			
				        		}
			        		
			        		//String out=String.valueOf(val);
			        		
	        		 
		        	    st.close();
		        	   con.close();
		        	   
		        	   if(cur.equals("delete.jpg")) {
		        		   b.setContentText("Character Not available !!!");
		        		   b.show();
		        	   }
		        	   else {
		        	   
	    	    b.setContentText("The current value is: "+ String.valueOf(val));
	     		b.show();
		        	   }
				 
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
			 
			 
		
	}
	
	public void submit2(ActionEvent e) throws ClassNotFoundException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		 
		
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
	        	String stm = "SELECT * FROM clients where id = '2';";
	        				
	        		Statement st=con.createStatement();
	        		ResultSet rs=st.executeQuery(stm);
	        		int val=0;
	        		while(rs.next()) {
	        		 val=rs.getInt("price");
	        			
	        		}
	        		
	        		tem1=val;
        		 
	        	    st.close();
	        	   con.close();
	        	   
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
        String value=data2.getText();
        Alert a=new Alert(AlertType.WARNING);
		int entered_value=Integer.parseInt(value);
        System.out.println(value);
        if(entered_value<=tem1) {
			a.setContentText("Please put a value greater than "+ String.valueOf(tem1));
			a.show();
		}
		else {
			
			try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
		        	String stm ="UPDATE clients "+"SET price ="+entered_value+" WHERE id =2";
		       
		        	
		        				
		        		Statement st=con.createStatement();
		        		st.executeUpdate(stm);

		        	    st.close();
		        	   con.close();
		        	   
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }

			
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	public void button3(ActionEvent e) throws ClassNotFoundException{
		
		  Alert b=new Alert(AlertType.INFORMATION);
			 Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println(data1);
			 
			 
			 try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
				 String stm = "SELECT * FROM clients where id = '2';";
		        	String stm1= "SELECT * FROM item where id = '2';";
		        				
		        		Statement st=con.createStatement();
		        		Statement st1=con.createStatement();
		        		ResultSet rs=st.executeQuery(stm);
		        		
		        		int val=0; String cur=null;
		        		while(rs.next()) {
		        		 val=rs.getInt("price");
		        			System.out.println(val);
		        			
		        		}
		        		rs=st1.executeQuery(stm1);
		        		while(rs.next()) {
			        		 cur=rs.getString("address");
			        			
			        		}
		        		
		        		//String out=String.valueOf(val);
		        		
     		 
	        	    st.close();
	        	   con.close();
	        	   
	        	   if(cur.equals("delete.jpg")) {
	        		   b.setContentText("Character Not available !!!");
	        		   b.show();
	        	   }
	        	   else {
	        	   
 	    b.setContentText("The current value is: "+ String.valueOf(val));
  		b.show();
	        	   }
				 
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
			 
			 
		
	}
	
	public void submit3(ActionEvent e) throws ClassNotFoundException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
	        	String stm = "SELECT * FROM clients where id = '3';";
	        				
	        		Statement st=con.createStatement();
	        		ResultSet rs=st.executeQuery(stm);
	        		int val=0;
	        		while(rs.next()) {
	        		 val=rs.getInt("price");
	        			
	        		}
	        		
	        		tem2=val;
      		 
	        	    st.close();
	        	   con.close();
	        	   
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
      String value=data3.getText();
      Alert a=new Alert(AlertType.WARNING);
		int entered_value=Integer.parseInt(value);
      System.out.println(value);
      if(entered_value<=tem2) {
			a.setContentText("Please put a value greater than "+ String.valueOf(tem2));
			a.show();
		}
		else {
			
			try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
		        	String stm ="UPDATE clients "+"SET price ="+entered_value+" WHERE id =3";
		       
		        	
		        				
		        		Statement st=con.createStatement();
		        		st.executeUpdate(stm);

		        	    st.close();
		        	   con.close();
		        	   
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
			 
			
			
			
			
		}
	}
      
      
      
      
      
      
      public void button4(ActionEvent e) throws ClassNotFoundException{
  		
		  Alert b=new Alert(AlertType.INFORMATION);
			 Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println(data1);
			 
			 
			 try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
				 String stm = "SELECT * FROM clients where id = '2';";
		        	String stm1= "SELECT * FROM item where id = '2';";
		        				
		        		Statement st=con.createStatement();
		        		Statement st1=con.createStatement();
		        		ResultSet rs=st.executeQuery(stm);
		        		
		        		int val=0; String cur=null;
		        		while(rs.next()) {
		        		 val=rs.getInt("price");
		        			System.out.println(val);
		        			
		        		}
		        		rs=st1.executeQuery(stm1);
		        		while(rs.next()) {
			        		 cur=rs.getString("address");
			        			
			        		}
		        		
		        		//String out=String.valueOf(val);
		        		
     		 
	        	    st.close();
	        	   con.close();
	        	   
	        	   if(cur.equals("delete.jpg")) {
	        		   b.setContentText("Character Not available !!!");
	        		   b.show();
	        	   }
	        	   else {
	        	   
 	    b.setContentText("The current value is: "+ String.valueOf(val));
  		b.show();
	        	   }
				 
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
			 
			 
		
	}
	
	public void submit4(ActionEvent e) throws ClassNotFoundException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
	        	String stm = "SELECT * FROM clients where id = '4';";
	        				
	        		Statement st=con.createStatement();
	        		ResultSet rs=st.executeQuery(stm);
	        		int val=0;
	        		while(rs.next()) {
	        		 val=rs.getInt("price");
	        			
	        		}
	        		
	        		tem3=val;
      		 
	        	    st.close();
	        	   con.close();
	        	   
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		 
      String value=data4.getText();
      Alert a=new Alert(AlertType.WARNING);
		int entered_value=Integer.parseInt(value);
      System.out.println(value);
      if(entered_value<=tem3) {
			a.setContentText("Please put a value greater than "+ String.valueOf(tem3));
			a.show();
		}
		else {
			
			try {
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
		        	String stm ="UPDATE clients "+"SET price ="+entered_value+" WHERE id =4";
		       
		        	
		        				
		        		Statement st=con.createStatement();
		        		st.executeUpdate(stm);

		        	    st.close();
		        	   con.close();
		        	   
			 }
			 catch(SQLException e1) {
		        e1.printStackTrace();
		    	  }
			 
			
			
			
			
		}   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
		
	}
	
	public void refresh(ActionEvent e) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String imgaddress1 = null;
		String imgaddress2 = null;
		String imgaddress3 = null;
		String imgaddress4 = null;

		 
		 try {
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","yashS#@RMA123");
	        	String stm = "SELECT * FROM item where id = '1';";
	        				
	        		Statement st=con.createStatement();
	        		ResultSet rs=st.executeQuery(stm);
	        		String val = null;
	        		while(rs.next()) {
	        		 val=rs.getString("address");
	        			
	        		}
	        		
	        		  imgaddress1=val;
	        		  stm = "SELECT * FROM item where id = '2';";
	        		rs=st.executeQuery(stm);
		        	 val = null;
		        		while(rs.next()) {
		        		 val=rs.getString("address");
		        			
		        		}
		        		imgaddress2=val;
		        		
		        		 stm = "SELECT * FROM item where id = '3';";
			        		rs=st.executeQuery(stm);
				        	 val = null;
				        		while(rs.next()) {
				        		 val=rs.getString("address");
				        			
				        		}
				        		imgaddress3=val;
				        		
				        		
				        		 stm = "SELECT * FROM item where id = '4';";
					        		rs=st.executeQuery(stm);
						        	 val = null;
						        		while(rs.next()) {
						        		 val=rs.getString("address");
						        			
						        		}
						        		imgaddress4=val;
     		 
	        	    st.close();
	        	   con.close();
	        	   
		 }
		 catch(SQLException e1) {
	        e1.printStackTrace();
	    	  }
		

	   Image myImage=new Image(getClass().getResourceAsStream(imgaddress1));
		ig1.setImage(myImage);
		System.out.println(imgaddress1);
		if(imgaddress1.equals("delete.jpg")) {
		tx1.setText("");}
	
		 
		  myImage=new Image(getClass().getResourceAsStream(imgaddress2));
			ig2.setImage(myImage);
			if(imgaddress2.equals("delete.jpg")) {
				tx2.setText("");}
	   
			  myImage=new Image(getClass().getResourceAsStream(imgaddress3));
				ig3.setImage(myImage);
				if(imgaddress3.equals("delete.jpg")) {
					tx3.setText("");}
		   

				  myImage=new Image(getClass().getResourceAsStream(imgaddress4));
					ig4.setImage(myImage);
					if(imgaddress4.equals("delete.jpg")) {
						tx4.setText("");}

	  
		
		
	}
	
public void Home(ActionEvent e) {
	 FXMLLoader loader= new FXMLLoader(getClass().getResource("Login_signup.fxml"));
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
