package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new act of getting an exam into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateExamDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.exam (exam_code, structure, patient, exam_type, exam_date) VALUES (?, ?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The act of getting an exam to be stored into the database
	 */
	private final Exam exam;

	/**
	 * Creates a new object for storing the act of getting an exam into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param exam
	 *            the act of getting an exam to be stored into the database.
	 */
	public CreateExamDatabase(final Connection con, final Exam exam)
	{
		this.con = con;
		this.exam = exam;
	}

	/**
	 * Stores a new act of getting an exam into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the act of getting an exam.
	 */
	public void createExam() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, exam.getExam_code());
			pstmt.setString(2, exam.getStructure());
			pstmt.setString(3, exam.getPatient());
			pstmt.setString(4, exam.getExam_type());
			pstmt.setDate(5, exam.getExam_date());

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
