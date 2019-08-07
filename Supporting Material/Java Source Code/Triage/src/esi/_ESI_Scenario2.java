package esi;

class _ESI_Scenario2 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 2 ======");
			
			Patient p = new Patient();
			p.setFirstName("John");
			p.setLastName("Doe");
			p.setID("CG237JH");
			p.setGender(Gender.Male);
			p.setAge(56);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.setResourcesRequired(0);
			t.setHeartRate(76);
			t.setRespiratoryRate(16);
			t.setSaO2Level(92);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 5 DELAYED
			 * RESULT: UNKNOWN
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
