package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about the patients who are taken care by a doctor.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class TakesCare
{
	/**
	 * Unique identifier for the doctor
	 */
	private final String doctor;

	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * The day from which the doctor has started taking care of the patient
	 */
	private final Date start_date;

	/**
	 * Creates a new relation between the doctor and the patient
	 *
	 * @param doctor
	 *            Unique identifier for the doctor
	 * @param patient
	 * 	          Unique alphanumerical string provided by the Country Administration
	 * @param start_date
	 *            The day from which the doctor has started taking care of the patient
	 */
	public TakesCare(final String doctor, final String patient, final Date start_date)
	{
		this.doctor = doctor;
		this.patient = patient;
		this.start_date = start_date;
	}

	/**
	 * Returns Unique identifier for the doctor
	 * 
	 * @return Unique identifier for the doctor
	 */
	public String getDoctor() {
		return doctor;
	}

	/**
	 * Returns Unique alphanumerical string provided by the Country Administration
	 *
	 * @return Unique alphanumerical string provided by the Country Administration
	 */
	public String getPatient() {
		return patient;
	}

	/**
	 * Returns The day from which the doctor has started taking care of the patient
	 * 
	 * @return The day from which the doctor has started taking care of the patient
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * Returns a string representation of the patient taken care by a doctor
	 *
	 * @return a string representation of the patient taken care by a doctor
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Takes care: ");
		
		sb.append("doctor = ").append(doctor).append("; ");
		sb.append("patient = ").append(patient).append("; ");
		sb.append("start date = ").append(start_date).append(".");
		
		return sb.toString();
	}
}
