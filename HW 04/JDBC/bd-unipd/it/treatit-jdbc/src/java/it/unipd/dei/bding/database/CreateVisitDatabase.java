package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new visit into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateVisitDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.visit (visit_time, patient, doctor) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The visit to be stored into the database
	 */
	private final Visit visit;

	/**
	 * Creates a new object for storing the visit.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param visit
	 *            the visit to be stored into the database.
	 */
	public CreateVisitDatabase(final Connection con, final Visit visit)
	{
		this.con = con;
		this.visit = visit;
	}

	/**
	 * Stores a new visit into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the visit.
	 */
	public void createVisit() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setTimestamp(1, visit.getVisit_time());
			pstmt.setString(2, visit.getPatient());
			pstmt.setString(3, visit.getDoctor());

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
