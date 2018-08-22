package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Vaccination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new vaccine into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateVaccinationDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.vaccination (disease) VALUES (?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The vaccine to be stored into the database
	 */
	private final Vaccination vaccination;

	/**
	 * Creates a new object for storing a vaccine into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param vaccination
	 *            the vaccine to be stored into the database.
	 */
	public CreateVaccinationDatabase(final Connection con, final Vaccination vaccination)
	{
		this.con = con;
		this.vaccination = vaccination;
	}

	/**
	 * Stores a new vaccine into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the vaccine.
	 */
	public void createVaccination() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, vaccination.getDisease());

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
