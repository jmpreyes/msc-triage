package mts;

class _MTS_Scenario9 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 9 ======");
			
			Patient p = new Patient();
			p.setFirstName("Patricia");
			p.setLastName("Holman");
			p.setID("PS387DG");
			p.setGender(Gender.Female);
			p.setAge(49);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.acutelyShortBreath = true;
			t.severePain = true;
			t.abnormalPulse = true;
			t.recentVomiting = true;
			t.significantCardiacHistory = true;
			
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
			 * EXPECTED RESULT: LEVEL 2 VERY URGENT
			 * RESULT: LEVEL 2 VERY URGENT
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
