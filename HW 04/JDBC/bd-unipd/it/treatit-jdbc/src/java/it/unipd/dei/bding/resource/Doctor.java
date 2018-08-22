package it.unipd.dei.bding.resource;

import java.sql.Date;

/**
 * Represents the data about a doctor.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Doctor
{
	/**
	 * Unique identifier for the doctor
	 */
	private final String id;

	/**
	 * The name of the doctor
	 */
	private final String name;

	/**
	 * The surname of the doctor
	 */
	private final String surname;

	/**
	 * The telephone number of the doctor
	 */
	private final String telephone_number;

	/**
	 * The date of birth of the doctor
	 */
	private final Date birth_date;

	/**
	 * The place of birth of the doctor
	 */
	private final String place_of_birth;

	/**
	 * The professional email address of the doctor
	 */
	private final String office_mail;

	/**
	 * Doctor’s personal password saved in hashed form for security reasons
	 */
	private final String hashed_password;

	/**
	 * The number of patients assigned to the doctor
	 */
	private final int actual_patients;

	/**
	 * Creates a new doctor
	 * 
	 * @param id
	 *            Unique identifier for the doctor
	 * @param name
	 *            The name of the doctor
	 * @param surname
	 *            The surname of the doctor
	 * @param telephone_number
	 *            The telephone number of the doctor
	 * @param birth_date
	 *            The date of birth of the doctor
	 * @param place_of_birth
	 *            The place of birth of the doctor
	 * @param office_mail
	 *            The professional email address of the doctor
	 * @param hashed_password
	 *            Doctor’s personal password saved in hashed form for security reasons
	 * @param actual_patients
	 * 	          The number of patients assigned to the doctor
	 */
	public Doctor(final String id, final String name, final String surname, final String telephone_number, final Date birth_date, final String place_of_birth, final String office_mail, final String hashed_password, final int actual_patients)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telephone_number = telephone_number;
		this.birth_date = birth_date;
		this.place_of_birth = place_of_birth;
		this.office_mail = office_mail;
		this.hashed_password = hashed_password;
		this.actual_patients = actual_patients;
	}

	/**
	 * Returns Unique identifier for the doctor
	 * 
	 * @return Unique identifier for the doctor
	 */
	public String getIdentifier() {
		return id;
	}

	/**
	 * Returns The name of the doctor
	 * 
	 * @return The name of the doctor
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns The surname of the doctor
	 * 
	 * @return The surname of the doctor
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Returns The telephone number of the doctor
	 * 
	 * @return The telephone number of the doctor
	 */
	public String getTelephone_number() {
		return telephone_number;
	}

	/**
	 * Returns The date of birth of the doctor
	 *
	 * @return The date of birth of the doctor
	 */
	public Date getBirth_date() {
		return birth_date;
	}

	/**
	 * Returns The place of birth of the doctor
	 *
	 * @return The place of birth of the doctor
	 */
	public String getPlace_of_birth() {
		return place_of_birth;
	}

	/**
	 * Returns The professional email address of the doctor
	 *
	 * @return The professional email address of the doctor
	 */
	public String getOffice_mail() {
		return office_mail;
	}

	/**
	 * Returns Doctor’s personal password saved in hashed form for security reasons
	 *
	 * @return Doctor’s personal password saved in hashed form for security reasons
	 */
	public String getHashed_password() {
		return hashed_password;
	}

	/**
	 * Returns The number of patients assigned to the doctor
	 *
	 * @return The number of patients assigned to the doctor
	 */
	public int getActual_patients() {
		return actual_patients;
	}

	/**
	 * Returns a string representation of the doctor
	 *
	 * @return a string representation of the doctor
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Doctor: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("name = ").append(name).append("; ");
		sb.append("surname = ").append(surname).append("; ");
		sb.append("telephone number = ").append(telephone_number).append("; ");
		sb.append("birth date = ").append(birth_date).append("; ");
		sb.append("place of birth = ").append(place_of_birth).append("; ");
		sb.append("office mail = ").append(office_mail).append("; ");
		sb.append("hashed password = ").append(hashed_password).append("; ");
		sb.append("actual patients = ").append(actual_patients).append(".");
		
		return sb.toString();
	}
}
