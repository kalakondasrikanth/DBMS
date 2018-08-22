package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about a certification.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Certification
{
	/**
	 * Unique identifier for the certificate, derived from the visit one
	 */
	private final String id;

	/**
	 * The condition for which the certificate is released
	 */
	private final String certified_condition;

	/**
	 * The date when the certificate is released
	 */
	private final Date certification_date;

	/**
	 * The date when the certificate expires
	 */
	private final Date deadline;

	/**
	 * The identifier of the visit
	 */
	private final int visit;

	/**
	 * The certification form identifier
	 */
	private final int form;

	/**
	 * Creates a new certification
	 *
	 * @param id
	 *            Unique identifier for the certificate, derived from the visit one
	 * @param certified_condition
	 *            The condition for which the certificate is released
	 * @param certification_date
	 *            The date when the certificate is released
	 * @param deadline
	 *            The date when the certificate expires
	 * @param visit
	 *            The identifier of the visit
	 * @param form
	 *            The certification form identifier
	 */
	public Certification(final String id, final String certified_condition, final Date certification_date, final Date deadline, final int visit, final int form)
	{
		this.id = id;
		this.certified_condition = certified_condition;
		this.certification_date = certification_date;
		this.deadline = deadline;
		this.visit = visit;
		this.form = form;
	}

	/**
	 * Returns Unique identifier for the certificate, derived from the visit one
	 * 
	 * @return Unique identifier for the certificate, derived from the visit one
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns The condition for which the certificate is released
	 * 
	 * @return The condition for which the certificate is released
	 */
	public String getCertified_condition() {
		return certified_condition;
	}

	/**
	 * Returns The date when the certificate is released
	 * 
	 * @return The date when the certificate is released
	 */
	public Date getCertification_date() {
		return certification_date;
	}

	/**
	 * Returns The date when the certificate expires
	 *
	 * @return The date when the certificate expires
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
	 * Returns The certification form identifier
	 *
	 * @return The certification form identifier
	 */
	public int getForm() {
		return form;
	}

	/**
	 * Returns a string representation of the certification
	 *
	 * @return a string representation of the certification
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Certification: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("certified condition = ").append(certified_condition).append("; ");
		sb.append("certification date = ").append(certification_date).append("; ");
		sb.append("deadline = ").append(deadline).append("; ");
		sb.append("visit = ").append(visit).append("; ");
		sb.append("form = ").append(form).append(".");
		
		return sb.toString();
	}
}
