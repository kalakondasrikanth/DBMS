package it.unipd.dei.bding.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Searches all the diseases that a patient contracted by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchDiseaseByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select disease, first_appearance_date, end_date, description " +
			"from treatit.Disease as D inner join treatit.Disease_contraction as DC on D.name=DC.disease " +
			"inner join treatit.Visit as V on DC.visit=V.id " +
			"where V.patient= ? " +
			"order by first_appearance_date desc;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The fiscal code of the patient
	 */
	private final String fiscal_code;

	/**
	 * Creates a new object for searching all the diseases that a patient contracted by his/her fiscal code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchDiseaseByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
	}

	/**
	 * Searches all the diseases that a patient contracted by his/her fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for diseases.
	 */
	public void searchExamByFiscalCode() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, fiscal_code);

			rs = pstmt.executeQuery();

			System.out.printf("%nDiseases successfully searched. Found diseases:%n");
			System.out.printf("- %-15s %-25s %-17s %s%n", "Disease name", "First appearance date", "End date", "Disease description");
			while (rs.next())
			{
				System.out.printf("- %-15s %-25s %-17s %s%n",
						rs.getString("disease"),
						rs.getDate("first_appearance_date"),
						rs.getDate("end_date"),
						rs.getString("description"));
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
