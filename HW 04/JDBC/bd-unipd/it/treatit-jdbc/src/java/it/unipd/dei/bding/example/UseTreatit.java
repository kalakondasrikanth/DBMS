package it.unipd.dei.bding.example;

import it.unipd.dei.bding.database.*;
import it.unipd.dei.bding.resource.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Date;
import java.util.List;

/**
 * Testing the treatit database.
 * 
 * @author leoforfriendsDB
 * @version 1.00
 */
public class UseTreatit
{

	public static void main(String[] args)
    {
		// create a pool of connections
		PoolProperties p = new PoolProperties();
		
		// setup connection properties
		p.setUrl("jdbc:postgresql://localhost/dbms1718");
		p.setDriverClassName("org.postgresql.Driver");
		p.setUsername("leoforfriendsdb");
		p.setPassword("dbmshome");
        /*p.setUrl("jdbc:postgresql://dbstud.dei.unipd.it:5434/dbms1718");
        p.setDriverClassName("org.postgresql.Driver");
        p.setUsername("webdb");
        p.setPassword("webdb");*/
		
		// setup the size of the pool
		p.setInitialSize(1);
		p.setMaxActive(2);
		p.setMaxIdle(2);
		p.setMinIdle(1);
		
		// setup how and when to test that a connection is still working
		p.setValidationQuery("SELECT 1");
		p.setTestOnBorrow(true);
		p.setTestOnReturn(false);
		p.setTestWhileIdle(false);

		// create a datasource based on that pool
		DataSource datasource = new DataSource();
		datasource.setPoolProperties(p);

		// using classes for querying the database
        try
        {

            // Search all the diseases that a patient contracted by his/her fiscal code
            try
            {
                // searches all the diseases that a patient contracted by his/her fiscal code
                SearchDiseaseByFiscalCodeDatabase di = new SearchDiseaseByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S");
                di.searchExamByFiscalCode();
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the diseases of this patient: %s%n", e.getMessage());
            }


            // Search all the exams that a patient got by his/her fiscal code
            try
            {
                // searches all the exams that a patient got by his/her fiscal code
                SearchExamByFiscalCodeDatabase ex = new SearchExamByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S");
                ex.searchExamByFiscalCode();
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the exams of this patient: %s%n", e.getMessage());
            }


            // Search all the fields associated to a form which corresponds to the result of a desired exam by its exam code
            try
            {
                // searches all the fields associated to a form which corresponds to the result of a desired exam by its exam code
                SearchFieldByExamTypeDatabase f = new SearchFieldByExamTypeDatabase(datasource.getConnection(), "TAC111");
                f.searchFieldByExamType();
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the fields of this Exam: %s%n", e.getMessage());
            }


            // Search all the medical histories that a patient got by his/her fiscal code
            try
            {
                // searches all the medical histories that a patient got by his/her fiscal code
                SearchMedicalHistoryByFiscalCodeDatabase m = new SearchMedicalHistoryByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S");
                m.searchMedicalHistoryByFiscalCode();
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the medical histories of this patient: %s%n", e.getMessage());
            }


            // Search all the vaccinations that a patient got by his/her fiscal code
            try
            {
                // searches all the vaccinations that a patient got by his/her fiscal code
                SearchCertificationByFiscalCodeDatabase c = new SearchCertificationByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S");
                c.searchCertificationByFiscalCode();
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the certifications of this patient: %s%n", e.getMessage());
            }


            // Search all the vaccinations that a patient got by his/her fiscal code
            try
            {
                // searches all the vaccinations that a patient got by his/her fiscal code
                List<Gets> vaccinations = new SearchVaccinationByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S").searchVaccinationByFiscalCode();

                // printing the results
                System.out.printf("%nVaccinations successfully searched. Found Vaccinations:%n");
                System.out.printf("- %-15s %-5s %-20s %s%n", "Vaccination", "Call", "Vaccination date", "Deadline");
                for (Gets e : vaccinations)
                {
                    System.out.printf("- %-15s %-5s %-20s %s%n", e.getVaccination(), e.getCall(), e.getVaccination_date(), e.getDeadline());
                }
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the vaccinations of this patient: %s%n", e.getMessage());
            }


            // Search email addresses of a patient by his/her fiscal code
            try
            {
                // searches email addresses of a patient by his/her fiscal code
                List<EmailAddress> emailAddresses = new SearchEmailAddressByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S").searchEmailAddressByFiscalCode();

                // printing the results
                System.out.printf("%nEmail addresses successfully searched. Found email addresses:%n");
                System.out.printf("- %s%n", "Email Address");
                for (EmailAddress e : emailAddresses)
                {
                    System.out.printf("- %s%n", e.getEmail());
                }
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the email addresses of this patient: %s%n", e.getMessage());
            }


            // Search visit ids of a patient by his/her fiscal code
            try
            {
                // searches visit ids of a patient by his/her fiscal code
                List<Visit> visits = new SearchVisitByFiscalCodeDatabase(datasource.getConnection(), "ASSMRA85T10A569S").searchVisitByFiscalCode();

                // printing the results
                System.out.printf("%nVisit ids successfully searched. Found visit ids:%n");
                System.out.printf("- %-10s %s%n", "Visit id", "Visit time");
                for (Visit v : visits)
                {
                    System.out.printf("- %-10s %s%n", v.getId(), v.getVisit_time());
                }
            }
            catch (Exception e)
            {
                System.out.printf("Unable to search the visit ids of this patient: %s%n", e.getMessage());
            }


            // insertion of data in the database

            // Adds a new doctor
            try
            {
                Date birthDate = new Date(70, 3, 16);
                Doctor doctor = new Doctor("1024", "Augusto",
                    "Rossi", "0445368596",
                    birthDate, "Bassano del Grappa",
                    "augusto.rossi@gmail.com", "qwerty",
                    0);

                // creates a new object for accessing the database and stores the doctor
                new CreateDoctorDatabase(datasource.getConnection(), doctor).createDoctor();

                // if the insert is successfully done then prints the new added row values
                System.out.printf("%nNew doctor successfully created.%n%s%n", doctor.toString());
            }
            catch (Exception e)
            {
                System.out.printf("Unable to add the doctor: %s%n", e.getMessage());
            }


            // Adds a new patient
            try
            {
                Date birthDate = new Date(93, 5, 25);
                Patient patient = new Patient("ANHMR93T10B5679I", "Anita",
                    "Moratti", "0444368336", birthDate,
                    "Vicenza", "ULSS 4",
                    "Female");

                // creates a new object for accessing the database and stores the patient
                new CreatePatientDatabase(datasource.getConnection(), patient).createPatient();

                // if the insert is successfully done then prints the new added row values
                System.out.printf("%nNew patient successfully created.%n%s%n", patient.toString());
            }
            catch (Exception e)
            {
                System.out.printf("Unable to add the patient: %s%n", e.getMessage());
            }


            // A doctor takes care a patient
            try
            {

                Date startDate = new Date(117, 5, 25);
                TakesCare takesCare = new TakesCare("1024", "ANHMR93T10B5679I", startDate);

                // A doctor takes care the patient
                new CreateTakesCareDatabase(datasource.getConnection(), takesCare).createTakesCare();

                // if the insert is successfully done then prints the new added row values
                System.out.printf("%nA doctor successfully takes care the patient.%n%s%n", takesCare.toString());
            }
            catch (Exception e)
            {
                System.out.printf("A doctor is unable to take care the patient: %s%n", e.getMessage());
            }
        }
        finally
        {
            //close the datasource
            datasource.close();
        }

	}
}
