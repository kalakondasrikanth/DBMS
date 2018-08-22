package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about the act of getting an exam.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Exam
{
	/**
	 * Unique identifier provided by the National System
	 */
	private final String exam_code;

	/**
	 * Unique identifier pf the structure provided by the National System
	 */
	private final String structure;

	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * The specific name of the exam typology
	 */
	private final String exam_type;

	/**
	 * The date in which the exam was performed
	 */
	private final Date exam_date;

	/**
	 * Creates a new exam
	 *
	 * @param exam_code
	 *            Unique identifier provided by the National System
	 * @param structure
	 *            Unique identifier pf the structure provided by the National System
	 * @param patient
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param exam_type
	 *            The specific name of the exam typology
	 * @param exam_date
	 *            The date in which the exam was performed
	 */
	public Exam(final String exam_code, final String structure, final String patient, final String exam_type, final Date exam_date)
	{
		this.exam_code = exam_code;
		this.structure = structure;
		this.patient = patient;
		this.exam_type = exam_type;
		this.exam_date = exam_date;
	}

	/**
	 * Returns Unique identifier provided by the National System
	 * 
	 * @return Unique identifier provided by the National System
	 */
	public String getExam_code() {
		return exam_code;
	}

	/**
	 * Returns Unique identifier pf the structure provided by the National System
	 * 
	 * @return Unique identifier pf the structure provided by the National System
	 */
	public String getStructure() {
		return structure;
	}

	/**
	 * Returns Unique alphanumerical string provided by the Country Administration
	 * 
	 * @return Unique alphanumerical string provided by the Country Administration
	 */
	public String getPatient() {
		return patient;
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
	 * Returns The date in which the exam was performed
	 *
	 * @return The date in which the exam was performed
	 */
	public Date getExam_date() {
		return exam_date;
	}

	/**
	 * Returns a string representation of the act of getting an exam
	 *
	 * @return a string representation of the act of getting an exam
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Exam: ");
		
		sb.append("exam code = ").append(exam_code).append("; ");
		sb.append("structure = ").append(structure).append("; ");
		sb.append("patient = ").append(patient).append("; ");
		sb.append("exam type = ").append(exam_type).append("; ");
		sb.append("exam date = ").append(exam_date).append(".");

		return sb.toString();
	}
}
