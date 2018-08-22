package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.IsRelative;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new kinship between two patients into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateIsRelativeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.is_relative (patient1, patient2, kinship) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The kinship between two patients to be stored into the database
	 */
	private final IsRelative is_relative;

	/**
	 * Creates a new object for storing kinship between two patients into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param is_relative
	 *            the kinship between two patients to be stored into the database.
	 */
	public CreateIsRelativeDatabase(final Connection con, final IsRelative is_relative)
	{
		this.con = con;
		this.is_relative = is_relative;
	}

	/**
	 * Stores a new kinship between two patients into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the kinship between two patients.
	 */
	public void createIsRelative() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, is_relative.getPatient1());
			pstmt.setString(2, is_relative.getPatient2());
			pstmt.setString(3, is_relative.getKinship());

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
