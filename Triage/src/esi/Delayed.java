package esi;

class Delayed {	
	//@ requires p.number_resources_assessed == true && p.resources == 0;
	void reassess(TreatedPatient p, Integer resources) {
		System.out.println("Reassessing patient's condition");
		if (p.number_resources_assessed == true && p.getResourcesRequired() == 0) {
			System.out.println("=> Reassessment required!");
		} else {
			System.out.println("*** Assess resources and verify if patient does not need any resource ***\n");
		}
	}
	
	void canWait(TreatedPatient p) {
		System.out.println("=> Patient may be delayed!");
	}
}
