package it.unipd.dei.bding.resource;


import java.sql.Date;

/**
 * Represents the data about the act of getting a disease.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class DiseaseContraction
{
	/**
	 * Combination of patient ID, disease name and a counter
	 */
	private final String id;

	/**
	 * Subjective number from 1 to 10 with which the patient describes how much he/she is suffering
	 */
	private final int pain_scale;

	/**
	 * Date of the day in which the first symptom of the disease occurred
	 */
	private final Date first_appearance_date;

	/**
	 * The date when the disease ended
	 */
	private final Date end_date;

	/**
	 * The identifier of the visit
	 */
	private final int visit;

	/**
	 * The name of the disease
	 */
	private final String disease;

	/**
	 * Creates a new act of getting a disease
	 *
	 * @param id
	 *            Combination of patient ID, disease name and a counter
	 * @param pain_scale
	 *            Subjective number from 1 to 10 with which the patient describes how much he/she is suffering
	 * @param first_appearance_date
	 *            Date of the day in which the first symptom of the disease occurred
	 * @param end_date
	 *            The date when the disease ended
	 * @param visit
	 *            The identifier of the visit
	 * @param disease
	 *            The name of the disease
	 */
	public DiseaseContraction(final String id, final int pain_scale, final Date first_appearance_date, final Date end_date, final int visit, final String disease)
	{
		this.id = id;
		this.pain_scale = pain_scale;
		this.first_appearance_date = first_appearance_date;
		this.end_date = end_date;
		this.visit = visit;
		this.disease = disease;
	}

	/**
	 * Returns Combination of patient ID, disease name and a counter
	 * 
	 * @return Combination of patient ID, disease name and a counter
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns Subjective number from 1 to 10 with which the patient describes how much he/she is suffering
	 * 
	 * @return Subjective number from 1 to 10 with which the patient describes how much he/she is suffering
	 */
	public int getPain_scale() {
		return pain_scale;
	}

	/**
	 * Returns Date of the day in which the first symptom of the disease occurred
	 * 
	 * @return Date of the day in which the first symptom of the disease occurred
	 */
	public Date getFirst_appearance_date() {
		return first_appearance_date;
	}

	/**
	 * Returns The date when the disease ended
	 * 
	 * @return The date when the disease ended
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * Returns The identifier of the visit
	 *
	 * @return The identifier of the visit
	 */
	public int getVisit() {	return visit; }

	/**
	 * Returns The name of the disease
	 *
	 * @return The name of the disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Returns a string representation of the act of getting a disease
	 *
	 * @return a string representation of the act of getting a disease
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Disease contraction: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("pain scale = ").append(pain_scale).append("; ");
		sb.append("first appearance date = ").append(first_appearance_date).append("; ");
		sb.append("end date = ").append(end_date).append("; ");
		sb.append("visit = ").append(visit).append("; ");
		sb.append("disease = ").append(disease).append(".");
		
		return sb.toString();
	}
}
