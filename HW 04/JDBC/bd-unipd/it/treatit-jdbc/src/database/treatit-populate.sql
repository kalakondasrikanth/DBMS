-- Populating Patient table
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('ASSMRA85T10A569S','AARIO','ROSSI','394839488','1985-11-10','SAN GIULIANO TERME','ULSS 1','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('BSSMRA85T10A568S','BARIO','BRUNI','384839488','1985-12-10','CAORLE','ULSS 2','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('CSSMRA85T10A597S','CARIO','VERDI','374839488','1985-10-10','SOTTOMARINA','ULSS 3','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('DSSMRA85T10A566S','DARIO','ROSSI','364839488','1985-12-10','BRINDISI','ULSS 3','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('ESSMRA85T10A565S','EARIO','BIANCHI','354839498','1985-12-10','SAN GIULIANO TERME','ULSS 5','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('FSSMRA85T10A564S','FARIA','BIANCHI','344839488','1985-12-16','SAN GIULIANO TERME','ULSS 3','Female');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('DSSMRA85T10A553S','DARIO','BRUNI','334839488','1985-08-10','SAN GIULIANO TERME','ULSS 3','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('HSSMRA85T10A562S','HARIO','NERI','324839488','1985-12-01','SAN GIULIANO TERME','ULSS 6','Male');
insert into treatit.Patient (fiscal_code, name, surname, telephone_number, birth_date, place_of_birth, ULSS_of_origin, gender) 
	values ('ISSMRA85T10A561S','ILARIA','ROSSI','314839488','1985-02-10','SAN GIULIANO TERME','ULSS 3','Female');

-- Populating Doctor table
insert into treatit.Doctor (id, name, surname, telephone_number, birth_date, place_of_birth, office_mail, hashed_password, actual_patients) 
	values ('0001','Giuseppe','Casari','394859424','1982-11-28','NOALE','g.casari@gmail.com','-946852072',0);
insert into treatit.Doctor (id, name, surname, telephone_number, birth_date, place_of_birth, office_mail, hashed_password, actual_patients) 
	values ('0002','Marco','Zambon','374859424','1972-10-28','TREVISO','m.zambon@gmail.com','-946852072',0);
insert into treatit.Doctor (id, name, surname, telephone_number, birth_date, place_of_birth, office_mail, hashed_password, actual_patients) 
	values ('0003','Alessandro','Gottardo','384859424','1962-10-8','NOALE','a.gattaro@gmail.com','-946852072',0);

-- Populating Email_Address table
insert into treatit.Email_Address (email, patient) 
	values ('aariorossi@gmail.com','ASSMRA85T10A569S');
insert into treatit.Email_Address (email, patient) 
	values ('aariorossi2@gmail.com','ASSMRA85T10A569S');
insert into treatit.Email_Address (email, patient) 
	values ('aariorossi3@gmail.com','ASSMRA85T10A569S');
insert into treatit.Email_Address (email, patient) 
	values ('fariabianchi@gmail.com','FSSMRA85T10A564S');
insert into treatit.Email_Address (email, patient) 
	values ('fariabianchi2@gmail.com','FSSMRA85T10A564S');

-- Populating kinship Is_Relative table
insert into treatit.Is_Relative (patient1, patient2, kinship) 
	values ('ASSMRA85T10A569S','HSSMRA85T10A562S','PARENT');
insert into treatit.Is_Relative (patient1, patient2, kinship) 
	values ('ASSMRA85T10A569S','ISSMRA85T10A561S','SIBILING');

-- Populating Takes_care table
insert into treatit.Takes_care (doctor, patient, start_date) 
	values ('0002','ASSMRA85T10A569S','2017-12-20');
insert into treatit.Takes_care (doctor, patient, start_date) 
	values ('0001','BSSMRA85T10A568S','2016-12-20');
insert into treatit.Takes_care (doctor, patient, start_date) 
	values ('0002','CSSMRA85T10A597S','2015-12-20');
insert into treatit.Takes_care (doctor, patient, start_date) 
	values ('0003','DSSMRA85T10A566S','2014-12-20');
insert into treatit.Takes_care (doctor, patient, start_date) 
	values ('0002','ESSMRA85T10A565S','2013-12-20');
insert into treatit.Takes_care (doctor, patient, start_date) 
	values ('0003','FSSMRA85T10A564S','2017-12-20');

-- Populating Treatment table
insert into Treatit.Treatment (id, name) 
	values ('STRUCT039ABLARR','ABLATION OF ARRHYTHMIA');
insert into Treatit.Treatment (id, name) 
	values ('STRUCT039ACN','ACNE');
insert into Treatit.Treatment (id, name) 
	values ('STRUCT045ARMACDEG','AGE-RELATED MACULAR DEGENERATION TREATMENT');
insert into Treatit.Treatment (id, name) 
	values ('STRUCT039ALTTREAD','ALTERG TREADMILL');
insert into Treatit.Treatment (id, name) 
	values ('STRUCT031ANKARTH','ANKLE ARTHROSCOPY');

-- Populating Structure table
insert into treatit.Structure (id, name, address) 
	values ('STRUCT039','Centro Molliego','Via Aldo Moro 17 56122 PISA PI');
insert into treatit.Structure (id, name, address) 
	values ('STRUCT045','Centro Colle','Via Roma 17 56122 ROVIGO RO');
insert into treatit.Structure (id, name, address) 
	values ('STRUCT031','Centro Urso','Via Genova 13 56522 TREVISO TV');
insert into treatit.Structure (id, name, address) 
	values ('STRUCT030','Centro Teresin','Via Trieste 17 56622 VENEZIA VE');
insert into treatit.Structure (id, name, address) 
	values ('STRUCT088','Centro Molesan','Via Pescara 17 56172 NAPOLI NA');
insert into treatit.Structure (id, name, address) 
	values ('STRUCT078','Centro Meggin','Via Provenza 14 56182 TORINO TO');

-- Populating Undergoes table
insert into treatit.Undergoes (patient, treatment, structure, treatment_date) 
	values ('ASSMRA85T10A569S','STRUCT039ABLARR','STRUCT039','2017-10-10');
insert into treatit.Undergoes (patient, treatment, structure, treatment_date) 
	values ('ASSMRA85T10A569S','STRUCT039ALTTREAD','STRUCT039','2017-11-10');
insert into treatit.Undergoes (patient, treatment, structure, treatment_date) 
	values ('ASSMRA85T10A569S','STRUCT031ANKARTH','STRUCT031','2017-10-09');

-- Populating Allergy table
insert into treatit.Allergy (allergen) values ('AA');
insert into treatit.Allergy (allergen) values ('ABD');
insert into treatit.Allergy (allergen) values ('ABE');
insert into treatit.Allergy (allergen) values ('ABF');
insert into treatit.Allergy (allergen) values ('ABG');

-- Populating Suffers table
insert into treatit.Suffers (patient, allergy) values ('ASSMRA85T10A569S','AA');
insert into treatit.Suffers (patient, allergy) values ('ASSMRA85T10A569S','ABE');
insert into treatit.Suffers (patient, allergy) values ('ASSMRA85T10A569S','ABG');
insert into treatit.Suffers (patient, allergy) values ('CSSMRA85T10A597S','AA');

-- Populating Call table
insert into treatit.Call (call_number) values (default);
insert into treatit.Call (call_number) values (default);
insert into treatit.Call (call_number) values (default);
insert into treatit.Call (call_number) values (default);
insert into treatit.Call (call_number) values (default);
insert into treatit.Call (call_number) values (default);
insert into treatit.Call (call_number) values (default);

-- Populating Vaccination table
insert into treatit.Vaccination (disease) values ('ADENOVIRUS');
insert into treatit.Vaccination (disease) values ('ANTHRAX');
insert into treatit.Vaccination (disease) values ('CHOLERA');
insert into treatit.Vaccination (disease) values ('DIPHTHERIA');

-- Populating Gets table
insert into treatit.Gets (patient, vaccination, call, vaccination_date, deadline) 
	values ('ASSMRA85T10A569S','ADENOVIRUS',2,'2017-11-10','2020-11-10');
insert into treatit.Gets (patient, vaccination, call, vaccination_date, deadline) 
	values ('ASSMRA85T10A569S','ANTHRAX',2,'2013-11-10','2016-11-10');
insert into treatit.Gets (patient, vaccination, call, vaccination_date, deadline) 
	values ('ASSMRA85T10A569S','CHOLERA',2,'2013-11-10','2016-11-10');
insert into treatit.Gets (patient, vaccination, call, vaccination_date, deadline) 
	values ('ASSMRA85T10A569S','DIPHTHERIA',2,'2013-11-10','2017-11-10');
insert into treatit.Gets (patient, vaccination, call, vaccination_date, deadline) 
	values ('ASSMRA85T10A569S','ADENOVIRUS',3,'2020-11-10','2022-11-10');

-- Populating Visit table
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0001');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'BSSMRA85T10A568S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0003');
insert into treatit.Visit (visit_time, patient, doctor) 
	values (current_timestamp,'ASSMRA85T10A569S','0002');

-- Populating Disease table
insert into treatit.Disease (name, description) 
	values ('ARTHRITIS','DISEASE INVOLVING BONES');
insert into treatit.Disease (name, description) 
	values ('CANCER','DISEASE INVOLVING ROGUE CELLULAR MULTIPLICATION');
insert into treatit.Disease (name, description) 
	values ('CHOLESTEROL','DISEASE INVOLVING SUGAR IN BLOOD');
insert into treatit.Disease (name, description) 
	values ('CHRONIC PAIN','DISEASE INVOLVING STRESS, PREVIOUS TRAUMAS AND OTHER FACTORS');
insert into treatit.Disease (name, description) 
	values ('LUNG DISEASE','DISEASE INVOLVING PAIN IN THE LUNG');
insert into treatit.Disease (name, description) 
	values ('HIV','DISEASE INVOLVING THE HIV VIRUS');

--Populating Disease_contraction table
insert into treatit.Disease_contraction (id, pain_scale, first_appearance_date, end_date, visit, disease) 

	values ('ASSMRA85T10A569SARTHR001',6,'2016-05-20','2017-03-11',2,'ARTHRITIS');
insert into treatit.Disease_contraction (id, pain_scale, first_appearance_date, end_date, visit, disease) 

	values ('ASSMRA85T10A569SCANCE001',10,'2018-04-20',NULL,5,'CANCER');
insert into treatit.Disease_contraction (id, pain_scale, first_appearance_date, end_date, visit, disease) 

	values ('ASSMRA85T10A569SARTHR002',7,'2018-01-20',NULL,8,'ARTHRITIS');
insert into treatit.Disease_contraction (id, pain_scale, first_appearance_date, end_date, visit, disease) 

	values ('ASSMRA85T10A569SLUNDI001',4,'2018-05-20',NULL,8,'LUNG DISEASE');

-- Populating Suspects table
insert into treatit.Suspects (disease, visit) values ('CHRONIC PAIN',7);
insert into treatit.Suspects (disease, visit) values ('LUNG DISEASE',6);
insert into treatit.Suspects (disease, visit) values ('HIV',3);
insert into treatit.Suspects (disease, visit) values ('CANCER',2);

--Populating Exam_type table
insert into treatit.Exam_type (name) values ('BIOPSY');
insert into treatit.Exam_type (name) values ('TAC');
insert into treatit.Exam_type (name) values ('HIV TEST');
insert into treatit.Exam_type (name) values ('BLOOD EXAM');
insert into treatit.Exam_type (name) values ('CARDIOVASCULAR EXAMINATION');

-- Populating Is_about table
insert into treatit.Is_about (disease, exam_type) values ('HIV','HIV TEST');
insert into treatit.Is_about (disease, exam_type) values ('CHRONIC PAIN','TAC');
insert into treatit.Is_about (disease, exam_type) values ('ARTHRITIS','TAC');
insert into treatit.Is_about (disease, exam_type) values ('CANCER','BIOPSY');

-- Populating Exam table
insert into treatit.Exam (exam_code, structure, patient, exam_type, exam_date) 
	values ('TAC201','STRUCT039','ASSMRA85T10A569S','TAC','2018-01-20');
insert into treatit.Exam (exam_code, structure, patient, exam_type, exam_date) 
	values ('BIOPSY601','STRUCT031','ASSMRA85T10A569S','BIOPSY','2018-01-20');
insert into treatit.Exam (exam_code, structure, patient, exam_type, exam_date) 
	values ('TAC202','STRUCT039','ASSMRA85T10A569S','TAC','2018-01-10');
insert into treatit.Exam (exam_code, structure, patient, exam_type, exam_date) 
	values ('HIVTEST222','STRUCT039','ASSMRA85T10A569S','HIV TEST','2017-01-20');
insert into treatit.Exam (exam_code, structure, patient, exam_type, exam_date) 
	values ('TAC111','STRUCT039','ASSMRA85T10A569S','TAC','2016-01-20');
insert into treatit.Exam (exam_code, structure, patient, exam_type, exam_date) 
	values ('TAC101','STRUCT045','ASSMRA85T10A569S','TAC','2015-01-20');

-- Populating Form table
insert into treatit.Form (name, description) 
	values ('RESULTS FROM TAC','THE RESULTS FROM THE TAC EXAM PERFORMED BY DR. UGO BASSI');
insert into treatit.Form (name, description) 
	values ('RESULTS FROM HIV TEST','THE RESULTS FROM THE HIV TEST OF AARIO ROSSI');
insert into treatit.Form (name, description) 
	values ('LIST OF EREDITATED DISEASES','THE LIST OF THE DISEASES EREDITATED BY AARIO ROSSI');
insert into treatit.Form (name, description) 
	values ('BLINDNESS CERTIFICATE','THE CERTIFICATION OF BLINDNESS OF AARIO ROSSI');
insert into treatit.Form (name, description) 
	values ('LIST OF TRAUMA','THE LIST OF THE TRAUMAS TAKEN BY AARIO ROSSI');
insert into treatit.Form (name, description) 
	values ('ADDITIONAL INFORMATION','ADDITIONAL INFORMATIONS REGARDING THE LIST OF THE EXEMPTIONS OF BY AARIO ROSSI');
insert into treatit.Form (name, description) 
	values ('CERTIFICATE OF CRONIC BRONCOPNEUNOPHATY','THE CERTIFICATION OF A CRONIC LUNG DISEASE OF AARIO ROSSI');
insert into treatit.Form (name, description) 
	values ('PRESCRIPTION OF STOMACH DRUG','A PRESCRIPTION FOR A SPECIFIC DRUG THAT DEALS WITH REALLY PAINFUL STOMACHACHE');
insert into treatit.Form (name, description) 
	values ('PRESCRIPTION OF A BIOPSY','A PRESCRIPTION FOR A SPECIFIC EXAM ABOUT CANCER');

-- Populating Field table
insert into treatit.Field (name, field_value, form) values ('responseA','true',1);
insert into treatit.Field (name, field_value, form) values ('responseB','false',1);
insert into treatit.Field (name, field_value, form) values ('result: ','negative',2);
insert into treatit.Field (name, field_value, form) values ('first disease','skin disease',3);
insert into treatit.Field (name, field_value, form) values ('second disease','HIV',3);
insert into treatit.Field (name, field_value, form) values ('from mother branch','chronic disease, eyes disease',3);
insert into treatit.Field (name, field_value, form) values ('percentage of blindness','89%',4);
insert into treatit.Field (name, field_value, form) values ('traumas in childhood','domestic violence, arm broken',5);
insert into treatit.Field (name, field_value, form) values ('traumas in youth','leg broken, arm broken',5);
insert into treatit.Field (name, field_value, form) values ('recent traumas','heart attack, nose broken',5);
insert into treatit.Field (name, field_value, form) values ('law that is exploited in the exemption: ','ART495 COMMA B',6);
insert into treatit.Field (name, field_value, form) values ('affected mobility','30%',7);
insert into treatit.Field (name, field_value, form) values ('certification tests was performed by: ','ULSS14',7);

-- Populating Medical_history table
insert into treatit.Medical_history (id, visit, form) values ('ASSMRA85T10A569S01',2,3);
insert into treatit.Medical_history (id, visit, form) values ('ASSMRA85T10A569S02',2,5);

-- Populating Exemption table
insert into treatit.Exemption (id, activity, reason, exemption_date, deadline, visit, form) 
	values ('26','TICKET PAYEMENT','THE PATIENT IS FULL OF ILLNESSES','2015-10-10','2019-10-10',2,6);

-- Populating Certification table
insert into treatit.Certification (id, certified_condition, certification_date, deadline, visit, form) 
	values ('24','BLINDNESS','2016-10-09','2017-10-10',2,4);
insert into treatit.Certification (id, certified_condition, certification_date, deadline, visit, form) 
	values ('37','CRONIC BRONCOPNEUNOPHATY','2018-10-09','2039-10-10',3,7);

-- Populating Prescription table
insert into  treatit.Prescription (id, type, prescription_date, deadline, visit, form) 
	values ('28','PRESCRIPTION FOR A DRUG ABOUT STOMACHACHE','2018-05-23','2018-06-01',2,8);
insert into  treatit.Prescription (id, type, prescription_date, deadline, visit, form) 
	values ('39','PRESCRIPTION FOR DOING A BIOPSY','2018-01-01','2018-07-01',3,9);

-- Populating Drug table
insert into treatit.Drug (name, active_principle) 
	values ('AZTREONAM','Bezellanius Acheolaptus, Lombagenanthes');

-- Populating Authorizes table
insert into treatit.Authorizes (prescription, drug, cause, dosage) 
	values ('28','AZTREONAM','PRESCRIBED BECAUSE THE PATIENT HAS A REALLY DANGEROUS STOMACHACHE','100mL/DAY UNTIL HE FEELS BETTER');

-- Populating Prescribes table
insert into treatit.Prescribes (prescription, exam_type, cause) 
	values ('39','BIOPSY','THE PATIENT STARTED TO FEEL DIZZY AND STUFF, SO HE BADLY NEEDS TO DO THIS EXAM.');

-- Populating Comes_after table
insert into treatit.Comes_after (exam, prescription) values ('BIOPSY601','39');

-- Populating Result table
insert into treatit.Result (exam, result_date, form) values ('TAC111','2018-02-20',1);
insert into treatit.Result (exam, result_date, form) values ('HIVTEST222','2017-02-20',2);