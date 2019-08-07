package mts;

class _MTS_Scenario7 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 7 ======");
			
			Patient p = new Patient();
			p.setFirstName("Angela");
			p.setLastName("Davis");
			p.setID("JS292SN");
			p.setGender(Gender.Female);
			p.setAge(63);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.normalBreathing = true;
			t.shock = true;
			t.normalPulse = true;
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
			 * EXPECTED RESULT: LEVEL 1 IMMEDIATE
			 * RESULT: LEVEL 1 IMMEDIATE
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
