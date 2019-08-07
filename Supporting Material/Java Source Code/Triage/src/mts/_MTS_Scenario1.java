package mts;

class _MTS_Scenario1 {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("===== MTS Test Case 1 ======");
			
			Patient p = new Patient();
			p.setFirstName("Joe");
			p.setLastName("Smith");
			p.setID("AB123CD");
			p.setGender(Gender.Male);
			p.setAge(32);
			p.displayInfo();
			
			TreatedPatient t = new TreatedPatient();
			Severity s = new Severity();
			
			t.obtain_patient_info = true;
			t.inadequateBreathing = true;
			
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
