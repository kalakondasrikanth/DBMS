package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Undergoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new patient who undergoes a treatment in a certain structure into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateUndergoesDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.undergoes (patient, treatment, structure, treatment_date) VALUES (?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The patient who undergoes a treatment in a certain structure to be stored into the database
	 */
	private final Undergoes undergoes;

	/**
	 * Creates a new object for storing the patient who undergoes a treatment in a certain structure.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param undergoes
	 *            the patient who undergoes a treatment in a certain structure to be stored into the database.
	 */
	public CreateUndergoesDatabase(final Connection con, final Undergoes undergoes)
	{
		this.con = con;
		this.undergoes = undergoes;
	}

	/**
	 * Stores a new patient who undergoes a treatment in a certain structure into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the patient who undergoes a treatment in a certain structure.
	 */
	public void createUndergoes() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, undergoes.getPatient());
			pstmt.setString(2, undergoes.getTreatment());
			pstmt.setString(3, undergoes.getStructure());
			pstmt.setDate(4, undergoes.getTreatment_date());

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
