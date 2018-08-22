package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Searches visit ids of a patient by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchVisitByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select id, visit_time " +
			"from treatit.Visit " +
			"where patient= ?" +
			"order by visit_time desc;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The fiscal code of the patient
	 */
	private final String fiscal_code;

	/**
	 * The results of the search.
	 */
	private final List<Visit> visits;

	/**
	 * Creates a new object for searching visit ids of a patient by his/her fiscal code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchVisitByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
		visits = new ArrayList<Visit>();
	}

	/**
	 * Searches visit ids of a patient by his/her fiscal code.
	 * 
	 * @return a list of {@code Visit} object matching the patient's fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for visit ids.
	 */
	public List<Visit> searchVisitByFiscalCode() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, fiscal_code);

			rs = pstmt.executeQuery();

			while (rs.next())
			{
				visits.add(new Visit(rs.getInt("id"), rs.getTimestamp("visit_time") , fiscal_code, "0002"));
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

		return visits;
	}
}
