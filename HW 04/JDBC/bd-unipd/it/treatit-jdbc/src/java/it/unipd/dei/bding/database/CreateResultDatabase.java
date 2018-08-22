package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new result of an exam into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateResultDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.result (exam, result_date, form) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The result of an exam to be stored into the database
	 */
	private final Result result;

	/**
	 * Creates a new object for storing result of an exam into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param result
	 *            the result of an exam to be stored into the database.
	 */
	public CreateResultDatabase(final Connection con, final Result result)
	{
		this.con = con;
		this.result = result;
	}

	/**
	 * Stores a new result of an exam into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the result of an exam.
	 */
	public void createResult() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, result.getExam());
			pstmt.setDate(2, result.getResult_date());
			pstmt.setInt(3, result.getForm());

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
