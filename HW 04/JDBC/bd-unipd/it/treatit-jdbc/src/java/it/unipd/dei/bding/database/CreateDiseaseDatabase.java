package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Disease;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new disease into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateDiseaseDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.disease (name, description) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The disease to be stored into the database
	 */
	private final Disease disease;

	/**
	 * Creates a new object for storing a disease into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param disease
	 *            the disease to be stored into the database.
	 */
	public CreateDiseaseDatabase(final Connection con, final Disease disease)
	{
		this.con = con;
		this.disease = disease;
	}

	/**
	 * Stores a new disease into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the disease.
	 */
	public void createDisease() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, disease.getName());
			pstmt.setString(2, disease.getDescription());

			pstmt.execute();

		}
		finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}

			con.close();
		}

	}
}
