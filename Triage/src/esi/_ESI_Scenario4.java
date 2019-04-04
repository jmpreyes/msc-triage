package esi;

class _ESI_Scenario4 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== ESI Test Case 4 ======");
			
			Patient p = new Patient();
			p.setFirstName("Joey");
			p.setLastName("Smith");
			p.setID("KL298AH");
			p.setGender(Gender.Male);
			p.setAge(7);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.lethargic = true;
			t.setResourcesRequired(4);
			t.setHeartRate(88);
			t.setRespiratoryRate(22);
			t.setSaO2Level(100);
			
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
