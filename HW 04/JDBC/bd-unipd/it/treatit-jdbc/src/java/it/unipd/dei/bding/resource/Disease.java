package it.unipd.dei.bding.resource;



/**
 * Represents the data about a disease.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Disease
{
	/**
	 * The name of the disease
	 */
	private final String name;

	/**
	 * The description of the disease
	 */
	private final String description;

	/**
	 * Creates a new disease
	 *
	 * @param name
	 *            The name of the disease
	 * @param description
	 *            The description of the disease
	 */
	public Disease(final String name, final String description)
	{
		this.name = name;
		this.description = description;
	}

	/**
	 * Returns The name of the disease
	 *
	 * @return The name of the disease
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns The description of the disease
	 * 
	 * @return The description of the disease
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns a string representation of the disease
	 *
	 * @return a string representation of the disease
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Email address: ");
		
		sb.append("name = ").append(name).append("; ");
		sb.append("description = ").append(description).append(".");
		
		return sb.toString();
	}
}
