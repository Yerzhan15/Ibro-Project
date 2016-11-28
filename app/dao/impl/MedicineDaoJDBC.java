package dao.impl;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import dao.interfaces.MedicineDao;
import models.Medicine;
import models.MedicineEntity;
import play.Logger;
import play.db.jpa.JPA;

public class MedicineDaoJDBC implements MedicineDao {

	private static final String USER = "i.ilyassov";
	private static final String PASSWORD = "FRDULH7";
	private static final String PORT = "80";
	private static final String SERVER = "46.101.171.158";
	private static final String DATABASE = "ibrakhim_ilyassov";
	private static final String DBMS = "mysql";


	Connection conn = null;
	
	public MedicineDaoJDBC() {
		try {
			Logger.info("HEllo!");
			conn = getConnection();
		} catch (SQLException e) {
			Logger.info("SQLException during database connection");
		}
	}
	
	private Connection getConnection() throws SQLException {
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", USER);
	    connectionProps.put("password", PASSWORD);
        conn = DriverManager.getConnection("jdbc:" + DBMS + "://" + SERVER + ":" + PORT + "/" + DATABASE, connectionProps);
	    return conn;
	}

	
	
	@Override
	public boolean updateMedicine(Medicine med) {
		if (med == null) {
			return false;
		}
    	try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE Medicine Set Count = " + med.getCount() + " Where idMedicine = " + med.getIdMedicine() + ";");
			stmt.close();
			return true;
    	} catch (SQLException e) {
			Logger.info("SQLException when updating a medicine " + med.getNameMedicine() + e.getMessage());
			return false;
		}
	}

	@Override
	public Medicine getMedicineById(String id) {
		if (id == null) {
			return null;
		}
		List<Medicine> medicines = new ArrayList<Medicine>();
		
		try {
			Statement stmt = conn.createStatement();
	       
	        ResultSet rs = stmt.executeQuery(
	        		"select * from Medicine where idMedicine = " + id + ";");
	        //Logger.info("select * from Medicine where idMedicine = " + id + ";");

	        while (rs.next()) {
		        Medicine med = new Medicine();

	            med.setIdMedicine(rs.getInt("idMedicine"));
	            med.setNameMedicine(rs.getString("NameMedicine"));
				med.setCost(rs.getDouble("Cost"));
				med.setDescription(rs.getString("Description"));
				med.setIngredients(rs.getString("Ingredients"));
				med.setWarnings(rs.getString("Warnings"));
				med.setCount(rs.getInt("Count"));
				medicines.add(med);
	            break;
	        }
	        stmt.close();
		} catch (SQLException e) {
			Logger.info("SQLException when getting a medicine by id " + id);
			return null;
		}
		if (medicines.size() == 0) {
			return null;
		} else {
			return medicines.get(0);
		}
	}
	@Override
	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = new ArrayList<Medicine>();
		try {
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(
	        		"select * from Medicine");
	        while (rs.next()) {
		        Medicine med = new Medicine();

	            med.setIdMedicine(rs.getInt("idMedicine"));
	            med.setNameMedicine(rs.getString("NameMedicine"));
				med.setCost(rs.getDouble("Cost"));
				med.setDescription(rs.getString("Description"));
				med.setIngredients(rs.getString("Ingredients"));
				med.setWarnings(rs.getString("Warnings"));
				med.setCount(rs.getInt("Count"));

	            medicines.add(med);
	        }
	        stmt.close();
		} catch (SQLException e) {
			Logger.info("SQLException when getting all medicines");
			return null;
		}

		return medicines;
	}


}
