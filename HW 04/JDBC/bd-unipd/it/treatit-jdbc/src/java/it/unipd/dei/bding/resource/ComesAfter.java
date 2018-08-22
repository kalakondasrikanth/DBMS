package it.unipd.dei.bding.resource;


/**
 * Represents the data about an exam that comes after a doctor prescription.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class ComesAfter
{
	/**
	 * Unique identifier for the exam provided by the National System
	 */
	private final String exam;

	/**
	 * The identifier of the prescription
	 */
	private final String prescription;

	/**
	 * Creates a new exam that comes after a doctor prescription
	 *
	 * @param exam
	 *            Unique identifier for the exam provided by the National System
	 * @param prescription
	 *            The identifier of the prescription
	 */
	public ComesAfter(final String exam, final String prescription)
	{
		this.exam = exam;
		this.prescription = prescription;
	}

	/**
	 * Returns Unique identifier for the exam provided by the National System
	 *
	 * @return Unique identifier for the exam provided by the National System
	 */
	public String getExam() {
		return exam;
	}

	/**
	 * Returns The identifier of the prescription
	 * 
	 * @return The identifier of the prescription
	 */
	public String getPrescription() {
		return prescription;
	}

	/**
	 * Returns a string representation of the exam that comes after a doctor prescription
	 *
	 * @return a string representation of the exam that comes after a doctor prescription
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Exam that comes after a doctor prescription: ");
		
		sb.append("exam = ").append(exam).append("; ");
		sb.append("prescription = ").append(prescription).append(".");
		
		return sb.toString();
	}
}
