package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.ExamType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new type of exam into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateExamTypeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.exam_type (name) VALUES (?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The type of exam to be stored into the database
	 */
	private final ExamType exam_type;

	/**
	 * Creates a new object for storing a type of exam into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param exam_type
	 *            the type of exam to be stored into the database.
	 */
	public CreateExamTypeDatabase(final Connection con, final ExamType exam_type)
	{
		this.con = con;
		this.exam_type = exam_type;
	}

	/**
	 * Stores a new type of exam into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the type of exam.
	 */
	public void createExamType() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, exam_type.getName());

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
