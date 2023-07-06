package it.team.imports;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnection {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/estremo";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "1212";

	private static final DataSource dataSource;

	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(DB_URL);
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD);

		dataSource = new HikariDataSource(config);
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
