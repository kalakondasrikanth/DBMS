package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Gets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Searches all the certification that a patient got by his/her fiscal code into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class SearchCertificationByFiscalCodeDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "select C.id, C.certified_condition, D.name ||' '|| D.surname as doctor, C.certification_date, C.deadline " +
			"from treatit.Certification as C inner join treatit.Visit as V on C.Visit=V.id " +
			"inner join treatit.doctor as D on V.doctor=D.id " +
			"where V.patient= ? and C.deadline < current_date " +
			"order by C.certification_date;";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The fiscal code of the patient
	 */
	private final String fiscal_code;

	/**
	 * Creates a new object for searching all the certifications that a patient got by his/her fiscal code.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param fiscal_code
	 *            the fiscal code of the patient.
	 */
	public SearchCertificationByFiscalCodeDatabase(final Connection con, final String fiscal_code)
	{
		this.con = con;
		this.fiscal_code = fiscal_code;
	}

	/**
	 * Searches all the certification that a patient got by his/her fiscal code.
	 * 
	 * @throws SQLException
	 *             if any error occurs while searching for vaccinations.
	 */
	public void searchCertificationByFiscalCode() throws SQLException
	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, fiscal_code);

			rs = pstmt.executeQuery();

			System.out.printf("%nCertifications successfully searched. Found Certifications:%n");
			System.out.printf("- %-17s %-20s %-20s %-20s %s%n", "Certification id", "Certified condition", "Doctor", "Certification date", "Deadline");
			while (rs.next())
			{
				System.out.printf("- %-17s %-20s %-20s %-20s %s%n",
						rs.getString("id"),
						rs.getString("certified_condition"),
						rs.getString("doctor"),
						rs.getDate("certification_date"),
						rs.getDate("deadline"));
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
