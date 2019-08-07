package esi;

class Immediate {
	//@ requires p.checked_for_immediate_intervention == true;
	void resuscitationRequired(TreatedPatient p) {
		System.out.println("Requiring resuscitation");
		if (p.checked_for_immediate_intervention == true) {
			System.out.println("=> Resuscitation required!");
		} else {
			System.out.println("*** Check for immediate intervention before resuscitation ***\n");
		}
	}
	
	void continuousObservation(TreatedPatient p) {
		System.out.println("Requiring continuous observation");
		System.out.println("=> Continuous observation required!");
	}
}
