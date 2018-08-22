package it.unipd.dei.bding.resource;


/**
 * Represents the data about an allergy.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Allergy
{
	/**
	 * The name of the substance the patient is allergic to
	 */
	private final String allergen;

	/**
	 * Creates a new allergy
	 *
	 * @param allergen
	 *            The name of the substance the patient is allergic to
	 */
	public Allergy(final String allergen)
	{
		this.allergen = allergen;
	}

	/**
	 * Returns The name of the substance the patient is allergic to
	 *
	 * @return The name of the substance the patient is allergic to
	 */
	public String getAllergen() {
		return allergen;
	}

	/**
	 * Returns a string representation of the allergy
	 *
	 * @return a string representation of the allergy
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Allergy: ");

		sb.append("allergen = ").append(allergen).append(".");
		
		return sb.toString();
	}
}
