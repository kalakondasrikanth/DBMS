package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new prescription gived by a doctor in a visit into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreatePrescriptionDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.prescription (id, type, prescription_date, deadline, visit, form) VALUES (?, ?, ?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The prescription gived by a doctor in a visit to be stored into the database
	 */
	private final Prescription prescription;

	/**
	 * Creates a new object for storing a certification gived by a doctor in a visit into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param prescription
	 *            the certification gived by a doctor in a visit to be stored into the database.
	 */
	public CreatePrescriptionDatabase(final Connection con, final Prescription prescription)
	{
		this.con = con;
		this.prescription = prescription;
	}

	/**
	 * Stores a new prescription gived by a doctor in a visit into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the prescription gived by a doctor in a visit.
	 */
	public void createPrescription() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, prescription.getId());
			pstmt.setString(2, prescription.getType());
			pstmt.setDate(3, prescription.getPrescription_date());
			pstmt.setDate(4, prescription.getDeadline());
			pstmt.setInt(5, prescription.getVisit());
			pstmt.setInt(6, prescription.getForm());

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
