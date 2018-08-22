package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Suspects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new disease a doctor suspects that a patient has into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateSuspectsDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.suspects (disease, visit) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The disease a doctor suspects that a patient has to be stored into the database
	 */
	private final Suspects suspects;

	/**
	 * Creates a new object for storing a disease a doctor suspects that a patient has into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param suspects
	 *            the disease a doctor suspects that a patient has to be stored into the database.
	 */
	public CreateSuspectsDatabase(final Connection con, final Suspects suspects)
	{
		this.con = con;
		this.suspects = suspects;
	}

	/**
	 * Stores a new disease a doctor suspects that a patient has into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the disease a doctor suspects that a patient has.
	 */
	public void createSuspects() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, suspects.getDisease());
			pstmt.setInt(2, suspects.getVisit());

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
