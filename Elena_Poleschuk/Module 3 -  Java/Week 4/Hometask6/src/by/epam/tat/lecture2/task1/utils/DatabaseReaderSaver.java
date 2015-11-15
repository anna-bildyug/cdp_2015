package by.epam.tat.lecture2.task1.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.epam.tat.lecture2.task1.objects.ChocolateCandy;
import by.epam.tat.lecture2.task1.objects.Gift;
import by.epam.tat.lecture2.task1.objects.Sweets;

public class DatabaseReaderSaver implements IReaderSaver {
	private Connection connection;
	
	public DatabaseReaderSaver (Connection connection){
		super();
		this.connection = connection;
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	@Override
	public List<Sweets> getSavedGift() {
		Statement st = null;
		ResultSet res = null;
		List<Sweets> sweets = new ArrayList<Sweets>();
		
		try {
			st = getConnection().createStatement();
			res = st.executeQuery("SELECT * FROM Gift");
		} catch (SQLException e) {
			Communicator.out(e.getMessage());
		}
		
		try {
			while(res.next()){  // only chocolate Sweets
				sweets.add(new ChocolateCandy(res.getString("sweetName"), res.getString("producerName"), 
						res.getInt("price"), res.getInt("weight")));	
			}
		} catch (SQLException e) {
			Communicator.out(e.getMessage());
		}
		
		try {
			if (res != null){
				res.close();
			}
		} catch (SQLException e) {
			Communicator.out(e.getMessage());
		}
		try {
			if (st != null){
				st.close();
			}
		} catch (SQLException e) {
			Communicator.out(e.getMessage());
		}
		return sweets;
	}
	
	
	
	@Override
	public void saveGift(Gift gitf) {
		// TODO Auto-generated method stub
	}

}
