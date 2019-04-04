package esi;

class _ESI_Scenario6 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 6 ======");
			
			Patient p = new Patient();
			p.setFirstName("Simon");
			p.setLastName("Mitchell");
			p.setID("MJ382PL");
			p.setGender(Gender.Male);
			p.setAge(60);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.lethargic = true;
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
			 * EXPECTED RESULT: LEVEL 2 VERY URGENT
			 * RESULT: LEVEL 2 VERY URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
