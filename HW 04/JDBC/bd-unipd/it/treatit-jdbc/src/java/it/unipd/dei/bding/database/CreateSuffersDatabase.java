package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Suffers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new allergy that a patient suffers into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateSuffersDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.suffers (patient, allergy) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The allergy that a patient suffers to be stored into the database
	 */
	private final Suffers suffers;

	/**
	 * Creates a new object for storing an allergy that a patient suffers into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param suffers
	 *            the allergy that a patient suffers to be stored into the database.
	 */
	public CreateSuffersDatabase(final Connection con, final Suffers suffers)
	{
		this.con = con;
		this.suffers = suffers;
	}

	/**
	 * Stores a new allergy that a patient suffers into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the allergy that a patient suffers.
	 */
	public void createSuffers() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, suffers.getPatient());
			pstmt.setString(2, suffers.getAllergy());

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
