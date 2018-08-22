-- Extract disease name, first appearance date, (eventually) end date and description of the desease for a certain patient (the research is done by fiscal code)
-- the disease manifestations are sorted in descending order (the more recent ones first)
select disease, first_appearance_date, end_date, description 
from treatit.Disease as D inner join treatit.Disease_contraction as DC on D.name=DC.disease
		inner join treatit.Visit as V on DC.visit=V.id
where V.patient='ASSMRA85T10A569S'
order by first_appearance_date desc;

-- Extract all the exams of a certain patient (i.e. code, type, date, and eventually the result date) starting from the most recent ones
select exam_code, exam_type, exam_date, result_date 
from treatit.Exam as E inner join treatit.Result as R on E.exam_code=R.exam
where E.patient='ASSMRA85T10A569S'
order by exam_date desc;

-- Extract all the fields (each of them composed by name and value) associated to a form which corresponds to the result of a desired exam (search by exam code)
select FI.name, FI.field_value 
from treatit.Result as R inner join treatit.Form as FO on R.form=FO.id
	inner join treatit.Field as FI on FO.id=FI.form
where R.exam='TAC111';

--extract all the fields of medical history of a certain patient
--in each visit, the doctor can submit multiple form of medical history, each of them are composed by one or more fields
--with this query the doctor retrieves all the forms about medical history which concern a specific patient
select V.visit_time, FO.name as form_name, FI.name as field_name, FI.field_value 
from treatit.Visit as V inner join treatit.Medical_History as M	on M.visit=V.id
	inner join treatit.Form as FO on FO.id=M.form
		inner join treatit.Field as FI on FO.id=FI.form
where V.patient='ASSMRA85T10A569S'
order by V.visit_time desc;

--extract all the current certifications of a certain patient
--(i.e. the id, the certified condition, the doctor who certified them, the certification date and deadline)
select C.id, C.certified_condition, D.name ||' '|| D.surname as doctor, C.certification_date, C.deadline 
from treatit.Certification as C inner join treatit.Visit as V on C.Visit=V.id 
	inner join treatit.doctor as D on V.doctor=D.id
where V.patient='ASSMRA85T10A569S' and C.deadline < current_date
order by C.certification_date;

--extract all the vaccinations (i.e. name of the corresponding disease, number of call, date in which it was/will be performed, deadline
--it is adopted the descending order in the deadline date
select vaccination, call, vaccination_date, deadline 
from treatit.Gets
where patient='ASSMRA85T10A569S'
order by deadline desc;

--extract all the emails of a certain patient (research is done by using patient's fiscal code)
select email 
from treatit.Email_Address
where patient='ASSMRA85T10A569S';

--extract all the visit id and for a certain patient
--decreasing order following visit id put in evidence the recent visits
--this is a useful query that allows the insertion of events performed during a certain visit 
select id, visit_time 
from treatit.Visit
where patient='ASSMRA85T10A569S'
order by visit_time desc;
