package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.ComesAfter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new exam that comes after a doctor prescription into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateComesAfterDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.comes_after (exam, prescription) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The exam that comes after a doctor prescription to be stored into the database
	 */
	private final ComesAfter comes_after;

	/**
	 * Creates a new object for storing an exam that comes after a doctor prescription into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param comes_after
	 *            the exam that comes after a doctor prescription to be stored into the database.
	 */
	public CreateComesAfterDatabase(final Connection con, final ComesAfter comes_after)
	{
		this.con = con;
		this.comes_after = comes_after;
	}

	/**
	 * Stores a new exam that comes after a doctor prescription into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the exam that comes after a doctor prescription.
	 */
	public void createComesAfter() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, comes_after.getExam());
			pstmt.setString(2, comes_after.getPrescription());

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
