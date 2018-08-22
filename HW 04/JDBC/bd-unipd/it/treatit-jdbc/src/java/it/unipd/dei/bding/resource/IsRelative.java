package it.unipd.dei.bding.resource;


/**
 * Represents the data about the kinship between two patients.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class IsRelative
{
	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient1;

	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient2;

	/**
	 * The degree of relationship connecting the two patients
	 */
	private final String kinship;

	/**
	 * Creates a new relation
	 *
	 * @param patient1
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param patient2
	 * 	          Unique alphanumerical string provided by the Country Administration
	 * @param kinship
	 *            The degree of relationship connecting the two patients
	 */
	public IsRelative(final String patient1, final String patient2, final String kinship)
	{
		this.patient1 = patient1;
		this.patient2 = patient2;
		this.kinship = kinship;
	}

	/**
	 * Returns Unique alphanumerical string provided by the Country Administration
	 * 
	 * @return Unique alphanumerical string provided by the Country Administration
	 */
	public String getPatient1() {
		return patient1;
	}

	/**
	 * Returns Unique alphanumerical string provided by the Country Administration
	 *
	 * @return Unique alphanumerical string provided by the Country Administration
	 */
	public String getPatient2() {
		return patient2;
	}

	/**
	 * Returns The degree of relationship connecting the two patients
	 * 
	 * @return The degree of relationship connecting the two patients
	 */
	public String getKinship() {
		return kinship;
	}

	/**
	 * Returns a string representation of the kinship between two patients
	 *
	 * @return a string representation of the kinship between two patients
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Relation: ");
		
		sb.append("patient1 = ").append(patient1).append("; ");
		sb.append("patient2 = ").append(patient2).append("; ");
		sb.append("kinship = ").append(kinship).append(".");
		
		return sb.toString();
	}
}
