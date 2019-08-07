package mts;

class _MTS_Scenario3 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 3 ======");
			
			Patient p = new Patient();
			p.setFirstName("Susan");
			p.setLastName("Mitchell");
			p.setID("IJ362LO");
			p.setGender(Gender.Female);
			p.setAge(43);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.normalBreathing = true;
			t.moderatePain = true;
			t.normalPulse = true;
			t.recentVomiting = true;
			
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
