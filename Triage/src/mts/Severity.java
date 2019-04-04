package mts;

class Severity {
	SeverityLevel severity = SeverityLevel.Urgent;
	
	//@ requires severity != null;
	//@ ensures this.severity == s;
	void setSeverityLevel(SeverityLevel s) { this.severity = s; }
	
	//@ ensures \result == severity;
	/*@ pure @*/ SeverityLevel getSeverityLevel() { return severity; }
	
	//@ requires p.obtain_patient_info == true;
	//@ ensures p.examined_airway == true;
	void examineAirway(TreatedPatient p) {
		System.out.println("Examining patient's airway");
		if (p.obtain_patient_info == true) {
			if (p.airwayCompromise == true) {
				System.out.println("\tPatient's airway is compromised");
				setSeverityLevel(SeverityLevel.Immediate);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.examined_airway = true;
		} else {
			System.out.println("*** Obtain patient information before examination of airway ***\n");
		}
	}
	
	//@ requires p.examined_airway == true;
	//@ ensures p.examined_breathing == true;
	void checkForAdequateBreathing(TreatedPatient p) {
		System.out.println("Checking for adequate breathing");
		if (p.examined_airway == true) {
			if (p.inadequateBreathing == true) {
				System.out.println("\tPatient has inadequate breathing");
				setSeverityLevel(SeverityLevel.Immediate);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.examined_breathing = true;
		} else {
			System.out.println("*** Examine patient's airway before checking for adequate breathing ***\n");
		}
	}
	
	//@ requires p.examined_airway == true || p.examined_breathing == true;
	//@ ensures p.checked_patient_for_shock == true;
	void checkForShock(TreatedPatient p) {
		System.out.println("Checking for signs of shock");
		if (p.examined_airway == true || p.examined_breathing == true) {
			if (p.shock == true) {
				System.out.println("\tPatient shows signs of shock");
				setSeverityLevel(SeverityLevel.Immediate);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.checked_patient_for_shock = true;
		} else {
			System.out.println("*** Examine airway or breathing before checking for signs of shock ***\n");
		}
	}
	
	//@ requires p.checked_patient_for_shock == true;
	//@ ensures p.pain_measured == true;
	void measurePain(TreatedPatient p) {
		System.out.println("Measuring levels of pain");
		if (p.checked_patient_for_shock == true) {
			if (p.severePain == true) {
				System.out.println("\tPatient is in severe pain");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.moderatePain == true ) {
				System.out.println("\tPatient is in moderate pain");
				setSeverityLevel(SeverityLevel.Urgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.minorPain == true) {
				System.out.println("\tPatient is in minor pain");
				setSeverityLevel(SeverityLevel.Standard);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.pain_measured = true;
		} else {
			System.out.println("*** Check patient for shock before measuring pain ***\n");
		}
	}
	
	//@ requires p.pain_measured == true;
	//@ ensures p.cardiac_pain_examined == true;
	void examineCardiacPain(TreatedPatient p) {
		System.out.println("Examination for cardiac pain");
		if (p.pain_measured == true) {
			if (p.cardiacPain == true) {
				System.out.println("\tPatient has cardiac pain");
				setSeverityLevel(SeverityLevel.Urgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.cardiac_pain_examined = true;
		} else {
			System.out.println("*** Measure levels of pain before examination of cardiac pain ***\n");
		}
	}
	
	//@ requires p.pain_measured == true && p.cardiac_pain_examined == true;
	//@ ensures p.breathing_rate_measured == true;
	void measureBreathingRate(TreatedPatient p) {
		System.out.println("Measuring patient's breathing rate");
		if (p.pain_measured == true && p.cardiac_pain_examined == true) {
			if (p.inadequateBreathing == true) {
				System.out.println("\tPatient has inadequate breathing");
				setSeverityLevel(SeverityLevel.Immediate);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.acutelyShortBreath == true) {
				System.out.println("\tPatient has acute breathing rate");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.normalBreathing == true) {
				System.out.println("\tPatient has normal breathing rate");
				setSeverityLevel(SeverityLevel.Standard);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.breathing_rate_measured = true;
		} else {
			System.out.println("*** Measure levels of pain and examine for cardiac pain before measuring breathing rate ***\n");
		}
	}
	
	//@ requires p.pain_measured == true && p.cardiac_pain_examined == true && p.breathing_rate_measured == true;
	//@ ensures p.pulse_checked == true;
	void checkPulse(TreatedPatient p) {
		System.out.println("Checking patient's pulse");
		if (p.pain_measured == true && p.cardiac_pain_examined == true && p.breathing_rate_measured == true) {
			if (p.abnormalPulse == true) {
				System.out.println("\tPatient has abnormal pulse");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.normalPulse == true) {
				System.out.println("\tPatient has normal pulse");
				setSeverityLevel(SeverityLevel.Standard);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.pulse_checked = true;
		} else {
			System.out.println("*** Measure levels of pain, examine for cardiac pain and breathing rate before checking for pulse ***\n");
		}
	}
	
	//@ requires p.pulse_checked == true;
	//@ ensures p.pleuritic_pain_examined == true;
	void examinePleuriticPain(TreatedPatient p) {
		System.out.println("Checking for pleuritic pain");
		if (p.pulse_checked == true) {
			if (p.pleuriticPain == true) {
				System.out.println("\tPatient has pleuritic pain");
				setSeverityLevel(SeverityLevel.Urgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.pleuritic_pain_examined = true;
		} else {
			System.out.println("*** Check patient's pulse before examination for pleuritic pain ***\n");
		}
	}
	
	//@ requires p.pleuritic_pain_examined == true;
	//@ ensures p.checked_for_persistent_vomiting == true;
	void checkForPersistentVomiting(TreatedPatient p) {
		System.out.println("Checking for persistent vomiting");
		if (p.pleuritic_pain_examined == true) {
			if (p.persistentVomiting == true) {
				System.out.println("\tPatient has persistent vomiting");
				setSeverityLevel(SeverityLevel.Urgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.checked_for_persistent_vomiting = true;
		} else {
			System.out.println("*** Check for pleuritic pain before checking for persistent vomiting ***\n");
		}
	}
	
	//@ requires p.pleuritic_pain_examined == true && p.checked_for_persistent_vomiting == true;
	//@ ensures p.examine_patients_cardiac_history == true;
	void examineForCardiacHistory(TreatedPatient p) {
		System.out.println("Checking for patient's cardiac history");
		if (p.pleuritic_pain_examined == true && p.checked_for_persistent_vomiting == true) {
			if (p.significantCardiacHistory == true) {
				System.out.println("\tPatient has significant cardiac history");
				setSeverityLevel(SeverityLevel.Urgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.examine_patients_cardiac_history = true;
		} else {
			System.out.println("*** Check for pleuritic pain and persistent vomiting before examination of cardiac history ***\n");
		}
	}
	
	//@ requires p.pleuritic_pain_examined == true && p.checked_for_persistent_vomiting == true && p.examine_patients_cardiac_history == true;
	//@ ensures p.pain_remeasured == true;
	void remeasureForPain(TreatedPatient p) {
		System.out.println("Remeasuring patient's levels of pain");
		if (p.pleuritic_pain_examined == true && p.checked_for_persistent_vomiting == true && p.examine_patients_cardiac_history == true) {
			measurePain(p);
			p.pain_remeasured = true;
		} else {
			System.out.println("*** Check for pleuritic pain, persistent vomiting, and examine patient's cardiac history before remeasuring levels of pain ***\n");
		}
	}
	
	//@ requires p.pain_remeasured == true;
	//@ ensures p.vomiting_checked == true;
	void checkVomiting(TreatedPatient p) {
		System.out.println("Checking for vomiting");
		if (p.pain_remeasured == true) {
			if (p.recentVomiting == true) {
				System.out.println("\tPatient has recent vomiting");
				setSeverityLevel(SeverityLevel.Standard);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.vomiting_checked = true;
		} else {
			System.out.println("*** Remeasure patient's levels of pain before checking for vomiting ***\n");
		}
	}
	
	//@ requires p.vomiting_checked == true;
	//@ ensures p.mild_pain_examined == true;
	void examineForMildPain(TreatedPatient p) {
		System.out.println("Checking for recent mild pain");
		if (p.vomiting_checked == true) {
			if (p.recentMildPain == true) {
				System.out.println("\tPatient has recent mild pain");
				setSeverityLevel(SeverityLevel.Standard);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.mild_pain_examined = true;
		} else {
			System.out.println("*** Check for vomiting before examination of recent mild pain ***\n");
		}
	}
	
	//@ requires p.vomiting_checked == true && p.mild_pain_examined == true;
	//@ ensures p.problems_checked == true;
	void checkForProblems(TreatedPatient p) {
		System.out.println("Checking for recent problems");
		if (p.vomiting_checked == true && p.mild_pain_examined == true) {
			if (p.recentProblem == true) {
				System.out.println("\tPatient has recent problem");
				setSeverityLevel(SeverityLevel.Standard);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tSupervise patient\n");
			}
			p.problems_checked = true;
		} else {
			System.out.println("*** Check for vomiting and examine for recent mild pain before checking for recent problems ***\n");
		}
	}
}
