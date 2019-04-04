package esi;

class _ESI_Scenario7 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 7 ======");
			
			Patient p = new Patient();
			p.setFirstName("Sheila");
			p.setLastName("Doe");
			p.setID("SJ172CM");
			p.setGender(Gender.Female);
			p.setAge(29);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.setResourcesRequired(3);
			t.setHeartRate(110);
			t.setRespiratoryRate(25);
			t.setSaO2Level(100);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 5 DELAYED
			 * RESULT: LEVEL 3 URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
