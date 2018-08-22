package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Exemption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new exemption gived by a doctor in a visit into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateExemptionDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.exemption (id, activity, reason, exemption_date, deadline, visit, form) VALUES (?, ?, ?, ?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The exemption gived by a doctor in a visit to be stored into the database
	 */
	private final Exemption exemption;

	/**
	 * Creates a new object for storing an exemption gived by a doctor in a visit into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param exemption
	 *            the exemption gived by a doctor in a visit to be stored into the database.
	 */
	public CreateExemptionDatabase(final Connection con, final Exemption exemption)
	{
		this.con = con;
		this.exemption = exemption;
	}

	/**
	 * Stores a new exemption gived by a doctor in a visit into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the exemption gived by a doctor in a visit.
	 */
	public void createExemption() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, exemption.getId());
			pstmt.setString(2, exemption.getActivity());
			pstmt.setString(3, exemption.getReason());
			pstmt.setDate(4, exemption.getExemption_date());
			pstmt.setDate(5, exemption.getDeadline());
			pstmt.setInt(6, exemption.getVisit());
			pstmt.setInt(7, exemption.getForm());

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
