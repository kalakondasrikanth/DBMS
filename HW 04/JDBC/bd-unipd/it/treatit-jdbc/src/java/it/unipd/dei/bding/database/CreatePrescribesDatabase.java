package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Prescribes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new type of exam that a doctor prescribes to a patient to do into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreatePrescribesDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.prescribes (prescription, exam_type, cause) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The type of exam that a doctor prescribes to a patient to do into the database
	 */
	private final Prescribes prescribes;

	/**
	 * Creates a new object for storing type of exam that a doctor prescribes to a patient to do into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param prescribes
	 *            the type of exam that a doctor prescribes to a patient to do to be stored into the database.
	 */
	public CreatePrescribesDatabase(final Connection con, final Prescribes prescribes )
	{
		this.con = con;
		this.prescribes = prescribes;
	}

	/**
	 * Stores a new type of exam that a doctor prescribes to a patient to do into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the type of exam that a doctor prescribes to a patient to do.
	 */
	public void createPrescribes() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, prescribes.getPrescription());
			pstmt.setString(2, prescribes.getExam_type());
			pstmt.setString(3, prescribes.getCause());

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
