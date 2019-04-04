package mts;

class NonUrgent {
	//@ requires p.vomiting_checked == true && p.mild_pain_examined == true && p.problems_checked == true;
	//@ ensures p.patient_reassessed == true;
	void reassess(TreatedPatient p) {
		System.out.println("Reassessing patient's condition");
		if (p.vomiting_checked == true && p.mild_pain_examined == true && p.problems_checked == true) {
			System.out.println("=> Reassess patient!");
			p.patient_reassessed = true;
		} else {
			System.out.println("*** Check for vomiting, recent mild pain, and recent problems before reassessment ***\n");
		}
	}
	
	void canWait(TreatedPatient p) {
		System.out.println("=> Patient may be delayed!");
	}
}
