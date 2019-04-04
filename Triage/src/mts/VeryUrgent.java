package mts;

class VeryUrgent {
	//@ requires p.pain_measured == true && p.cardiac_pain_examined == true && p.breathing_rate_measured == true && p.pulse_checked == true;
	//@ ensures p.patient_stabilized == true;
	void stabilize(TreatedPatient p) {
		System.out.println("Stabilizing patient");
		if (p.pain_measured == true && p.cardiac_pain_examined == true && p.breathing_rate_measured == true && p.pulse_checked == true) {
			System.out.println("=> Stabilize patient!");
			p.patient_stabilized = true;
		} else {
			System.out.println("*** Check for levels of pain, cardiac pain, breathing and pulse rates before stabilizing patient ***\n");
		}
	}
	
	void monitor(TreatedPatient p) {
		System.out.println("Monitoring patient");
		System.out.println("=> Monitoring required!");
	}
}
