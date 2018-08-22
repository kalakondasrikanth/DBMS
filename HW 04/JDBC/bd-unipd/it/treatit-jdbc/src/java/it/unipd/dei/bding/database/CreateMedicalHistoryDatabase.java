package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.MedicalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new medical history of a patient into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateMedicalHistoryDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.medical_history (id, visit, form) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The medical history of a patient to be stored into the database
	 */
	private final MedicalHistory medical_history;

	/**
	 * Creates a new object for storing medical history of a patient into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param medical_history
	 *            the medical history of a patient to be stored into the database.
	 */
	public CreateMedicalHistoryDatabase(final Connection con, final MedicalHistory medical_history)
	{
		this.con = con;
		this.medical_history = medical_history;
	}

	/**
	 * Stores a new medical history of a patient into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the medical history of a patient.
	 */
	public void createMedicalHistory() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, medical_history.getId());
			pstmt.setInt(2, medical_history.getVisit());
			pstmt.setInt(3, medical_history.getForm());

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
