package it.unipd.dei.bding.resource;


/**
 * Represents the data about the medical history of a patient.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class MedicalHistory
{
	/**
	 * Unique identifier computed by combining the Fiscal Code of the patient and an incremental number, to take into account of previous versions
	 */
	private final String id;

	/**
	 * The identifier of the visit
	 */
	private final int visit;

	/**
	 * The medical history form identifier
	 */
	private final int form;

	/**
	 * Creates a new medical history
	 *
	 * @param id
	 *            Unique identifier computed by combining the Fiscal Code of the patient and an incremental number, to take into account of previous versions
	 * @param visit
	 * 	          The identifier of the visit
	 * @param form
	 *            The medical history form identifier
	 */
	public MedicalHistory(final String id, final int visit, final int form)
	{
		this.id = id;
		this.visit = visit;
		this.form = form;
	}

	/**
	 * Returns Unique identifier computed by combining the Fiscal Code of the patient and an incremental number, to take into account of previous versions
	 * 
	 * @return Unique identifier computed by combining the Fiscal Code of the patient and an incremental number, to take into account of previous versions
	 */
	public String getId() {
		return id;
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
	 * Returns The medical history form identifier
	 * 
	 * @return The medical history form identifier
	 */
	public int getForm() {
		return form;
	}

	/**
	 * Returns a string representation of the medical history of a patient
	 *
	 * @return a string representation of the medical history of a patient
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Medical history: ");
		
		sb.append("id = ").append(id).append("; ");
		sb.append("visit = ").append(visit).append("; ");
		sb.append("form = ").append(form).append(".");
		
		return sb.toString();
	}
}
