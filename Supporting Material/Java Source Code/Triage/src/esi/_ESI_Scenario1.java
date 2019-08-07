package esi;

class _ESI_Scenario1 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 1 ======");
			
			Patient p = new Patient();
			p.setFirstName("Joe");
			p.setLastName("Smith");
			p.setID("AB123CD");
			p.setGender(Gender.Male);
			p.setAge(32);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.requiresLifeSavingIntervention = true;
			t.setResourcesRequired(3);
			t.setHeartRate(100);
			t.setRespiratoryRate(10);
			t.setSaO2Level(86);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 1 IMMEDIATE
			 * RESULT: LEVEL 1 IMMEDIATE
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
