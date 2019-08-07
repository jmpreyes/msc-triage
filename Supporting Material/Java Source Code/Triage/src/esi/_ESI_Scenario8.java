package esi;

class _ESI_Scenario8 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 8 ======");
			
			Patient p = new Patient();
			p.setFirstName("Mike");
			p.setLastName("Moses");
			p.setID("OD238DB");
			p.setGender(Gender.Male);
			p.setAge(2);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.setResourcesRequired(3);
			t.setHeartRate(82);
			t.setRespiratoryRate(18);
			t.setSaO2Level(99);
			
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
