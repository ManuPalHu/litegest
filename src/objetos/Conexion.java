package objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

	private Connection connection = null;
	private ResultSet resultSet;

	public Conexion() {

	}

	public void sentencia(String sentencia) throws SQLException {

		try {

			// Conexi�n
			connection = DriverManager.getConnection("jdbc:sqlite:uno.db");

			// Sentencias.
			Statement statement = connection.createStatement();
			statement.executeUpdate(sentencia);
			

			// Cierre de conexi�n.
			statement.close();
			connection.close();

		} catch (Exception ex) {

			// si error.
			JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
			connection.close();

		}

	}

	public ResultSet SentenciaRset(String consulta) throws SQLException {

		try {
			// Conexi�n
			connection = DriverManager.getConnection("jdbc:sqlite:uno.db");

			// Sentencias.
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(consulta);
			
			return resultSet;
			


		} catch (Exception ex) {

			// si error.
			JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		connection.close();
		return resultSet;
	}
	
	

}
