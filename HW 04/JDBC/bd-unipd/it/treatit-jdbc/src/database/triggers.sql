-- Create function for update the actual patients of a doctor 

create function AddPatient() returns trigger as $$
declare
	begin
	-- If I have inserted a new row in Takes_care (i.e. the doctor of the corresponding row
	-- has a new patient, so I need to increment his actual patients by one unit
	-- I called an insert, so the number of patients of the corresponding doctor increased by one unit
		update treatit.Doctor
		set actual_patients=actual_patients+1
		where id=new.doctor;
		return new;
	end
$$ language plpgsql;


create function DelPatient() returns trigger as $$
declare
	begin
	-- If I have deleted a row in Takes_care (i.e. the doctor of the corresponding row
	-- looses a patient, so I need to decrement his actual patients by one unit
	-- I called a deletion, so the number of patients of the corresponding doctor decreased by one unit
		update treatit.Doctor
		set actual_patients=actual_patients-1
		where id=old.doctor;
		return old;
	end
$$ language plpgsql;


-- Adding two triggers to automatically increment/decrement the number of patients of a single doctor

create trigger AddPatientTrigger
	after insert on treatit.Takes_care
	for each row
	execute procedure AddPatient();


create trigger DelPatientTrigger
	after delete on treatit.Takes_care
	for each row
	execute procedure DelPatient();