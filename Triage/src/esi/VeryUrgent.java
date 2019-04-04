package esi;

class VeryUrgent {
	//@ requires p.situation_assessed == true && (p.examined_if_confused == true || p.examined_if_disoriented == true || p.examined_if_lethargic == true) && (p.checked_if_severe_pain == true || p.checked_if_distressed == true) && p.vitals_examined == true;
	void stabilize(TreatedPatient p) {
		System.out.println("Stabilizing patient");
		if (p.situation_assessed == true && 
			(p.examined_if_confused == true || p.examined_if_disoriented == true || p.examined_if_lethargic == true) && 
			(p.checked_if_severe_pain == true || p.checked_if_distressed == true) && 
			p.vitals_examined == true) {
			System.out.println("=> Stabilizing required!");
		} else {
			System.out.println("*** Assess siuation, examine if patient is confused/disoriented/lethargic, examine if patient is in severe pain/distress, and examine vitals before stabilizing patient ***\n");
		}
	}
	
	void monitor(TreatedPatient p) {
		System.out.println("Monitoring patient");
		System.out.println("=> Monitoring required!");
	}
}
