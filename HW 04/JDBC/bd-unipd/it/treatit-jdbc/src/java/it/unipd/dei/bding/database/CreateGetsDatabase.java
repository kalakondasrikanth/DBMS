package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Gets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new patient who gets a vaccination in a specific call into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateGetsDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.gets (patient, vaccination, call, vaccination_date, deadline) VALUES (?, ?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The patient who gets a vaccination in a specific call to be stored into the database
	 */
	private final Gets gets;

	/**
	 * Creates a new object for storing the patient who gets a vaccination in a specific call.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param gets
	 *            the patient who gets a vaccination in a specific call to be stored into the database.
	 */
	public CreateGetsDatabase(final Connection con, final Gets gets)
	{
		this.con = con;
		this.gets = gets;
	}

	/**
	 * Stores a new patient who gets a vaccination in a specific call into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the patient who gets a vaccination in a specific call.
	 */
	public void createGets() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, gets.getPatient());
			pstmt.setString(2, gets.getVaccination());
			pstmt.setInt(3, gets.getCall());
			pstmt.setDate(4, gets.getVaccination_date());
			pstmt.setDate(5, gets.getDeadline());

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
