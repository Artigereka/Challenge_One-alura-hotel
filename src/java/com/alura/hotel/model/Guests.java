package java.com.alura.hotel.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Guests {

	Connection con;
	Integer id;

	public Guests(Connection con) {
		this.con = con;
	}
	
	public Integer createGuest(String nombre, String apellido, String fechaNacimiento, String nacionalidad,
			String telefono) throws SQLException{
		
		String statement = "INSERT INTO huespedes (nombre, apellido, fechaNacimiento, nacionalidad,"
				+ "telefono) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stm = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nombre);
		stm.setString(2, apellido);
		stm.setDate(3, Date.valueOf(fechaNacimiento));
		stm.setString(4, nacionalidad);
		stm.setString(5, telefono);
		stm.executeUpdate();
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()){
			id = rst.getInt(1);
			//System.out.println("New guest inserted with id: " + id);
		}
		return id;
	}
	
	public void readGuest(Integer id) throws SQLException{
		//Might be necessary add try/catch in case the id doesn't exist
		String statement = "SELECT * FROM huespedes WHERE id = ?";
		PreparedStatement stm = con.prepareStatement(statement);
		
		stm.setInt(1, id);
		stm.execute();
		ResultSet rst = stm.executeQuery();
		
		while(rst.next()){
			String nombre = rst.getString("nombre");
			String apellido = rst.getString("apellido");
			String fechaNacimiento = rst.getString("fechaNacimiento");
			String nacionalidad = rst.getString("nacionalidad");
			String telefono = rst.getString("telefono");
			System.out.println("Guest id: " + id + "\n" 
					+ "Guest nombre: " + nombre + "\n" 
					+ "Guest apellido: " + apellido + "\n" 
					+ "Guest fecha de nacimiento: " + fechaNacimiento + "\n"
					+ "Guest nacionalidad: " + nacionalidad + "\n"
					+ "Guest telefono: " + telefono);
		}
		
	}
	
	public void updateGuest(Integer id, String nombre, String apellido, String fechaNacimiento,
			String nacionalidad, String telefono) throws SQLException{
		
		String statement = "UPDATE huespedes SET nombre = ?, apellido = ?, nacionalidad = ?,"
				+ "telefono = ? WHERE id = ?";
		PreparedStatement stm = con.prepareStatement(statement);
		
		stm.setString(1, nombre);
		stm.setString(2, apellido);
		stm.setDate(3, Date.valueOf(fechaNacimiento));
		stm.setString(4, nacionalidad);
		stm.setString(5, telefono);
		stm.setInt(6, id);
		int rowsAffected = stm.executeUpdate();
		
		if(rowsAffected > 0) {
			System.out.println("Updated guest with id: " + id);
		}
		else {
			System.out.println("No guest found with id: " + id);
		}
		
	}
	
	public void deleteGuest(Integer id) throws SQLException {
		System.out.println("Deleting guest:");
		readGuest(id);

		String statement = "DELETE FROM huespedes WHERE id = ?";
		PreparedStatement stm = con.prepareStatement(statement);

		stm.setInt(1, id);
		stm.executeUpdate();
	}
	
}