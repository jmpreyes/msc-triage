package mts;

class _MTS_Scenario2 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 2 ======");
			
			Patient p = new Patient();
			p.setFirstName("Sean");
			p.setLastName("Michaels");
			p.setID("KI928SH");
			p.setGender(Gender.Male);
			p.setAge(19);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.acutelyShortBreath = true;
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
			 * EXPECTED RESULT: LEVEL 2 VERY URGENT
			 * RESULT: LEVEL 2 VERY URGENT 
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
