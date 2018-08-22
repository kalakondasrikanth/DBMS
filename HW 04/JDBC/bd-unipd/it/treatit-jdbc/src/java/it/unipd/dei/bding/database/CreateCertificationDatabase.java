package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Certification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new certification gived by a doctor in a visit into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateCertificationDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.certification (id, certified_condition, certification_date, deadline, visit, form) VALUES (?, ?, ?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The certification gived by a doctor in a visit to be stored into the database
	 */
	private final Certification certification;

	/**
	 * Creates a new object for storing a certification gived by a doctor in a visit into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param certification
	 *            the certification gived by a doctor in a visit to be stored into the database.
	 */
	public CreateCertificationDatabase(final Connection con, final Certification certification)
	{
		this.con = con;
		this.certification = certification;
	}

	/**
	 * Stores a new certification gived by a doctor in a visit into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the certification gived by a doctor in a visit.
	 */
	public void createCertification() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, certification.getId());
			pstmt.setString(2, certification.getCertified_condition());
			pstmt.setDate(3, certification.getCertification_date());
			pstmt.setDate(4, certification.getDeadline());
			pstmt.setInt(5, certification.getVisit());
			pstmt.setInt(6, certification.getForm());

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
