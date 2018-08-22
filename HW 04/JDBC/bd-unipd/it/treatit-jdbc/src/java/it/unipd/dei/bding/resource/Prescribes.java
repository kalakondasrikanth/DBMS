package it.unipd.dei.bding.resource;


/**
 * Represents the data about the type of exam that a doctor prescribes to a patient to do.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Prescribes
{
	/**
	 * Identifier of the prescription
	 */
	private final String prescription;

	/**
	 * The specific name of the exam typology
	 */
	private final String exam_type;

	/**
	 * The reason why the exam object of the prescription was prescribed
	 */
	private final String cause;

	/**
	 * Creates a new exam prescription
	 *
	 * @param prescription
	 *            Identifier of the prescription
	 * @param exam_type
	 * 	          The specific name of the exam typology
	 * @param cause
	 *            The reason why the exam object of the prescription was prescribed
	 */
	public Prescribes(final String prescription, final String exam_type, final String cause)
	{
		this.prescription = prescription;
		this.exam_type = exam_type;
		this.cause = cause;
	}

	/**
	 * Returns Identifier of the prescription
	 * 
	 * @return Identifier of the prescription
	 */
	public String getPrescription() {
		return prescription;
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
	 * Returns The reason why the exam object of the prescription was prescribed
	 * 
	 * @return The reason why the exam object of the prescription was prescribed
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * Returns a string representation of the type of exam that a doctor prescribes to a patient to do
	 *
	 * @return a string representation of the type of exam that a doctor prescribes to a patient to do
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Exam prescription: ");
		
		sb.append("prescription = ").append(prescription).append("; ");
		sb.append("exam type = ").append(exam_type).append("; ");
		sb.append("cause = ").append(cause).append(".");
		
		return sb.toString();
	}
}
