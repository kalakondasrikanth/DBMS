package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.IsAbout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new type of the exam that is about a disease into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateIsAboutDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.is_about (disease, exam_type) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The type of the exam that is about a disease to be stored into the database
	 */
	private final IsAbout is_about;

	/**
	 * Creates a new object for storing a type of the exam that is about a disease into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param is_about
	 *            the type of the exam that is about a disease to be stored into the database.
	 */
	public CreateIsAboutDatabase(final Connection con, final IsAbout is_about)
	{
		this.con = con;
		this.is_about = is_about;
	}

	/**
	 * Stores a new type of the exam that is about a disease into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the type of the exam that is about a disease.
	 */
	public void createIsAbout() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, is_about.getDisease());
			pstmt.setString(2, is_about.getExam_type());

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
