package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about a patient.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Patient
{
	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String fiscal_code;

	/**
	 * The name of the patient
	 */
	private final String name;

	/**
	 * The surname of the patient
	 */
	private final String surname;

	/**
	 * The telephone number of the patient
	 */
	private final String telephone_number;

	/**
	 * The date of birth of the patient
	 */
	private final Date birth_date;

	/**
	 * The place where the patient is born
	 */
	private final String place_of_birth;

	/**
	 * The ULSS where the patient comes from
	 */
	private final String ULSS_of_origin;

	/**
	 * The gender of the patient
	 */
	private final String gender;

	/**
	 * Creates a new patient
	 *
	 * @param fiscal_code
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param name
	 *            The name of the patient
	 * @param surname
	 *            The surname of the patient
	 * @param telephone_number
	 *            The telephone number of the patient
	 * @param birth_date
	 *            The date of birth of the patient
	 * @param place_of_birth
	 *            The place where the patient is born
	 * @param ULSS_of_origin
	 *            The ULSS where the patient comes from
	 * @param gender
	 *            The gender of the patient
	 */
	public Patient(final String fiscal_code, final String name, final String surname, final String telephone_number, final Date birth_date, final String place_of_birth, final String ULSS_of_origin, final String gender)
	{
		this.fiscal_code = fiscal_code;
		this.name = name;
		this.surname = surname;
		this.telephone_number = telephone_number;
		this.birth_date = birth_date;
		this.place_of_birth = place_of_birth;
		this.ULSS_of_origin = ULSS_of_origin;
		this.gender = gender;
	}

	/**
	 * Returns Unique alphanumerical string provided by the Country Administration
	 * 
	 * @return Unique alphanumerical string provided by the Country Administration
	 */
	public String getFiscal_code() {
		return fiscal_code;
	}

	/**
	 * Returns The name of the patient
	 * 
	 * @return The name of the patient
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns The surname of the patient
	 * 
	 * @return The surname of the patient
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Returns The telephone number of the patient
	 * 
	 * @return The telephone number of the patient
	 */
	public String getTelephone_number() {
		return telephone_number;
	}

	/**
	 * Returns The date of birth of the patient
	 *
	 * @return The date of birth of the patient
	 */
	public Date getBirth_date() {
		return birth_date;
	}

	/**
	 * Returns The place where the patient is born
	 *
	 * @return The place where the patient is born
	 */
	public String getPlace_of_birth() {
		return place_of_birth;
	}

	/**
	 * Returns The ULSS where the patient comes from
	 *
	 * @return The ULSS where the patient comes from
	 */
	public String getULSS_of_origin() {
		return ULSS_of_origin;
	}

	/**
	 * Returns The gender of the patient
	 *
	 * @return The gender of the patient
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Returns a string representation of the patient
	 *
	 * @return a string representation of the patient
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Patient: ");
		
		sb.append("fiscal code = ").append(fiscal_code).append("; ");
		sb.append("name = ").append(name).append("; ");
		sb.append("surname = ").append(surname).append("; ");
		sb.append("telephone number = ").append(telephone_number).append("; ");
		sb.append("birth date = ").append(birth_date).append("; ");
		sb.append("place of birth = ").append(place_of_birth).append("; ");
		sb.append("ULSS of origin = ").append(ULSS_of_origin).append("; ");
		sb.append("gender = ").append(gender).append(".");
		
		return sb.toString();
	}
}
