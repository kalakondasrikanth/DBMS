package it.unipd.dei.bding.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Searches all the exams that a patient got by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchExamByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select exam_code, exam_type, exam_date, result_date " +
			"from treatit.Exam as E inner join treatit.Result as R on E.exam_code=R.exam " +
			"where E.patient= ? " +
			"order by exam_date desc;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The fiscal code of the patient
	 */
	private final String fiscal_code;

	/**
	 * Creates a new object for searching all the exams that a patient got by his/her fiscal code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchExamByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
	}

	/**
	 * Searches all the exams that a patient got by his/her fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for exams.
	 */
	public void searchExamByFiscalCode() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, fiscal_code);

			rs = pstmt.executeQuery();
			System.out.printf("%nExams successfully searched. Found exams:%n");
			System.out.printf("- %-15s %-12s %-17s %s%n", "Exam code", "Exam type", "Exam date", "Result date");
			while (rs.next())
			{
				System.out.printf("- %-15s %-12s %-17s %s%n",
						rs.getString("exam_code"),
						rs.getString("exam_type"),
						rs.getDate("exam_date"),
						rs.getDate("result_date"));
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
