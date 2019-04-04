package mts;

class Immediate {
	//@ requires p.examined_airway == true && p.examined_breathing == true && p.checked_patient_for_shock == true;
	//@ ensures p.resuscitation_in_action == true;
	void resuscitationRequired(TreatedPatient p) {
		System.out.println("Requiring resuscitation");
		if (p.examined_airway == true && p.examined_breathing == true && p.checked_patient_for_shock == true) {
			System.out.println("=> Resuscitation required!");
			p.resuscitation_in_action = true;
		} else {
			System.out.println("*** Examine airway, breathing, and signs of shock before resuscitation ***\n");
		}
	}
	
	void continuousObservation(TreatedPatient p) {
		System.out.println("Requiring continuous observation");
		System.out.println("=> Continuous observation required!");
	}
}
