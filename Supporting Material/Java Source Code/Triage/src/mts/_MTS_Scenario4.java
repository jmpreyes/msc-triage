package mts;

class _MTS_Scenario4 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 4 ======");
			
			Patient p = new Patient();
			p.setFirstName("Joey");
			p.setLastName("Daniels");
			p.setID("AF162HS");
			p.setGender(Gender.Male);
			p.setAge(40);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.moderatePain = true;
			
			s.examineAirway(t);
			s.checkForAdequateBreathing(t);
			s.checkForShock(t);
			s.measurePain(t);
			s.examineCardiacPain(t);
			s.measureBreathingRate(t);
			s.checkPulse(t);
			s.examinePleuriticPain(t);
			s.checkForPersistentVomiting(t);
			s.examineForCardiacHistory(t);
			s.remeasureForPain(t);
			s.checkVomiting(t);
			s.examineForMildPain(t);
			s.checkForProblems(t);
			
			/*
			 * EXPECTED RESULT: LEVEL 3 URGENT
			 * RESULT: LEVEL 3 URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
