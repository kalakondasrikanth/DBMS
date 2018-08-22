package it.unipd.dei.bding.resource;

import java.sql.Date;

/**
 * Represents the data about a patient who undergoes a treatment in a certain structure.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Undergoes
{
	/**
	 * Unique alphanumerical string provided by the Country Administration
	 */
	private final String patient;

	/**
	 * Combination of the unique identifier provided by the structure and the structure name
	 */
	private final String treatment;

	/**
	 * Unique identifier of the structure provided by the National System
	 */
	private final String structure;

	/**
	 * The date on which the patient undergoes the treatment
	 */
	private final Date treatment_date;

	/**
	 * Creates a new patient who undergoes the treatment
	 *
	 * @param patient
	 *            Unique alphanumerical string provided by the Country Administration
	 * @param treatment
	 *            Combination of the unique identifier provided by the structure and the structure name
	 * @param structure
	 *            Unique identifier of the structure provided by the National System
	 * @param treatment_date
	 *            The date on which the patient undergoes the treatment
	 */
	public Undergoes(final String patient, final String treatment, final String structure, final Date treatment_date)
	{
		this.patient = patient;
		this.treatment = treatment;
		this.structure = structure;
		this.treatment_date = treatment_date;
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
	 * Returns Combination of the unique identifier provided by the structure and the structure name
	 * 
	 * @return Combination of the unique identifier provided by the structure and the structure name
	 */
	public String getTreatment() {
		return treatment;
	}

	/**
	 * Returns Unique identifier of the structure provided by the National System
	 * 
	 * @return Unique identifier of the structure provided by the National System
	 */
	public String getStructure() {
		return structure;
	}

	/**
	 * Returns The date on which the patient undergoes the treatment
	 *
	 * @return The date on which the patient undergoes the treatment
	 */
	public Date getTreatment_date() {
		return treatment_date;
	}

	/**
	 * Returns a string representation of the patient who undergoes the treatment
	 *
	 * @return a string representation of the patient who undergoes the treatment
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Undergoes: ");
		
		sb.append("patient = ").append(patient).append("; ");
		sb.append("treatment = ").append(treatment).append("; ");
		sb.append("structure = ").append(structure).append("; ");
		sb.append("treatment date = ").append(treatment_date).append(".");
		
		return sb.toString();
	}
}
