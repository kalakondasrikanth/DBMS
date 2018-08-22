package it.unipd.dei.bding.resource;


/**
 * Represents the data about a form used by the doctors.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Form
{
	/**
	 * Progressive number identifying the form for a specific exam result, medical history or document
	 */
	private final int id;

	/**
	 * The name of the form
	 */
	private final String name;

	/**
	 * A brief description of what the form describes
	 */
	private final String description;

	/**
	 * Creates a new form
	 *
	 * @param id
	 *            Progressive number identifying the form for a specific exam result, medical history or document
	 * @param name
	 * 	          The name of the form
	 * @param description
	 *            A brief description of what the form describes
	 */
	public Form(final int id, final String name, final String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * Returns Progressive number identifying the form for a specific exam result, medical history or document
	 * 
	 * @return Progressive number identifying the form for a specific exam result, medical history or document
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns The name of the form
	 *
	 * @return The name of the form
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns A brief description of what the form describes
	 * 
	 * @return A brief description of what the form describes
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns a string representation of the form
	 *
	 * @return a string representation of the form
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Form: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("name = ").append(name).append("; ");
		sb.append("description = ").append(description).append(".");
		
		return sb.toString();
	}
}
