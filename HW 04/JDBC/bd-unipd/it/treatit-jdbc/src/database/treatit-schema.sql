-- User Creation
create user leoforfriendsdb with password 'dbmshome' createdb createrole;


	-- Database Creation
	create database dbms1718 owner leoforfriendsdb encoding = 'UTF8';


		-- Droppping the schema if already exist
		drop schema if exists treatit cascade;

		-- Creation of the schema
		create schema treatit;
		comment on schema treatit is 'Schema for containing the objects of the DBMS project of treatit group';

			-- Patient table
			create type gender1 as enum ('Male','Female');
			create table treatit.Patient 
			(
				fiscal_code varchar(16) primary key,
				name varchar(20) not null,
				surname varchar(20) not null,
				telephone_number varchar(10) not null,
				birth_date date not null,
				place_of_birth varchar(50) not null,
				ULSS_of_origin varchar(50) not null,
				gender gender1 not null
			);

			comment on table treatit.Patient is 'Represents a patient';
			comment on column treatit.Patient.fiscal_code is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Patient.name is 'The name of the patient';
			comment on column treatit.Patient.surname is 'The surname of the patient';
			comment on column treatit.Patient.telephone_number is 'The telephone number of the patient';
			comment on column treatit.Patient.birth_date is 'The date of birth of the patient';
			comment on column treatit.Patient.place_of_birth is 'The place where the patient is born';
			comment on column treatit.Patient.ULSS_of_origin is 'The ULSS where the patient comes from';
			comment on column treatit.Patient.gender is 'The gender of the patient';

			-- Doctor table
			create table treatit.Doctor 
			(
				id varchar(4) primary key,
				name varchar(20) not null,
				surname varchar(20) not null,
				telephone_number varchar(10) not null,
				birth_date date not null,
				place_of_birth varchar(50) not null,
				office_mail varchar(50) not null,
				hashed_password varchar(20) not null,
				actual_patients int not null
			);

			comment on table treatit.Doctor is 'Represents a doctor';
			comment on column treatit.Doctor.id is 'Unique identifier for the doctor';
			comment on column treatit.Doctor.name is 'The name of the doctor';
			comment on column treatit.Doctor.surname is 'The surname of the doctor';
			comment on column treatit.Doctor.telephone_number is 'The telephone number of the doctor';
			comment on column treatit.Doctor.birth_date is 'The date of birth of the doctor';
			comment on column treatit.Doctor.place_of_birth is 'The place of birth of the doctor';
			comment on column treatit.Doctor.office_mail is 'The professional email address of the doctor';
			comment on column treatit.Doctor.hashed_password is 'Doctor’s personal password saved in hashed form for security reasons';
			comment on column treatit.Doctor.actual_patients is 'The number of patients assigned to the doctor';

			-- Patient Email table
			create table treatit.Email_Address 
			(
				email varchar(50) primary key,
				patient varchar(16) not null,
				foreign key (patient) references treatit.Patient(fiscal_code) on delete cascade on update cascade
			);

			comment on table treatit.Email_Address is 'Represents an email address of a patient';
			comment on column treatit.Email_Address.email is 'The email of the patient';
			comment on column treatit.Email_Address.patient is 'Unique alphanumerical string provided by the Country Administration';

			-- Is relative table
			create table treatit.Is_relative
			(
				patient1 varchar(16),
				patient2 varchar(16),
				kinship varchar(50) not null,
				primary key (patient1,patient2),
				foreign key (patient1) references treatit.Patient(fiscal_code),
				foreign key (patient1) references treatit.Patient(fiscal_code)
			);

			comment on table treatit.Is_relative is 'Represents the kinship between two patients';
			comment on column treatit.Is_relative.patient1 is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Is_relative.patient2 is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Is_relative.kinship is 'The degree of relationship connecting the two patients';

			-- Takes care table
			create table treatit.Takes_care
			(
				doctor varchar(4),
				patient varchar(16),
				start_date date not null,
				primary key (doctor,patient),
				foreign key (doctor) references treatit.Doctor(id) on delete cascade on update cascade,
				foreign key (patient) references treatit.Patient(fiscal_code) on delete cascade on update cascade
			);

			comment on table treatit.Takes_care is 'Represents the patients who are taken care by a doctor';
			comment on column treatit.Takes_care.doctor is 'Unique identifier for the doctor';
			comment on column treatit.Takes_care.patient is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Takes_care.start_date is 'The day from which the doctor has started taking care of the patient';

			-- Treatment table
			create table treatit.Treatment
			(
				id varchar(20) primary key,
				name text not null
			);

			comment on table treatit.Treatment is 'Represents a treatment';
			comment on column treatit.Treatment.id is 'Combination of the unique identifier provided by the structure and the structure name';
			comment on column treatit.Treatment.name is 'The name of the treatment';

			-- Structure table
			create table treatit.Structure
			(
				id varchar(10) primary key,
				name varchar(50) not null,
				address varchar(70) not null
			);

			comment on table treatit.Structure is 'Represents a medical structure';
			comment on column treatit.Structure.id is 'Unique identifier of the structure provided by the National System';
			comment on column treatit.Structure.name is 'The name of the structure';
			comment on column treatit.Structure.address is 'The address of the structure';

			-- Undergoes table
			create table treatit.Undergoes
			(
				patient varchar(16),
				treatment varchar(20),
				structure varchar(10),
				treatment_date date not null,
				primary key (patient,treatment,structure),
				foreign key (patient) references treatit.Patient(fiscal_code) on delete cascade on update cascade,
				foreign key (treatment) references treatit.Treatment(id) on delete cascade on update cascade,
				foreign key (structure) references treatit.Structure(id) on delete cascade on update cascade
			);

			comment on table treatit.Undergoes is 'Represents a patient who undergoes a treatment in a certain structure';
			comment on column treatit.Undergoes.patient is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Undergoes.treatment is 'Combination of the unique identifier provided by the structure and the structure name';
			comment on column treatit.Undergoes.structure is 'Unique identifier of the structure provided by the National System';
			comment on column treatit.Undergoes.treatment_date is 'The date on which the patient undergoes the treatment';

			-- Allergy table
			create table treatit.Allergy
			(
				allergen varchar(50) primary key
			);

			comment on table treatit.Allergy is 'Represents an allergy';
			comment on column treatit.Allergy.allergen is 'The name of the substance the patient is allergic to';

			-- Suffers table
			create table treatit.Suffers
			(
				patient varchar(16),
				allergy varchar(50),
				primary key (patient,allergy),
				foreign key (patient) references treatit.Patient(fiscal_code) on update cascade,
				foreign key (allergy) references treatit.Allergy(allergen) on update cascade
			);

			comment on table treatit.Suffers is 'Represents which allergies a patient suffers';
			comment on column treatit.Suffers.patient is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Suffers.allergy is 'The name of the substance the patient is allergic to';

			-- Call table
			create table treatit.Call
			(
				call_number serial primary key
			);

			comment on table treatit.Call is 'Represents the number of times a vaccination has been repeated';
			comment on column treatit.Call.call_number is 'The number of the call';

			-- Vaccination table
			create table treatit.Vaccination
			(
				disease varchar(50) primary key
			);

			comment on table treatit.Vaccination is 'Represents a vaccine';
			comment on column treatit.Vaccination.disease is 'The name of the disease the vaccination is about';

			-- Gets table
			create table treatit.Gets
			(
				patient varchar(16),
				vaccination varchar(50),
				call int,
				vaccination_date date not null,
				deadline date not null,
				primary key (patient,vaccination,call),
				foreign key (patient) references treatit.Patient(fiscal_code) on update cascade,
				foreign key (vaccination) references treatit.Vaccination(disease) on update cascade,
				foreign key (call) references treatit.Call(call_number)
			);

			comment on table treatit.Gets is 'Represents a patient who gets a vaccination in a specific call';
			comment on column treatit.Gets.patient is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Gets.vaccination is 'The name of the disease the vaccination is about';
			comment on column treatit.Gets.call is 'The number of the call';
			comment on column treatit.Gets.vaccination_date is 'The date on which the vaccination was performed';
			comment on column treatit.Gets.deadline is 'The date when the vaccination expires';

			-- Visit table
			create table treatit.Visit
			(
				id serial primary key,
				visit_time timestamp not null,
				patient varchar(16) not null,
				doctor varchar(4) not null,
				foreign key (patient) references treatit.Patient(fiscal_code) on update cascade,
				foreign key (doctor) references treatit.Doctor(id) on update cascade
			);

			comment on table treatit.Visit is 'Represents a visit that a doctor gives to a patient';
			comment on column treatit.Visit.id is 'An increasing number';
			comment on column treatit.Visit.visit_time is 'The timestamp of the visit';
			comment on column treatit.Visit.patient is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Visit.doctor is 'Unique identifier for the doctor';

			-- Disease table
			create table treatit.Disease
			(
				name varchar(50) primary key,
				description text not null
			);

			comment on table treatit.Disease is 'Represents a disease';
			comment on column treatit.Disease.name is 'The name of the disease';
			comment on column treatit.Disease.description is 'The description of the disease';

			-- Disease contraction table
			create table treatit.Disease_contraction
			(
				id varchar(25) primary key,
				pain_scale int check(pain_scale > 0 and pain_scale < 11),
				first_appearance_date date not null,
				end_date date,
				visit int not null,
				disease varchar(50) not null,
				foreign key (visit) references treatit.Visit(id),
				foreign key (disease) references treatit.Disease(name) on update cascade
			);

			comment on table treatit.Disease_contraction is 'Represents the act of getting a disease';
			comment on column treatit.Disease_contraction.id is 'Combination of patient ID, disease name and a counter';
			comment on column treatit.Disease_contraction.pain_scale is 'Subjective number from 1 to 10 with which the patient describes how much he/she is suffering';
			comment on column treatit.Disease_contraction.first_appearance_date is 'Date of the day in which the first symptom of the disease occurred';
			comment on column treatit.Disease_contraction.end_date is 'The date when the disease ended';
			comment on column treatit.Disease_contraction.visit is 'The identifier of the visit';
			comment on column treatit.Disease_contraction.disease is 'The name of the disease';

			-- Suspects table
			create table treatit.Suspects
			(
				disease varchar(50),
				visit int,
				primary key (disease,visit),
				foreign key (disease) references treatit.Disease(name) on update cascade,
				foreign key (visit) references treatit.Visit(id)
			);

			comment on table treatit.Suspects is 'Represents which disease a doctor suspects that a patient has';
			comment on column treatit.Suspects.disease is 'The name of the disease';
			comment on column treatit.Suspects.visit is 'The identifier of the visit';

			-- Exam type table
			create table treatit.Exam_type
			(
				name varchar(50) primary key
			);

			comment on table treatit.Exam_type is 'Represents a type of exam';
			comment on column treatit.Exam_type.name is 'The specific name of the exam typology';

			-- Is about table
			create table treatit.Is_about
			(
				disease varchar(50),
				exam_type varchar(50),
				primary key (disease,exam_type),
				foreign key (disease) references treatit.Disease(name) on update cascade,
				foreign key (exam_type) references treatit.Exam_type(name) on update cascade
			);

			comment on table treatit.Is_about is 'Represents for which disease is about the type of the exam';
			comment on column treatit.Is_about.disease is 'The name of the disease';
			comment on column treatit.Is_about.exam_type is 'The specific name of the exam typology';

			-- Exam table
			create table treatit.Exam
			(
				exam_code varchar(10) primary key,
				structure varchar(10),
				patient varchar(16),
				exam_type varchar(50),
				exam_date date,
				foreign key (structure) references treatit.Structure(id) on update cascade,
				foreign key (patient) references treatit.Patient(fiscal_code) on update cascade,
				foreign key (exam_type) references treatit.Exam_type(name) on update cascade
			);

			comment on table treatit.Exam is 'Represents the act of getting an exam';
			comment on column treatit.Exam.exam_code is 'Unique identifier provided by the National System';
			comment on column treatit.Exam.structure is 'Unique identifier pf the structure provided by the National System';
			comment on column treatit.Exam.patient is 'Unique alphanumerical string provided by the Country Administration';
			comment on column treatit.Exam.exam_type is 'The specific name of the exam typology';
			comment on column treatit.Exam.exam_date is 'The date in which the exam was performed';

			-- Form table
			create table treatit.Form
			(
				id serial primary key,
				name varchar(50) not null,
				description text not null
			);

			comment on table treatit.Form is 'Represents a form used by the doctors';
			comment on column treatit.Form.id is 'Progressive number identifying the form for a specific exam result, medical history or document';
			comment on column treatit.Form.name is 'The name of the form';
			comment on column treatit.Form.description is 'A brief description of what the form describes';

			-- Field table
			create table treatit.Field
			(
				id serial primary key,
				name varchar(50) not null,
				field_value text not null,
				form int not null,
				foreign key (form) references treatit.Form(id) on update cascade
			);

			comment on table treatit.Field is 'Represents a field of a specific form';
			comment on column treatit.Field.id is 'Progressive number identifying the field for a specific form';
			comment on column treatit.Field.name is 'The name of the field';
			comment on column treatit.Field.field_value is 'The value of the field';
			comment on column treatit.Field.form is 'The form identifier';

			-- Medical History table
			create table treatit.Medical_history
			(
				id varchar(50) primary key,
				visit int not null,
				form int not null,
				foreign key (form) references treatit.Form(id) on update cascade,
				foreign key (visit) references treatit.Visit(id) on update cascade
			);

			comment on table treatit.Medical_history is 'Represents the medical history of a patient';
			comment on column treatit.Medical_history.id is 'Unique identifier computed by combining the Fiscal Code of the patient and an incremental number, to take into account of previous versions';
			comment on column treatit.Medical_history.visit is 'The identifier of the visit';
			comment on column treatit.Medical_history.form is 'The medical history form identifier';

			-- Exemption table
			create table treatit.Exemption
			(
				id varchar(25) primary key,
				activity varchar(50) not null,
				reason text not null,
				exemption_date date not null,
				deadline date not null,
				visit int not null,
				form int not null,
				foreign key (form) references treatit.Form(id) on update cascade,
				foreign key (visit) references treatit.Visit(id) on update cascade
			);

			comment on table treatit.Exemption is 'Represents an exemption gived by a doctor in a visit';
			comment on column treatit.Exemption.id is 'Unique identifier for the exemption, derived from the visit one';
			comment on column treatit.Exemption.activity is 'The activity targeted by the exemption';
			comment on column treatit.Exemption.reason is 'The motivation for which the exemption is given';
			comment on column treatit.Exemption.exemption_date is 'The date when the exemption is released';
			comment on column treatit.Exemption.deadline is 'The date when the exemption expires';
			comment on column treatit.Exemption.visit is 'The identifier of the visit';
			comment on column treatit.Exemption.form is 'The exemption form identifier';

			-- Certification table
			create table treatit.Certification
			(
				id varchar(25) primary key,
				certified_condition varchar(100) not null,
				certification_date date not null,
				deadline date not null,
				visit int not null,
				form int not null,
				foreign key (form) references treatit.Form(id) on update cascade,
				foreign key (visit) references treatit.Visit(id) on update cascade
			);

			comment on table treatit.Certification is 'Represents a certification gived by a doctor in a visit';
			comment on column treatit.Certification.id is 'Unique identifier for the certificate, derived from the visit one';
			comment on column treatit.Certification.certified_condition is 'The condition for which the certificate is released';
			comment on column treatit.Certification.certification_date is 'The date when the certificate is released';
			comment on column treatit.Certification.deadline is 'The date when the certificate expires';
			comment on column treatit.Certification.visit is 'The identifier of the visit';
			comment on column treatit.Certification.form is 'The certification form identifier';

			-- Prescription table
			create table treatit.Prescription
			(
				id varchar(25) primary key,
				type varchar(50) not null,
				prescription_date date not null,
				deadline date not null,
				visit int not null,
				form int not null,
				foreign key (form) references treatit.Form(id) on update cascade,
				foreign key (visit) references treatit.Visit(id) on update cascade
			);

			comment on table treatit.Prescription is 'Represents a prescription gived by a doctor in a visit';
			comment on column treatit.Prescription.id is 'Unique identifier for the prescription, derived from the visit one';
			comment on column treatit.Prescription.type is 'The type of the medical prescription';
			comment on column treatit.Prescription.prescription_date is 'The date when the prescription is released';
			comment on column treatit.Prescription.deadline is 'The date when the prescription expires';
			comment on column treatit.Prescription.visit is 'The identifier of the visit';
			comment on column treatit.Prescription.form is 'The prescription form identifier';

			-- Drug table
			create table treatit.Drug
			(
				name varchar(50) primary key,
				active_principle varchar(50) not null
			);

			comment on table treatit.Drug is 'Represents a drug';
			comment on column treatit.Drug.name is 'The commercial name of the drug';
			comment on column treatit.Drug.active_principle is 'The active principle of the drug';

			-- Authorizes table
			create table treatit.Authorizes
			(
				prescription varchar(25),
				drug varchar(50),
				cause text not null,
				dosage text not null,
				primary key (prescription,drug),
				foreign key (prescription) references treatit.Prescription(id) on update cascade,
				foreign key (drug) references treatit.Drug(name) on update cascade
			);

			comment on table treatit.Authorizes is 'Represents the authorization gived by a doctor to a patient to assume a drug';
			comment on column treatit.Authorizes.prescription is 'Identifier of the prescription';
			comment on column treatit.Authorizes.drug is 'The commercial name of the drug';
			comment on column treatit.Authorizes.cause is 'The reason why the drug was prescribed';
			comment on column treatit.Authorizes.dosage is 'The dosage of the drug to be taken by the patient';

			-- Prescribes table
			create table treatit.Prescribes
			(
				prescription varchar(25),
				exam_type varchar(50),
				cause text not null,
				primary key (prescription,exam_type),
				foreign key (prescription) references treatit.Prescription(id) on update cascade,
				foreign key (exam_type) references treatit.Exam_type(name) on update cascade
			);

			comment on table treatit.Prescribes is 'Represents the type of exam that a doctor prescribes to a patient to do';
			comment on column treatit.Prescribes.prescription is 'Identifier of the prescription';
			comment on column treatit.Prescribes.exam_type is 'The specific name of the exam typology';
			comment on column treatit.Prescribes.cause is 'The reason why the exam object of the prescription was prescribed';

			-- Comes after table
			create table treatit.Comes_after
			(
				exam varchar(10) primary key,
				prescription varchar(25) not null,
				foreign key (exam) references treatit.Exam(exam_code) on update cascade,
				foreign key (prescription) references treatit.Prescription(id) on update cascade
			);

			comment on table treatit.Comes_after is 'Represents an exam that comes after a doctor prescription';
			comment on column treatit.Comes_after.exam is 'Unique identifier for the exam provided by the National System';
			comment on column treatit.Comes_after.prescription is 'The identifier of the prescription';

			-- Result table
			create table treatit.Result
			(
				exam varchar(10) primary key,
				result_date date not null,
				form int not null,
				foreign key (exam) references treatit.Exam(exam_code) on update cascade,
				foreign key (form) references treatit.Form(id) on update cascade
			);

			comment on table treatit.Result is 'Represents the result of an exam';
			comment on column treatit.Result.exam is 'Unique identifier for the exam provided by the National System';
			comment on column treatit.Result.result_date is 'The date in which the result for the exam is delivered to the doctor';
			comment on column treatit.Result.form is 'The identifier of the form';