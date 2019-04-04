package esi;

class _ESI_Scenario10 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 10 ======");
			
			Patient p = new Patient();
			p.setFirstName("Melissa");
			p.setLastName("Johnson");
			p.setID("DF938SW");
			p.setGender(Gender.Female);
			p.setAge(33);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.distress = true;
			t.setResourcesRequired(3);
			t.setHeartRate(76);
			t.setRespiratoryRate(14);
			t.setSaO2Level(100);
			
			s.checkIfInterventionNeeded(t);
			s.assessSituation(t);
			s.examine(t);
			s.checkForPain(t);
			s.checkResourcesNeeded(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 3 URGENT
			 * RESULT: LEVEL 2 VERY URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
