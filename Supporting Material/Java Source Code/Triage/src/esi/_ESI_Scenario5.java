package esi;

class _ESI_Scenario5 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 5 ======");
			
			Patient p = new Patient();
			p.setFirstName("Mary");
			p.setLastName("Smith");
			p.setID("KK228DH");
			p.setGender(Gender.Female);
			p.setAge(58);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.distress = true;
			t.severePain = true;
			t.setResourcesRequired(1);
			t.setHeartRate(120);
			t.setRespiratoryRate(25);
			t.setSaO2Level(100);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 4 MINOR
			 * RESULT: LEVEL 2 VERY URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
