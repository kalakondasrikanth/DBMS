package it.unipd.dei.bding.resource;


/**
 * Represents the data about a vaccine.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Vaccination
{
	/**
	 * The name of the disease the vaccination is about
	 */
	private final String disease;

	/**
	 * Creates a new vaccine
	 *
	 * @param disease
	 *            The name of the disease the vaccination is about
	 */
	public Vaccination(final String disease)
	{
		this.disease = disease;
	}

	/**
	 * Returns The name of the disease the vaccination is about
	 *
	 * @return The name of the disease the vaccination is about
	 */
	public String getDisease() { return disease;}

	/**
	 * Returns a string representation of the vaccine
	 *
	 * @return a string representation of the vaccine
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Vaccine: ");

		sb.append("disease = ").append(disease).append(".");
		
		return sb.toString();
	}
}
