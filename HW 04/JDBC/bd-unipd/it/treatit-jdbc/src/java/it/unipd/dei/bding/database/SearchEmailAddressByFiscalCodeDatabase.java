package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.EmailAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Searches email addresses of a patient by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchEmailAddressByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select email from treatit.email_address where patient = ?;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The fiscal code of the patient
	 */
	private final String fiscal_code;

	/**
	 * The results of the search.
	 */
	private final List<EmailAddress> emailAddresses;

	/**
	 * Creates a new object for searching email addresses of a patient by his/her fiscal code.
	 * 
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchEmailAddressByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
		emailAddresses = new ArrayList<EmailAddress>();
	}

	/**
	 * Searches email addresses of a patient by his/her fiscal code.
	 * 
	 * @return a list of {@code EmailAddress} object matching the patient's fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for email addresses.
	 */
	public List<EmailAddress> searchEmailAddressByFiscalCode() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, fiscal_code);

			rs = pstmt.executeQuery();

			while (rs.next())
			{
				emailAddresses.add(new EmailAddress(rs.getString("email"), fiscal_code));
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}

			if (pstmt != null)
			{
				pstmt.close();
			}

			con.close();
		}

		return emailAddresses;
	}
}
