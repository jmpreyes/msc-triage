package mts;

class _MTS_Scenario6 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 6 ======");
			
			Patient p = new Patient();
			p.setFirstName("Anne");
			p.setLastName("Williams");
			p.setID("NS336XM");
			p.setGender(Gender.Female);
			p.setAge(25);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.normalBreathing = true;
			t.normalPulse = true;
			t.recentProblem = true;
			
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
			 * EXPECTED RESULT: LEVEL 4 STANDARD
			 * RESULT: LEVEL 4 STANDARD
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
