package it.unipd.dei.bding.resource;


/**
 * Represents the data about which disease a doctor suspects that a patient has.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Suspects
{
	/**
	 * The name of the disease
	 */
	private final String disease;

	/**
	 * The identifier of the visit
	 */
	private final int visit;

	/**
	 * Creates a new disease that a doctor suspects that a patient has
	 *
	 * @param disease
	 *            The name of the disease
	 * @param visit
	 *            The identifier of the visit
	 */
	public Suspects(final String disease, final int visit)
	{
		this.disease = disease;
		this.visit = visit;
	}

	/**
	 * Returns The name of the disease
	 *
	 * @return The name of the disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Returns The identifier of the visit
	 * 
	 * @return The identifier of the visit
	 */
	public int getVisit() {
		return visit;
	}

	/**
	 * Returns a string representation of the disease that a doctor suspects that a patient has
	 *
	 * @return a string representation of the disease that a doctor suspects that a patient has
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Suspect: ");
		
		sb.append("disease = ").append(disease).append("; ");
		sb.append("visit = ").append(visit).append(".");
		
		return sb.toString();
	}
}
