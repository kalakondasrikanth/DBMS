package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new drug into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateDrugDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.drug (name, active_principle) VALUES (?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The drug to be stored into the database
	 */
	private final Drug drug;

	/**
	 * Creates a new object for storing a drug into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param drug
	 *            the drug to be stored into the database.
	 */
	public CreateDrugDatabase(final Connection con, final Drug drug)
	{
		this.con = con;
		this.drug = drug;
	}

	/**
	 * Stores a new drug into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the drug.
	 */
	public void createDrug() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, drug.getName());
			pstmt.setString(2, drug.getActive_principle());

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
