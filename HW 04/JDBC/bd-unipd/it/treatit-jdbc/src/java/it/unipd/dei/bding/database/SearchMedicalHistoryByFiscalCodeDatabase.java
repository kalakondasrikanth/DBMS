package it.unipd.dei.bding.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Searches all the medical histories that a patient got by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchMedicalHistoryByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select V.visit_time, FO.name as form_name, FI.name as field_name, FI.field_value " +
			"from treatit.Visit as V inner join treatit.Medical_History as M on M.visit=V.id " +
			"inner join treatit.Form as FO on FO.id=M.form " +
			"inner join treatit.Field as FI on FO.id=FI.form " +
			"where V.patient= ? " +
			"order by V.visit_time desc;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The fiscal code of the patient
	 */
	private final String fiscal_code;

	/**
	 * Creates a new object for searching all the medical histories that a patient got by his/her fiscal code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchMedicalHistoryByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
	}

	/**
	 * Searches all the medical histories that a patient got by his/her fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for medical histories.
	 */
	public void searchMedicalHistoryByFiscalCode() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, fiscal_code);

			rs = pstmt.executeQuery();

			System.out.printf("%nMedical histories successfully searched. Found medical histories:%n");
			System.out.printf("- %-30s %-35s %-30s %s%n", "Visit time", "Form name", "Field name", "Field value");
			while (rs.next())
			{
				System.out.printf("- %-30s %-35s %-30s %s%n",
						rs.getTimestamp("visit_time"),
						rs.getString("form_name"),
						rs.getString("field_name"),
						rs.getString("field_value"));
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
	}
}
