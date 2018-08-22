package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about a prescription.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Prescription
{
	/**
	 * Unique identifier for the prescription, derived from the visit one
	 */
	private final String id;

	/**
	 * The type of the medical prescription
	 */
	private final String type;

	/**
	 * The date when the prescription is released
	 */
	private final Date prescription_date;

	/**
	 * The date when the prescription expires
	 */
	private final Date deadline;

	/**
	 * The identifier of the visit
	 */
	private final int visit;

	/**
	 * The prescription form identifier
	 */
	private final int form;

	/**
	 * Creates a new prescription
	 *
	 * @param id
	 *            Unique identifier for the prescription, derived from the visit one
	 * @param type
	 *            The type of the medical prescription
	 * @param prescription_date
	 *            The date when the prescription is released
	 * @param deadline
	 *            The date when the prescription expires
	 * @param visit
	 *            The identifier of the visit
	 * @param form
	 *            The prescription form identifier
	 */
	public Prescription(final String id, final String type, final Date prescription_date, final Date deadline, final int visit, final int form)
	{
		this.id = id;
		this.type = type;
		this.prescription_date = prescription_date;
		this.deadline = deadline;
		this.visit = visit;
		this.form = form;
	}

	/**
	 * Returns Unique identifier for the prescription, derived from the visit one
	 * 
	 * @return Unique identifier for the prescription, derived from the visit one
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns The type of the medical prescription
	 * 
	 * @return The type of the medical prescription
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns The date when the prescription is released
	 *
	 * @return The date when the prescription is released
	 */
	public Date getPrescription_date() {
		return prescription_date;
	}

	/**
	 * Returns The date when the prescription expires
	 *
	 * @return The date when the prescription expires
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * Returns The identifier of the visit
	 *
	 * @return The identifier of the visit
	 */
	public int getVisit() {
		return visit;
	}

	/**
	 * Returns The prescription form identifier
	 *
	 * @return The prescription form identifier
	 */
	public int getForm() {
		return form;
	}

	/**
	 * Returns a string representation of the prescription
	 *
	 * @return a string representation of the prescription
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Prescription: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("type = ").append(type).append("; ");
		sb.append("prescription date = ").append(prescription_date).append("; ");
		sb.append("deadline = ").append(deadline).append("; ");
		sb.append("visit = ").append(visit).append("; ");
		sb.append("form = ").append(form).append(".");
		
		return sb.toString();
	}
}
