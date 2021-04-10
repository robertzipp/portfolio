/** Query 1 : Find out the events for which the attendees must be contacted because of 
potential exposure. Contains subquery and inner join of at least 3 tables */

SELECT People.FullName, MedicalData.IsPositive, Event.EventName, Event.EventDay 
    FROM People
        INNER JOIN MedicalData 
        ON People.SchoolID = MedicalData.SchoolID
        INNER JOIN EventAtendees
        ON EventAtendees.SchoolID = People.SchoolID
        INNER JOIN Event
        ON Event.EventID = EventAtendees.EventID;

/** Query 2: Select all people at school and group by those who have a temp over 100. 
 Contains Group by with a having clause */ 

SELECT People.FullName, People.SchoolID, MedicalData.MedicalID, MedicalData.Temp
	FROM People, MedicalData
	WHERE People.SchoolID = MedicalData.SchoolID
	GROUP BY People.FullName, People.SchoolID, MedicalData.MedicalID, MedicalData.Temp
	HAVING (MedicalData.Temp) > 99;

/** Query 3: We’re trying to find a particular student named Carson who went
 to a particular event but don’t know her last name. Contains a complex search criterion using AND, OR, or LIKE */
 
SELECT People.FullName, Student.SchoolID, EventAtendees.EventID, MedicalData.isPositive
	FROM People, Student, EventAtendees, MedicalData
	WHERE People.FullName LIKE "Carson%" 
	AND People.SchoolID = Student.SchoolID 
	AND EventAtendees.SchoolID = People.SchoolID
	AND MedicalData.SchoolID = Student.SchoolID ;

/** Query 4: Partition everyone in the school by their group ID and by their COVID status. 
Contains an advanced query mechanisms such as RCTE, PARTITION BY, or SELECT CASE/WHEN. */

SELECT People.SchoolID, People.FullName, People.GroupID, MedicalData.IsPositive
FROM People, MedicalData
WHERE People.SchoolID = MedicalData.SchoolID
PARTITION BY LIST(People.GroupID) (
PARTITION not_Positive VALUES BOOL(FALSE),
PARTITION is_Positive VALUES BOOL(TRUE)
);

/** Query 5: Return the treatment plan for each COVID case to compare drugs used. */

SELECT TreatmentPlan.PrescriptionName, CaseData.CaseID
	FROM TreatmentPlan
		INNER JOIN CaseData
        ON CaseData.TreatmentPlanID = TreatmentPlan.TreatmentPlanID;
