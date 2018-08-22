import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
* Lists all the authors in the database
*
* @author Maria Maistro
* @version 1.00
*/
public class readSpecialNeeds {
/**
* The JDBC driver to be used
*/
private static final String DRIVER = "org.postgresql.Driver";
/**
* The URL of the database to be accessed
*/
private static final String DATABASE = "jdbc:postgresql://imspgsql.dei.unipd.it/ecir2016";
/**
* The username for accessing the database
*/
private static final String USER = "";
/**
* The password for accessing the database
Pagina [14] di [17]
*/
private static final String PASSWORD = "";
/**
* The SQL statement to be executed
*/
private static final String SQL = "SELECT P.email, firstname, lastname,specialneedsid, other FROM require AS R INNER JOIN participant AS P ON R.email = P.email
WHERE specialneedsid = 'OtherSpecial' OR specialneedsid = 'Other' ORDER BY lastname,
firstname;";
/**
* List the special need of the participants
*
* @param args
* command-line arguments (not used).
*/
public static void main(String[] args) {
// the connection to the DBMS
	Connection con = null;
// the statement to be executed
	Statement stmt = null;
// the results of the statement execution
	ResultSet rs = null;
// start time of a statement
	long start;
// end time of a statement
	long end;
// "data structures" for the data to be read from the database
// the data about the participant
	String email = null;
	String firstName = null;
	String lastName = null;
	String specialNeedsId = null;
	String otherText = null;
	try {
// register the JDBC driver
		Class.forName(DRIVER);
		System.out.printf("Driver %s successfully registered.%n", DRIVER);
	} catch (ClassNotFoundException e) {
		System.out.printf(
			"Driver %s not found: %s.%n", DRIVER, e.getMessage());
// terminate with a generic error code
		System.exit(-1);
	}
	try {
// connect to the database
		start = System.currentTimeMillis();
		con = DriverManager.getConnection(DATABASE, USER, PASSWORD);
		end = System.currentTimeMillis();
		System.out.printf(
			"Connection to database %s successfully established in %,d milliseconds.%n",
			DATABASE, end-start);
// create the statement to execute the query
		start = System.currentTimeMillis();
		stmt = con.createStatement();
		end = System.currentTimeMillis();
		System.out.printf(
			"Statement successfully created in %,d milliseconds.%n",
			end-start);
// execute the query
		start = System.currentTimeMillis();
		rs = stmt.executeQuery(SQL);
		end = System.currentTimeMillis();
		System.out
		.printf("Query %s successfully executed %,d milliseconds.%n",
			SQL, end - start);
		System.out
		.printf("Query results:%n");
// cycle on the query results and print them
		while (rs.next()) {
// read the email of a participant
			email = rs.getString("email");
// read the first name of a participant
			firstName = rs.getString("firstname");
// read the last name of a participant
			lastName = rs.getString("lastname");
// read the special need id
			specialNeedsId = rs.getString("specialneedsid");
// read the text other
			otherText = rs.getString("other");
			System.out.printf("- %s, %s, %s, %s, %s%n",
				email, firstName, lastName, specialNeedsId,
				otherText);
		}
	} catch (SQLException e) {
		System.out.printf("Database access error:%n");
// cycle in the exception chain
		while (e != null) {
			System.out.printf("- Message: %s%n", e.getMessage());
			System.out.printf("- SQL status code: %s%n", e.getSQLState());
			System.out.printf("- SQL error code: %s%n", e.getErrorCode());
			System.out.printf("%n");
			e = e.getNextException();
		}
	} finally {
		try {
// close the used resources
			if (rs != null) {
				start = System.currentTimeMillis();
				rs.close();
				end = System.currentTimeMillis();
				System.out
				.printf("Result set successfully closed in %,d milliseconds.%n",
					end-start);
			}
			if (stmt != null) {
				start = System.currentTimeMillis();
				stmt.close();
				end = System.currentTimeMillis();
				System.out
				.printf("Statement successfully closed in %,d milliseconds.%n",
					end-start);
			}
			if (con != null) {
				start = System.currentTimeMillis();
				con.close();
				end = System.currentTimeMillis();
				System.out
				.printf("Connection successfully closed in %,d milliseconds.%n",
					end-start);
			}
			System.out.printf("Resources successfully released.%n");
		} catch (SQLException e) {
			System.out.printf("Error while releasing resources:%n");
// cycle in the exception chain
			while (e != null) {
				System.out.printf("- Message: %s%n", e.getMessage());
				System.out.printf("- SQL status code: %s%n",
					e.getSQLState());
				System.out.printf("- SQL error code: %s%n",
					e.getErrorCode());
				System.out.printf("%n");
				e = e.getNextException();
			}
		} finally {
// release resources to the garbage collector
			rs = null;
			stmt = null;
			con = null;
			System.out.printf("Resources released to the garbage collector.%n");
			}
		}
		System.out.printf("Program end.%n");
	}
}