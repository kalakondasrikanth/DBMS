package it.unipd.dei.bding.resource;


/**
 * Represents the data about the number of times a vaccination has been repeated.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class Call
{
	/**
	 * The number of the call
	 */
	private final int call_number;

	/**
	 * Creates a new call
	 *
	 * @param call_number
	 *            The number of the call
	 */
	public Call(final int call_number)
	{
		this.call_number = call_number;
	}

	/**
	 * Returns The number of the call
	 *
	 * @return The number of the call
	 */
	public int getCall_number() {
		return call_number;
	}

	/**
	 * Returns a string representation of the call
	 *
	 * @return a string representation of the call
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Call: ");

		sb.append("call number = ").append(call_number).append(".");
		
		return sb.toString();
	}
}
