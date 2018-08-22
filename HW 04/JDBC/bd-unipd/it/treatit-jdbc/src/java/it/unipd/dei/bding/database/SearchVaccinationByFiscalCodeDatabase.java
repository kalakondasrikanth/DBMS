package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Gets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Searches all the vaccinations that a patient got by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchVaccinationByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select vaccination, call, vaccination_date, deadline " +
			"from treatit.gets where patient = ? " +
			"order by deadline desc;";

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
	private final List<Gets> vaccinations;

	/**
	 * Creates a new object for searching all the vaccinations that a patient got by his/her fiscal code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchVaccinationByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
		vaccinations = new ArrayList<Gets>();
	}

	/**
	 * Searches all the vaccinations that a patient got by his/her fiscal code.
	 * 
	 * @return a list of {@code Gets} object matching the patient's fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for vaccinations.
	 */
	public List<Gets> searchVaccinationByFiscalCode() throws SQLException
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
				vaccinations.add(new Gets(fiscal_code,
						rs.getString("vaccination"),
						rs.getInt("call"),
						rs.getDate("vaccination_date"),
						rs.getDate("deadline")));
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

		return vaccinations;
	}
}
