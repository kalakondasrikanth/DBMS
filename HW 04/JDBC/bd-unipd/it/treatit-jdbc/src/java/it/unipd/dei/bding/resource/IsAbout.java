package it.unipd.dei.bding.resource;


/**
 * Represents the data about which disease is about the type of the exam.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class IsAbout
{
	/**
	 * The name of the disease
	 */
	private final String disease;

	/**
	 * The specific name of the exam typology
	 */
	private final String exam_type;

	/**
	 * Creates a new treatment
	 *
	 * @param disease
	 *            The name of the disease
	 * @param exam_type
	 *            The specific name of the exam typology
	 */
	public IsAbout(final String disease, final String exam_type)
	{
		this.disease = disease;
		this.exam_type = exam_type;
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
	 * Returns The specific name of the exam typology
	 * 
	 * @return The specific name of the exam typology
	 */
	public String getExam_type() {
		return exam_type;
	}

	/**
	 * Returns a string representation of which disease is about the type of the exam
	 *
	 * @return a string representation of which disease is about the type of the exam
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Is about: ");
		
		sb.append("disease = ").append(disease).append("; ");
		sb.append("exam type = ").append(exam_type).append(".");
		
		return sb.toString();
	}
}
