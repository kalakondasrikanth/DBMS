package it.unipd.dei.bding.resource;

import java.sql.Date;


/**
 * Represents the data about the result of an exam.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Result
{
	/**
	 * Unique identifier for the exam provided by the National System
	 */
	private final String exam;

	/**
	 * The date in which the result for the exam is delivered to the doctor
	 */
	private final Date result_date;

	/**
	 * The identifier of the form
	 */
	private final int form;

	/**
	 * Creates a new result
	 *
	 * @param exam
	 *            Unique identifier for the exam provided by the National System
	 * @param result_date
	 * 	          The date in which the result for the exam is delivered to the doctor
	 * @param form
	 *            The identifier of the form
	 */
	public Result(final String exam, final Date result_date, final int form)
	{
		this.exam = exam;
		this.result_date = result_date;
		this.form = form;
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
	 * Returns The date in which the result for the exam is delivered to the doctor
	 *
	 * @return The date in which the result for the exam is delivered to the doctor
	 */
	public Date getResult_date() {
		return result_date;
	}

	/**
	 * Returns The identifier of the form
	 * 
	 * @return The identifier of the form
	 */
	public int getForm() {
		return form;
	}

	/**
	 * Returns a string representation of the result
	 *
	 * @return a string representation of the result
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Result: ");
		
		sb.append("exam = ").append(exam).append("; ");
		sb.append("result date = ").append(result_date).append("; ");
		sb.append("form = ").append(form).append(".");
		
		return sb.toString();
	}
}
