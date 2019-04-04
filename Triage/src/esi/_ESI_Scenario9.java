package esi;

class _ESI_Scenario9 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 9 ======");
			
			Patient p = new Patient();
			p.setFirstName("Jenny");
			p.setLastName("Craig");
			p.setID("OS284AH");
			p.setGender(Gender.Female);
			p.setAge(52);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.setResourcesRequired(3);
			t.setHeartRate(86);
			t.setRespiratoryRate(16);
			t.setSaO2Level(100);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 3 URGENT
			 * RESULT: LEVEL 3 URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
