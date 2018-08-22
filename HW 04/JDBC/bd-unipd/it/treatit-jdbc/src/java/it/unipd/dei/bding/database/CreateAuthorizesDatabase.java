package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Authorizes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new authorization gived by a doctor to a patient to assume a drug into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateAuthorizesDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.authorizes (prescription, drug, cause, dosage) VALUES (?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The authorization gived by a doctor to a patient to assume a drug to be stored into the database
	 */
	private final Authorizes authorizes;

	/**
	 * Creates a new object for storing the authorization gived by a doctor to a patient to assume a drug.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param authorizes
	 *            the authorization gived by a doctor to a patient to assume a drug to be stored into the database.
	 */
	public CreateAuthorizesDatabase(final Connection con, final Authorizes authorizes)
	{
		this.con = con;
		this.authorizes = authorizes;
	}

	/**
	 * Stores a new authorization gived by a doctor to a patient to assume a drug into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the authorization gived by a doctor to a patient to assume a drug.
	 */
	public void createAuthorizes() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, authorizes.getPrescription());
			pstmt.setString(2, authorizes.getDrug());
			pstmt.setString(3, authorizes.getCause());
			pstmt.setString(4, authorizes.getDosage());

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
