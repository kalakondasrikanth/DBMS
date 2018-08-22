package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new patient into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreatePatientDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) VALUES (?, ?, ?, ?, ?, ?, ?, CAST(? AS gender1))";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The patient to be stored into the database
	 */
	private final Patient patient;

	/**
	 * The enum type for storing the patient gender
	 */
	public enum gender1{Male,Female}

	/**
	 * Creates a new object for storing a patient into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param patient
	 *            the patient to be stored into the database.
	 */
	public CreatePatientDatabase(final Connection con, final Patient patient)
	{
		this.con = con;
		this.patient = patient;
	}

	/**
	 * Stores a new patient into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the patient.
	 */
	public void createPatient() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, patient.getFiscal_code());
			pstmt.setString(2, patient.getName());
			pstmt.setString(3, patient.getSurname());
			pstmt.setString(4, patient.getTelephone_number());
			pstmt.setDate(5, patient.getBirth_date());
			pstmt.setString(6, patient.getPlace_of_birth());
			pstmt.setString(7, patient.getULSS_of_origin());
			if(patient.getGender().equalsIgnoreCase("Male"))
				pstmt.setString(8, gender1.Male.toString());
			else
				pstmt.setString(8, gender1.Female.toString());


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
