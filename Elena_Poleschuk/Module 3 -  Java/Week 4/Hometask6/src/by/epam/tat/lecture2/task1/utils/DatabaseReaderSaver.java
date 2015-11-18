package by.epam.tat.lecture2.task1.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.epam.tat.lecture2.task1.objects.ChocolateCandy;
import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.Sweets;
import by.epam.tat.lecture2.task1.utils.exceptions.OpeningSavedCollectionException;

public class DatabaseReaderSaver implements IReaderSaver {
	private Connection connection;
			
	private Connection getConnection() throws OpeningSavedCollectionException{
		String dbDriverName = "com.mysql.jdbc.Driver";
		String dbUser= "root";
		String dbPassword= "root";
		String dbURL= "jdbc:mysql://localhost:3306/NY";
		try {
			Class.forName(dbDriverName);
		} catch (ClassNotFoundException e) {
			throw new OpeningSavedCollectionException(e);
		}
		try {
			connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		} catch (SQLException e) {
			throw new OpeningSavedCollectionException(e);
		}
		return connection;
	}
	
	private void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			Communicator.out(e.getMessage());
		}
		
	}
		
	@Override
	public List<Sweets> getSavedGift() throws OpeningSavedCollectionException {
		Statement st = null;
		ResultSet res = null;
		List<Sweets> sweets = new ArrayList<Sweets>();
		
		try {
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Gift");
		} catch (SQLException e) {
			throw new OpeningSavedCollectionException(e);
		}
		
		try {
			while(res.next()){  
				sweets.add(new ChocolateCandy(res.getString("sweetName"), res.getString("producerName"), 
						res.getInt("price"), res.getInt("weight")));	
			}
		} catch (SQLException e) {
			throw new OpeningSavedCollectionException(e);
		}
		
		closeConnection();
		
		try {
			if (res != null){
				res.close();
			}
		} catch (SQLException e) {
			throw new OpeningSavedCollectionException(e);
		}
		try {
			if (st != null){
				st.close();
			}
		} catch (SQLException e) {
			throw new OpeningSavedCollectionException(e);
		}
		return sweets;
	}
	
	
	
	@Override
	public void saveGift(Gift gitf) {
		Communicator.out("The method is not implemented");
	}

}
