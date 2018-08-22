package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Treatment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new treatment into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateTreatmentDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.treatment (id, name) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The treatment to be stored into the database
	 */
	private final Treatment treatment;

	/**
	 * Creates a new object for storing treatment into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param treatment
	 *            the treatment to be stored into the database.
	 */
	public CreateTreatmentDatabase(final Connection con, final Treatment treatment)
	{
		this.con = con;
		this.treatment = treatment;
	}

	/**
	 * Stores a new treatment into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the treatment.
	 */
	public void createTreatment() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, treatment.getId());
			pstmt.setString(2, treatment.getName());

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
