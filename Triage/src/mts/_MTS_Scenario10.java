package mts;

class _MTS_Scenario10 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 10 ======");
			
			Patient p = new Patient();
			p.setFirstName("John");
			p.setLastName("Doe");
			p.setID("QE248DW");
			p.setGender(Gender.Male);
			p.setAge(56);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.inadequateBreathing = true;
			t.cardiacPain = true;
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
