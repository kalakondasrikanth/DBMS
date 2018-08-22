--ESTRACT DISEASE NAME, FIRST APPEARANCE DATE, (EVENTUALLY) END DATE AND DESCRIPTION OF THE DESEASE FOR A CERTAIN PATIENT (the research is done by fiscal code)
--THE DISEASE MANIFESTATIONS ARE SORTED IN DESCENDING ORDER (THE MORE RECENT ONES FIRST)
SELECT disease, first_appearance_date, end_date, description FROM
	treatit.Disease AS D INNER JOIN treatit.Disease_contraction AS DC
	ON D.name=DC.disease
		INNER JOIN treatit.Visit AS V
		ON DC.visit=V.id
WHERE V.patient="fiscal code..."
ORDER BY first_appearance_date DESC;

--EXTRACT ALL THE EXAMS OF A CERTAIN PATIENT (i.e. CODE, TYPE, DATE, AND EVENTUALLY THE RESULT DATE) STARTING FROM THE MOST RECENT ONES
SELECT exam_code, exam_type, exam_date, result_date FROM
	treatit.Exam AS E INNER JOIN treait.Result AS R
	ON E.exam_code=R.exam
WHERE patient="fiscal code..."
ORDER BY exam_date DESC;

--EXTRACT ALL THE FIELDS (EACH OF THEM COMPOSED BY NAME AND VALUE) ASSOCIATED TO A FORM WHICH CORRESPONDS TO THE RESULT OF A DESIRED EXAM (SEARCH BY EXAM CODE)
SELECT FI.name, FI.field_value FROM
	treatit.Result AS R INNER JOIN treatit.Form AS FO
	ON R.form=FO.id
		INNER JOIN treatit.Field AS FI
		ON FO.id=FI.form
WHERE R.exam="exam code...";

--EXTRACT ALL THE FIELDS OF MEDICAL HISTORY OF A CERTAIN PATIENT
--IN EACH VISIT, THE DOCTOR CAN SUBMIT MULTIPLE FORM OF MEDICAL HISTORY, EACH OF THEM ARE COMPOSED BY ONE OR MORE FIELDS
--WITH THIS QUERY THE DOCTOR RETRIEVES ALL THE FORMS ABOUT MEDICAL HISTORY WHICH CONCERN A SPECIFIC PATIENT
--THE FIELDS ARE GROUPED BY THE FORMS TO WHICH THEY BELONG
SELECT V.doctor, V.visit_time, FO.name, FI.field_value FROM
	treatit.Visit AS V INNER JOIN treatit.Medical_History AS M
	ON M.visit=V.id
		INNER JOIN treatit.Form AS FO
		ON FO.id=M.form
			INNER JOIN treatit.FIELD AS FI
			ON FO.id=FI.form
WHERE V.patient="fiscal code..."
GROUP BY FO.id
ORDER BY V.visit_time DESC;

--EXTRACT ALL THE CURRENT CERTIFICATIONS OF A CERTAIN PATIENT
--(i.e. THE ID, THE CERTIFIED CONDITION, THE DOCTOR WHO CERTIFIED THEM, THE CERTIFICATION DATE AND DEADLINE)
SELECT C.id, C.certified_condition, V.doctor, C.certification_date, C.deadline FROM
	treatit.Certificate AS C INNER JOIN treatit.Visit AS V
	ON C.Visit=V.id
WHERE V.patient="fiscal code...", C.deadline<current_date
ORDER BY C.certification_date;

--EXTRACT ALL THE VACCINATIONS (i.e. NAME OF THE CORRESPONDING DISEASE, NUMBER OF CALL, DATE IN WHICH IT WAS/WILL BE PERFORMED, DEADLINE
--IT IS ADOPTED THE DESCENDING ORDER IN THE DEADLINE DATE
SELECT vaccination, call, vaccination_date, deadline FROM treatit.Gets
WHERE patient="fiscal code..."
ORDER BY deadline DESC;

--EXTRACT ALL THE EMAILS OF A CERTAIN PATIENT (RESEARCH IS DONE BY USING PATIENT'S FISCAL CODE)
SELECT email FROM treatit.Email_Address
WHERE patient="fiscal code...";

--EXTRACT ALL THE VISIT ID AND FOR A CERTAIN PATIENT
--DECREASING ORDER FOLLOWING VISIT ID PUT IN EVIDENCE THE RECENT VISITS
--THIS IS A USEFUL QUERY THAT ALLOWS THE INSERTION OF EVENTS PERFORMED DURING A CERTAIN VISIT 
SELECT id, visit_time FROM treatit.Visit
WHERE patient="fiscal code"
ORDER BY visit_time DESC;