package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Allergy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new allergy into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateAllergyDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.allergy (allergen) VALUES (?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The allergy to be stored into the database
	 */
	private final Allergy allergy;

	/**
	 * Creates a new object for storing an allergy into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param allergy
	 *            the allergy to be stored into the database.
	 */
	public CreateAllergyDatabase(final Connection con, final Allergy allergy)
	{
		this.con = con;
		this.allergy = allergy;
	}

	/**
	 * Stores a new allergy into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the allergy.
	 */
	public void createAllergy() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, allergy.getAllergen());

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
