package it.unipd.dei.bding.resource;


/**
 * Represents the data about a field of a specific form.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Field
{
	/**
	 * Progressive number identifying the field for a specific form
	 */
	private final int id;

	/**
	 * The name of the field
	 */
	private final String name;

	/**
	 * The value of the field
	 */
	private final String field_value;

	/**
	 * The form identifier
	 */
	private final int form;

	/**
	 * Creates a new field
	 *
	 * @param id
	 *            Progressive number identifying the field for a specific form
	 * @param name
	 *            The name of the field
	 * @param field_value
	 *            The value of the field
	 * @param form
	 *            The form identifier
	 */
	public Field(final int id, final String name, final String field_value, final int form)
	{
		this.id = id;
		this.name = name;
		this.field_value = field_value;
		this.form = form;
	}

	/**
	 * Returns Progressive number identifying the field for a specific form
	 *
	 * @return Progressive number identifying the field for a specific form
	 */
	public int getId() { return id; }

	/**
	 * Returns The name of the field
	 *
	 * @return The name of the field
	 */
	public String getName() { return name; }

	/**
	 * Returns The value of the field
	 *
	 * @return The value of the field
	 */
	public String getField_value() { return field_value; }

	/**
	 * Returns The form identifier
	 *
	 * @return The form identifier
	 */
	public int getForm() { return form; }

	/**
	 * Returns a string representation of the field
	 *
	 * @return a string representation of the field
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Field: ");

		sb.append("id = ").append(id).append("; ");
		sb.append("name = ").append(name).append("; ");
		sb.append("field value = ").append(field_value).append("; ");
		sb.append("form = ").append(form).append(".");

		return sb.toString();
	}
}
