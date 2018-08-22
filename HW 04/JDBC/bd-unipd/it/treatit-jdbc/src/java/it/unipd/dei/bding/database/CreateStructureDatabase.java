package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Structure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new medical structure into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateStructureDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.structure (id, name, address) VALUES (?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The medical structure to be stored into the database
	 */
	private final Structure structure;

	/**
	 * Creates a new object for storing medical structure into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param structure
	 *            the medical structure to be stored into the database.
	 */
	public CreateStructureDatabase(final Connection con, final Structure structure)
	{
		this.con = con;
		this.structure = structure;
	}

	/**
	 * Stores a new medical structure into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the medical structure.
	 */
	public void createStructure() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, structure.getId());
			pstmt.setString(2, structure.getName());
			pstmt.setString(3, structure.getAddress());

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
