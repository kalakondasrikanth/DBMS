package it.unipd.dei.bding.resource;


/**
 * Represents the data about a treatment.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Treatment
{
	/**
	 * Combination of the unique identifier provided by the structure and the structure name
	 */
	private final String id;

	/**
	 * The name of the treatment
	 */
	private final String name;

	/**
	 * Creates a new treatment
	 *
	 * @param id
	 *            Combination of the unique identifier provided by the structure and the structure name
	 * @param name
	 *            The name of the treatment
	 */
	public Treatment(final String id, final String name)
	{
		this.id = id;
		this.name = name;
	}

	/**
	 * Returns The treatment identifier
	 *
	 * @return The treatment identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns The name of the treatment
	 * 
	 * @return The name of the treatment
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a string representation of the treatment
	 *
	 * @return a string representation of the treatment
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Treatment: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("name = ").append(name).append(".");
		
		return sb.toString();
	}
}
