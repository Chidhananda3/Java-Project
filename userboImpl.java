package projectbo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.tap.modules.user;

public class userboImpl implements userbo
{
	private static Connection connection=null;
	private static PreparedStatement prepareStatement=null;
	private static java.sql.Statement statement=null;
	private static ResultSet res=null;
	
	private final static String INSERT_QUERY =" Insert into `user`(`userid`,`name`,`email`,`phonenumber`,`dob`) values(?,?,?,?,?)";
	private final static String DELETE_QUERY ="delete from `user` where `userid`=?";
	private final static String UPDATE_QUERY = "update `user` set `name`=?,`email`=?,`phonenumber`=?,`dob`=? where userid=?";
	private final static String SELECT_QUERY =" select * from `user` where userid=? ";
	private final static String SELECT_ALL_QUERY ="select * from `user`";
	
	
	public userboImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","ABC123d*$");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 

	@Override
	public int delete(int userid) {
		try {
			prepareStatement=connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1,userid);
			return prepareStatement.executeUpdate();			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}
		 
		return 0;
	}

	@Override
	public int delete(user u) {		 
		return delete(u.getUserId());
	}

	@Override
	public int update(user u) {
		try {
			prepareStatement=connection.prepareStatement(UPDATE_QUERY);		 
			prepareStatement.setInt(1,u.getUserId());
			prepareStatement.setString(2,u.getName());
			prepareStatement.setString(3,u.getEmail());
			prepareStatement.setString(4,u.getPhoneNumber());
			prepareStatement.setDate(5,u.getDob());
			return prepareStatement.executeUpdate();
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}
		return 0;
	}
		public int save(user u) { 
		int i=0;
		try { 
		
		prepareStatement  =connection.prepareStatement(INSERT_QUERY);
		prepareStatement.setInt(1,u.getUserId());
		prepareStatement.setString(2,u.getName());
		prepareStatement.setString(3,u.getEmail());
		prepareStatement.setString(4,u.getPhoneNumber());
		prepareStatement.setDate(5,u.getDob());
		i=prepareStatement.executeUpdate();
		
		
		} catch(SQLException u1){
		       u1.printStackTrace();	
		}
			
		
		return i;
	}

	@Override
	public user get(int userid) {
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY);		 
			prepareStatement.setInt(1,userid());
			 
			res=prepareStatement.executeQuery();
			if(res.next())
			 {
				 int userid1=res.getInt("userid");
				 String name=res.getString("name");
				 String email=res.getString("email");
				 String phonenumber=res.getString("phonenumber");
				 Date dob=res.getDate("dob");
				 
				 return new user(userid1,name,email,phonenumber,dob);
			 }		 
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}
		return null;
		 
 
	}
	
	private int userid() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<user> getAll(){
		ArrayList<user> users=new  ArrayList<user>();
		
	try {
	 statement=connection.createStatement();
	 res=statement.executeQuery(SELECT_ALL_QUERY);
	 while(res.next())
	 {
		 int userid=res.getInt("userid");
		 String name=res.getString("name");
		 String email=res.getString("email");
		 String phonenumber=res.getString("phonenumber");
		 Date dob=res.getDate("dob");
		 
		 user u=new user(userid,name,email,phonenumber,dob);
		 users.add(u);
	 }
	 
	} catch(SQLException u1){
	       u1.printStackTrace();	
	}
	
	return users;
}
}
