package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Field;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new field of a specific form into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateFieldDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.field (name, field_value, form) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The field of a specific form to be stored into the database
	 */
	private final Field field;

	/**
	 * Creates a new object for storing field of a specific form into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param field
	 *            the field of a specific form to be stored into the database.
	 */
	public CreateFieldDatabase(final Connection con, final Field field)
	{
		this.con = con;
		this.field = field;
	}

	/**
	 * Stores a new field of a specific form into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the field of a specific form.
	 */
	public void createField() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, field.getName());
			pstmt.setString(2, field.getField_value());
			pstmt.setInt(3, field.getForm());

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
