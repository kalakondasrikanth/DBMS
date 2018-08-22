package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.EmailAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new email address of a patient into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateEmailAddressDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.email_address (email, patient) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The email address of a patient to be stored into the database
	 */
	private final EmailAddress email_address;

	/**
	 * Creates a new object for storing an email address of a patient into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param email_address
	 *            the email address of a patient to be stored into the database.
	 */
	public CreateEmailAddressDatabase(final Connection con, final EmailAddress email_address)
	{
		this.con = con;
		this.email_address = email_address;
	}

	/**
	 * Stores a new email address of a patient into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the email address of a patient.
	 */
	public void createEmailAddress() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, email_address.getEmail());
			pstmt.setString(2, email_address.getPatient());

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
