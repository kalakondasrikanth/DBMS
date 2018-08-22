package it.unipd.dei.bding.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Searches all the fields associated to a form which corresponds to the result of a desired exam by its exam code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchFieldByExamTypeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select FI.name, FI.field_value " +
			"from treatit.Result as R inner join treatit.Form as FO on R.form=FO.id " +
			"inner join treatit.Field as FI on FO.id=FI.form " +
			"where R.exam= ?;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The exam type of the exam
	 */
	private final String exam_type;

	/**
	 * Creates a new object for searching all the fields associated to a form which corresponds to the result of a desired exam by its exam code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param exam_type
	 *            the exam type of the exam.
	 */
	public SearchFieldByExamTypeDatabase(final Connection con, final String exam_type)
	{
		this.con = con;
		this.exam_type = exam_type;
	}

	/**
	 * Searches all the fields associated to a form which corresponds to the result of a desired exam by its exam code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for fields.
	 */
	public void searchFieldByExamType() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, exam_type);

			rs = pstmt.executeQuery();

			System.out.printf("%nFields successfully searched. Found fields:%n");
			System.out.printf("- %-30s %s%n", "Field name", "Field value");
			while (rs.next())
			{
				System.out.printf("- %-30s %s%n", rs.getString("name"), rs.getString("field_value"));
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
	}
}
