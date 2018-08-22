package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.TakesCare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new patient who is taken care by a doctor into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateTakesCareDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.takes_care (doctor, patient, start_date) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The patient who is taken care by a doctor to be stored into the database
	 */
	private final TakesCare takes_care;

	/**
	 * Creates a new object for storing patient who is taken care by a doctor into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param takes_care
	 *            the patient who is taken care by a doctor to be stored into the database.
	 */
	public CreateTakesCareDatabase(final Connection con, final TakesCare takes_care)
	{
		this.con = con;
		this.takes_care = takes_care;
	}

	/**
	 * Stores a new patient who is taken care by a doctor into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the patient who is taken care by a doctor.
	 */
	public void createTakesCare() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, takes_care.getDoctor());
			pstmt.setString(2, takes_care.getPatient());
			pstmt.setDate(3, takes_care.getStart_date());

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
