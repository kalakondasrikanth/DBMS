package it.unipd.dei.bding.resource;


/**
 * Represents the data about a drug.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Drug
{
	/**
	 * The commercial name of the drug
	 */
	private final String name;

	/**
	 * The active principle of the drug
	 */
	private final String active_principle;

	/**
	 * Creates a new drug
	 *
	 * @param name
	 *            The commercial name of the drug
	 * @param active_principle
	 *            The active principle of the drug
	 */
	public Drug(final String name, final String active_principle)
	{
		this.name = name;
		this.active_principle = active_principle;
	}

	/**
	 * Returns The commercial name of the drug
	 *
	 * @return The commercial name of the drug
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns The active principle of the drug
	 * 
	 * @return The active principle of the drug
	 */
	public String getActive_principle() {
		return active_principle;
	}

	/**
	 * Returns a string representation of the drug
	 *
	 * @return a string representation of the drug
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Drug: ");
		
		sb.append("name = ").append(name).append("; ");
		sb.append("active principle = ").append(active_principle).append(".");
		
		return sb.toString();
	}
}
