package it.unipd.dei.bding.resource;


/**
 * Represents the data about a type of exam.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class ExamType
{
	/**
	 * The specific name of the exam typology
	 */
	private final String name;

	/**
	 * Creates a new type of exam
	 *
	 * @param name
	 *            The specific name of the exam typology
	 */
	public ExamType(final String name)
	{
		this.name = name;
	}

	/**
	 * Returns The specific name of the exam typology
	 *
	 * @return The specific name of the exam typology
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a string representation of the type of exam
	 *
	 * @return a string representation of the type of exam
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Exam type: ");

		sb.append("name = ").append(name).append(".");
		
		return sb.toString();
	}
}
