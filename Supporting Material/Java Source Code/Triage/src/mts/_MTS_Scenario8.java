package mts;

class _MTS_Scenario8 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 8 ======");
			
			Patient p = new Patient();
			p.setFirstName("George");
			p.setLastName("Stevens");
			p.setID("DM813DL");
			p.setGender(Gender.Male);
			p.setAge(52);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.normalBreathing = true;
			t.moderatePain = true;
			t.normalPulse = true;
			
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
			 * RESULT: LEVEL LEVEL 3 URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
