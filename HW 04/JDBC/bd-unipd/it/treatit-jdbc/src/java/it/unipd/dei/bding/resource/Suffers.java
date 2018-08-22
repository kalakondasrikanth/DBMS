package it.unipd.dei.bding.resource;


/**
 * Represents the data about which allergies a patient suffers.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Suffers
{
	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * The name of the substance the patient is allergic to
	 */
	private final String allergy;

	/**
	 * Creates a new allergy that a patient suffers
	 *
	 * @param patient
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param allergy
	 *            The name of the substance the patient is allergic to
	 */
	public Suffers(final String patient, final String allergy)
	{
		this.patient = patient;
		this.allergy = allergy;
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
	 * Returns The name of the substance the patient is allergic to
	 * 
	 * @return The name of the substance the patient is allergic to
	 */
	public String getAllergy() {
		return allergy;
	}

	/**
	 * Returns a string representation of the allergy that a patient suffers
	 *
	 * @return a string representation of the allergy that a patient suffers
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Allergy suffered: ");
		
		sb.append("patient = ").append(patient).append("; ");
		sb.append("allergy = ").append(allergy).append(".");
		
		return sb.toString();
	}
}
