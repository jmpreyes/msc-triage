package esi;

class Urgent {
	//@ requires p.vitals_examined == true;
	void supervision(TreatedPatient p) {
		System.out.println("Supervising patient");
		if (p.vitals_examined == true) {
			System.out.println("=> Supervision required!");
		} else {
			System.out.println("*** Examine patient's vitals before supervision ***\n");
		}
	}
}
