package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Call;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new number of the call into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateCallDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.call (call_number) VALUES (default)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The number of the call to be stored into the database
	 */
	private final Call call;

	/**
	 * Creates a new object for storing a number of the call into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param call
	 *            the number of the call to be stored into the database.
	 */
	public CreateCallDatabase(final Connection con, final Call call)
	{
		this.con = con;
		this.call = call;
	}

	/**
	 * Stores a new number of the call into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the number of the call.
	 */
	public void createCall() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);

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
