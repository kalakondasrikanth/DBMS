package it.unipd.dei.bding.resource;



/**
 * Represents the data about an email address of a patient.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class EmailAddress
{
	/**
	 * The email of the patient
	 */
	private final String email;

	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * Creates a new email address of a patient
	 *
	 * @param email
	 *            The email of the patient
	 * @param patient
	 *            Unique alphanumerical string provided by the Country Administration
	 */
	public EmailAddress(final String email, final String patient)
	{
		this.email = email;
		this.patient = patient;
	}

	/**
	 * Returns The email of the patient
	 *
	 * @return The email of the patient
	 */
	public String getEmail() {
		return email;
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
	 * Returns a string representation of the email address and its owner
	 *
	 * @return a string representation of the email address and its owner
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Email address: ");
		
		sb.append("email = ").append(email).append("; ");
		sb.append("patient = ").append(patient).append(".");
		
		return sb.toString();
	}
}
