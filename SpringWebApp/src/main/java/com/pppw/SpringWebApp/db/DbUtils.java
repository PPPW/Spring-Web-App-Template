package com.pppw.SpringWebApp.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbUtils {

	@Autowired
	private DataSource userdataSource;

	@PostConstruct
	public void initialize(){
		try {
			// initialize the user info database
			Connection connection = userdataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE IF EXISTS USER");
			statement.executeUpdate(
					"CREATE TABLE USER(" +
					"ID INTEGER Primary key," +
					"USERNAME varchar(30) not null, " +
					"PASSWORD varchar(30) not null, " + 
					"USERGROUP INTEGER not null)"
					);
			statement.executeUpdate(
					"INSERT INTO USER " +
					"(USERNAME, PASSWORD, USERGROUP) " +
					"VALUES " + "('pppw', 'pppw', 1)"
					);
			statement.close();
			connection.close();
			
			/*Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE IF EXISTS RESTAURANT");
			statement.executeUpdate(
					"CREATE TABLE RESTAURANT(" +
							"ID INTEGER Primary key, " +
							"NAME varchar(30) not null, " +
							"TYPE varchar(30) not null), " + 
							"ADDRESS varchar(30) not null)"
					);
			statement.executeUpdate(
					"INSERT INTO RESTAURANT " +
							"(NAME, TYPE, ADDRESS) " +
							"VALUES " + "('KFC', 'fast food', 'everywhere')"
					);
			statement.close();
			connection.close();*/
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
