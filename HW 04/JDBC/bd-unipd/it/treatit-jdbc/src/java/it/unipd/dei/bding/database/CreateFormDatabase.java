package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new form into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateFormDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.form (name, description) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The form to be stored into the database
	 */
	private final Form form;

	/**
	 * Creates a new object for storing a form into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param form
	 *            the form to be stored into the database.
	 */
	public CreateFormDatabase(final Connection con, final Form form)
	{
		this.con = con;
		this.form = form;
	}

	/**
	 * Stores a new form into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the form.
	 */
	public void createForm() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, form.getName());
			pstmt.setString(2, form.getDescription());

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
