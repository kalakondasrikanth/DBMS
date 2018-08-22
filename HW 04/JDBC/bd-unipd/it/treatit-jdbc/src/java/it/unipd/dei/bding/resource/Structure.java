package it.unipd.dei.bding.resource;


/**
 * Represents the data about a medical structure.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Structure
{
	/**
	 * Unique identifier of the structure provided by the National System
	 */
	private final String id;

	/**
	 * The name of the structure
	 */
	private final String name;

	/**
	 * The address of the structure
	 */
	private final String address;

	/**
	 * Creates a new structure
	 *
	 * @param id
	 *            Unique identifier of the structure provided by the National System
	 * @param name
	 * 	          The name of the structure
	 * @param address
	 *            The address of the structure
	 */
	public Structure(final String id, final String name, final String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}

	/**
	 * Returns Unique identifier of the structure provided by the National System
	 * 
	 * @return Unique identifier of the structure provided by the National System
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns The name of the structure
	 *
	 * @return The name of the structure
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns The address of the structure
	 * 
	 * @return The address of the structure
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns a string representation of the structure
	 *
	 * @return a string representation of the structure
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Structure: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("name = ").append(name).append("; ");
		sb.append("address = ").append(address).append(".");
		
		return sb.toString();
	}
}
