package esi;

class _ESI_Scenario3 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 3 ======");
			
			Patient p = new Patient();
			p.setFirstName("Jane");
			p.setLastName("Doe");
			p.setID("DK282OS");
			p.setGender(Gender.Female);
			p.setAge(32);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.distress = true;
			t.setResourcesRequired(3);
			t.setHeartRate(96);
			t.setRespiratoryRate(32);
			t.setSaO2Level(93);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 2 VERY URGENT
			 * RESULT: LEVEL 2 VERY URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
