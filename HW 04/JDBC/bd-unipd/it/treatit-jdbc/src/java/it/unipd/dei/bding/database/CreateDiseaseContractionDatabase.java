package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.DiseaseContraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new act of getting a disease into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateDiseaseContractionDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.disease_contraction (id, pain_scale, first_appearance_date, end_date, visit, disease) VALUES (?, ?, ?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The act of getting a disease to be stored into the database
	 */
	private final DiseaseContraction disease_contraction;

	/**
	 * Creates a new object for storing the act of getting a disease into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param disease_contraction
	 *            the act of getting a disease to be stored into the database.
	 */
	public CreateDiseaseContractionDatabase(final Connection con, final DiseaseContraction disease_contraction)
	{
		this.con = con;
		this.disease_contraction = disease_contraction;
	}

	/**
	 * Stores a new act of getting a disease into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the act of getting a disease.
	 */
	public void createDiseaseContraction() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, disease_contraction.getId());
			pstmt.setInt(2, disease_contraction.getPain_scale());
			pstmt.setDate(3, disease_contraction.getFirst_appearance_date());
			pstmt.setDate(4, disease_contraction.getEnd_date());
			pstmt.setInt(5, disease_contraction.getVisit());
			pstmt.setString(6, disease_contraction.getDisease());

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
