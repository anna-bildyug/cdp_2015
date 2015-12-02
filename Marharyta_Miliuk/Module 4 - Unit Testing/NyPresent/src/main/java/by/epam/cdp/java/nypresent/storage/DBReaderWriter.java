package by.epam.cdp.java.nypresent.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import by.epam.cdp.java.nypresent.Present;
import by.epam.cdp.java.nypresent.beans.Bar;
import by.epam.cdp.java.nypresent.beans.ChocolateCandy;
import by.epam.cdp.java.nypresent.beans.Lollypop;
import by.epam.cdp.java.nypresent.beans.Sweets;
import by.epam.cdp.java.nypresent.utils.PrinterScanner;
import by.epam.cdp.java.nypresent.validation.PresentStorageException;

public class DBReaderWriter implements IOStreams {
	
     public static final String query = "SELECT type, name, weight, ingredient FROM present";
	  
	private Connection establishConnection() throws PresentStorageException{
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection
			   ("jdbc:mysql://localhost:3306/Present", "root", "12345");
		}
		catch (InstantiationException| IllegalAccessException| ClassNotFoundException| SQLException e){
			throw new PresentStorageException("Oops! Something went wrong");
		}
			return connection;
		}
	
	@Override
	public Present importPresent() throws PresentStorageException {
		Present present = new Present();
		try {
			Connection connect = null;
			connect = establishConnection();
			PreparedStatement statement = connect.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				String candyType = result.getString("type");
				String candyName = result.getString("name");
				int candyWeight = result.getInt("weight");
				String mainIngredient = result.getString("ingredient");

				switch (candyType){
				case "Bar":
					present.addCandy(new Bar(candyName, candyWeight, mainIngredient));
				break;
				
				case "Lollypop":
					present.addCandy(new Lollypop(candyName, candyWeight, mainIngredient));
				break;
				
				case "Chocolate Candy":
					present.addCandy(new ChocolateCandy(candyName, candyWeight, mainIngredient));
					break;	
				}			
		}
			DbUtils.closeQuietly(establishConnection());
			DbUtils.closeQuietly(statement);
			DbUtils.closeQuietly(result);
		} 
		catch (SQLException e) {
			throw new PresentStorageException (e);
		}
	return present;
   }

	@Override
	public void exportPresent(Present present) throws PresentStorageException {
		
		PrinterScanner.printObject("Sorry, the functionality is not implemented yet");
	}
}