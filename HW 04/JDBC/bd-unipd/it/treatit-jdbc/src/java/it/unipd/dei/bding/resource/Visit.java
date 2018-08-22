package it.unipd.dei.bding.resource;


import java.sql.Timestamp;

/**
 * Represents the data about a visit.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Visit
{
	/**
	 * An increasing number
	 */
	private final int id;

	/**
	 * A timestamp including time and date of the visit
	 */
	private final Timestamp visit_time;

	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * Unique identifier for the doctor
	 */
	private final String doctor;

	/**
	 * Creates a new visit
	 *
	 * @param id
	 *            An increasing number
	 * @param visit_time
	 *            A timestamp including time and date of the visit
	 * @param patient
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param doctor
	 *            Unique identifier for the doctor
	 */
	public Visit(final int id, final Timestamp visit_time, final String patient, final String doctor)
	{
		this.id = id;
		this.visit_time = visit_time;
		this.patient = patient;
		this.doctor = doctor;
	}

	/**
	 * Returns The identifier of the visit
	 *
	 * @return The identifier of the visit
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns A timestamp including time and date of the visit
	 *
	 * @return A timestamp including time and date of the visit
	 */
	public Timestamp getVisit_time() {
		return visit_time;
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
	 * Returns Unique identifier for the doctor
	 * 
	 * @return Unique identifier for the doctor
	 */
	public String getDoctor() {
		return doctor;
	}

	/**
	 * Returns a string representation of the visit
	 *
	 * @return a string representation of the visit
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Visit: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("visit time = ").append(visit_time).append("; ");
		sb.append("patient = ").append(patient).append("; ");
		sb.append("doctor = ").append(doctor).append(".");

		return sb.toString();
	}
}
