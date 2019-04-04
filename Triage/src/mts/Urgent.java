package mts;

class Urgent {
	//@ requires p.pleuritic_pain_examined == true && p.checked_for_persistent_vomiting == true && p.examine_patients_cardiac_history == true && p.pain_remeasured == true;
	//@ ensures p.patient_supervised == true;
	void supervision(TreatedPatient p) {
		System.out.println("Supervising patient");
		if (p.pleuritic_pain_examined == true && p.checked_for_persistent_vomiting == true && p.examine_patients_cardiac_history == true && p.pain_remeasured == true) {
			System.out.println("=> Supervise patient!");
			p.patient_supervised = true;
		} else {
			System.out.println("*** Check for pleuritic pain, persistent vomiting, and cardiac history before supervising patient ***\n");
		}
	}
}
