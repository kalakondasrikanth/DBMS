package it.unipd.dei.bding.resource;


/**
 * Represents the data about the authorization gived by a doctor to a patient to assume a drug.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Authorizes
{
	/**
	 * Identifier of the prescription
	 */
	private final String prescription;

	/**
	 * The commercial name of the drug
	 */
	private final String drug;

	/**
	 * The reason why the drug was prescribed
	 */
	private final String cause;

	/**
	 * The dosage of the drug to be taken by the patient
	 */
	private final String dosage;

	/**
	 * Creates a new authorization
	 *
	 * @param prescription
	 *            Identifier of the prescription
	 * @param drug
	 *            The commercial name of the drug
	 * @param cause
	 *            The reason why the drug was prescribed
	 * @param dosage
	 *            The dosage of the drug to be taken by the patient
	 */
	public Authorizes(final String prescription, final String drug, final String cause, final String dosage)
	{
		this.prescription = prescription;
		this.drug = drug;
		this.cause = cause;
		this.dosage = dosage;
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
	 * Returns The commercial name of the drug
	 * 
	 * @return The commercial name of the drug
	 */
	public String getDrug() {
		return drug;
	}

	/**
	 * Returns The reason why the drug was prescribed
	 * 
	 * @return The reason why the drug was prescribed
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * Returns The dosage of the drug to be taken by the patient
	 *
	 * @return The dosage of the drug to be taken by the patient
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * Returns a string representation of the authorization
	 *
	 * @return a string representation of the authorization
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Authorization: ");
		
		sb.append("prescription = ").append(prescription).append("; ");
		sb.append("drug = ").append(drug).append("; ");
		sb.append("cause = ").append(cause).append("; ");
		sb.append("dosage = ").append(dosage).append(".");
		
		return sb.toString();
	}
}
