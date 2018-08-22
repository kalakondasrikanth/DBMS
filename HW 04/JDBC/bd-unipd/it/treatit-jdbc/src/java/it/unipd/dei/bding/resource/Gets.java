package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about a patient who gets a vaccination in a specific call.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Gets
{
	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * The name of the disease the vaccination is about
	 */
	private final String vaccination;

	/**
	 * The number of the call
	 */
	private final int call;

	/**
	 * The date on which the vaccination was performed
	 */
	private final Date vaccination_date;

	/**
	 * The date when the vaccination expires
	 */
	private final Date deadline;

	/**
	 * Creates a new patient who gets a vaccination in a specific call
	 *
	 * @param patient
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param vaccination
	 *            The name of the disease the vaccination is about
	 * @param call
	 *            The number of the call
	 * @param vaccination_date
	 *            The date on which the vaccination was performed
	 * @param deadline
	 *            The date when the vaccination expires
	 */
	public Gets(final String patient, final String vaccination, final int call, final Date vaccination_date, final Date deadline)
	{
		this.patient = patient;
		this.vaccination = vaccination;
		this.call = call;
		this.vaccination_date = vaccination_date;
		this.deadline = deadline;
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
	 * Returns The name of the disease the vaccination is about
	 * 
	 * @return The name of the disease the vaccination is about
	 */
	public String getVaccination() {
		return vaccination;
	}

	/**
	 * Returns The number of the call
	 * 
	 * @return The number of the call
	 */
	public int getCall() {
		return call;
	}

	/**
	 * Returns The date on which the vaccination was performed
	 * 
	 * @return The date on which the vaccination was performed
	 */
	public Date getVaccination_date() {
		return vaccination_date;
	}

	/**
	 * Returns The date when the vaccination expires
	 *
	 * @return The date when the vaccination expires
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * Returns a string representation of the patient who gets a vaccination in a specific call
	 *
	 * @return a string representation of the patient who gets a vaccination in a specific call
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Vaccination: ");
		
		sb.append("patient = ").append(patient).append("; ");
		sb.append("vaccination = ").append(vaccination).append("; ");
		sb.append("call = ").append(call).append("; ");
		sb.append("vaccination date = ").append(vaccination_date).append("; ");
		sb.append("deadline = ").append(deadline).append(".");

		return sb.toString();
	}
}
