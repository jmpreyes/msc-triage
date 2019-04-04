package esi;

class Minor {
	//@ requires p.number_resources_assessed == true && p.resources == 1;
	void reassess(TreatedPatient p, Integer resources) {
		System.out.println("Reassessing patient's condition");
		if (p.number_resources_assessed == true && p.getResourcesRequired() == 1) {
			System.out.println("=> Reassessment required!");
		} else {
			System.out.println("*** Assess resources and verify if patient needs only one resource before reassessment ***\n");
		}
	}
}
