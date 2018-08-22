package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about an exemption.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Exemption
{
	/**
	 * Unique identifier for the exemption, derived from the visit one
	 */
	private final String id;

	/**
	 * The activity targeted by the exemption
	 */
	private final String activity;

	/**
	 * The motivation for which the exemption is given
	 */
	private final String reason;

	/**
	 * The date when the exemption is released
	 */
	private final Date exemption_date;

	/**
	 * The date when the exemption expires
	 */
	private final Date deadline;

	/**
	 * The identifier of the visit
	 */
	private final int visit;

	/**
	 * The exemption form identifier
	 */
	private final int form;

	/**
	 * Creates a new exemption
	 *
	 * @param id
	 *            Unique identifier for the exemption, derived from the visit one
	 * @param activity
	 *            The activity targeted by the exemption
	 * @param reason
	 *            The motivation for which the exemption is given
	 * @param exemption_date
	 *            The date when the exemption is released
	 * @param deadline
	 *            The date when the exemption expires
	 * @param visit
	 *            The identifier of the visit
	 * @param form
	 *            The exemption form identifier
	 */
	public Exemption(final String id, final String activity, final String reason, final Date exemption_date, final Date deadline, final int visit, final int form)
	{
		this.id = id;
		this.activity = activity;
		this.reason = reason;
		this.exemption_date = exemption_date;
		this.deadline = deadline;
		this.visit = visit;
		this.form = form;
	}

	/**
	 * Returns Unique identifier for the exemption, derived from the visit one
	 * 
	 * @return Unique identifier for the exemption, derived from the visit one
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns The activity targeted by the exemption
	 * 
	 * @return The activity targeted by the exemption
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * Returns The motivation for which the exemption is given
	 * 
	 * @return The motivation for which the exemption is given
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Returns The date when the exemption is released
	 * 
	 * @return The date when the exemption is released
	 */
	public Date getExemption_date() {
		return exemption_date;
	}

	/**
	 * Returns The date when the exemption expires
	 *
	 * @return The date when the exemption expires
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
	 * Returns The exemption form identifier
	 *
	 * @return The exemption form identifier
	 */
	public int getForm() {
		return form;
	}

	/**
	 * Returns a string representation of the exemption
	 *
	 * @return a string representation of the exemption
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Exemption: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("activity = ").append(activity).append("; ");
		sb.append("reason = ").append(reason).append("; ");
		sb.append("exemption date = ").append(exemption_date).append("; ");
		sb.append("deadline = ").append(deadline).append("; ");
		sb.append("visit = ").append(visit).append("; ");
		sb.append("form = ").append(form).append(".");
		
		return sb.toString();
	}
}
