package fr.uvsq21506437.AnnuaireSerealizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabriqueDAO {
	public Connection connect = null;
	private String dburl = "jdbc:derby:test;create=true";
	//private Properties connectionProps = new Properties();
	private FabriqueDAO() throws SQLException {
		connect = DriverManager.getConnection(dburl,
				"myLogin",
				"myPassword");
	}


	public void CreateClassPersonnel() {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Personnel ("
					+ "nom VARCHAR(100),"
					+ "prenom VARCHAR(100),"
					+ "fontcion VARCHAR(100),"
					+ "birth DATE,"
					+ "PRIMARY KEY(nom, prenom)"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void CreateClassTelephone() {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Telepgone ("
					+ "nom1 VARCHAR(100),"
					+ "nom2 VARCHAR(100),"
					+ "num VARCHAR(100),"
					+ "PRIMARY KEY(nom1, nom2, num)"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void CreateClassGroupe() {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Groupe ("
					+ "nom1 VARCHAR(100),"
					+ "nom2 VARCHAR(100),"
					+ "fonction VARCHAR(100),"
					+ "PRIMARY KEY(nom1, nom2)"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
