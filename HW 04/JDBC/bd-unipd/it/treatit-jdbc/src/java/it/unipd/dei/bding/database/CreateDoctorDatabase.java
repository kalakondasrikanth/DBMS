package it.unipd.dei.bding.database;

import it.unipd.dei.bding.resource.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new doctor into the database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class CreateDoctorDatabase
{
	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO treatit.doctor (id, name, surname, telephone_number, birth_date, place_of_birth, office_mail, hashed_password, actual_patients) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The doctor to be stored into the database
	 */
	private final Doctor doctor;

	/**
	 * Creates a new object for storing an doctor into the database.
	 * 
	 * @param con
	 *            the connection to the database.
	 * @param doctor
	 *            the doctor to be stored into the database.
	 */
	public CreateDoctorDatabase(final Connection con, final Doctor doctor)
	{
		this.con = con;
		this.doctor = doctor;
	}

	/**
	 * Stores a new doctor into the database
	 * 
	 * @throws SQLException
	 *             if any error occurs while storing the doctor.
	 */
	public void createDoctor() throws SQLException
	{
		PreparedStatement pstmt = null;

		try
		{
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, doctor.getIdentifier());
			pstmt.setString(2, doctor.getName());
			pstmt.setString(3, doctor.getSurname());
			pstmt.setString(4, doctor.getTelephone_number());
			pstmt.setDate(5, doctor.getBirth_date());
			pstmt.setString(6, doctor.getPlace_of_birth());
			pstmt.setString(7, doctor.getOffice_mail());
			pstmt.setString(8, Integer.toString(doctor.getHashed_password().hashCode()));
			pstmt.setInt(9, doctor.getActual_patients());

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
