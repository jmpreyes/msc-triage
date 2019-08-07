package esi;

class Severity {
	SeverityLevel severity = SeverityLevel.Urgent;
	
	//@ requires severity != null;
	//@ ensures this.severity == severity;
	void setSeverityLevel(SeverityLevel severity) { this.severity = severity; }
	
	//@ ensures \result == severity;
	/*@ pure @*/ SeverityLevel getSeverityLevel() { return severity; }

	//@ requires p.obtain_patient_info == true;
	//@ ensures p.checked_for_immediate_intervention == true;
	void checkIfInterventionNeeded(TreatedPatient p) {
		System.out.println("Check if immediate intervention is required");
		if (p.obtain_patient_info == true) {
			if (p.requiresLifeSavingIntervention == true) {
				System.out.println("\tPatient requires life saving intervention");
				setSeverityLevel(SeverityLevel.Immediate);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient does not require life saving intervention\n");
			}
			p.checked_for_immediate_intervention = true;
		} else {
			System.out.println("*** Obtain patient information before checking if intervention is needed ***\n");
		}
	}
	
	//@ requires p.checked_for_immediate_intervention == true;
	//@ ensures p.situation_assessed == true;
	void assessSituation(TreatedPatient p) {
		System.out.println("Assess patient's situation");
		if (p.checked_for_immediate_intervention == true) {
			if (p.highRiskSituation == true) {
				System.out.println("\tPatient is in high risk situation");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient is not in high risk situation\n");
			}
			p.situation_assessed = true;
		} else {
			System.out.println("*** Check for immediate intervention before assessing situation ***\n");
		}
	}
	
	//@ requires p.situation_assessed == true;
	//@ ensures p.examined_if_confused == true || p.examined_if_disoriented == true || p.examined_if_lethargic == true;
	void examine(TreatedPatient p) {
		System.out.println("Examine patient");
		if (p.situation_assessed == true) {
			if (p.confused == true) {
				System.out.println("\tPatient is confused");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient is not confused\n");
			}
			p.examined_if_confused = true;
			
			if (p.disoriented == true) {
				System.out.println("\tPatient is disoriented");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient is not disoriented\n");
			}
			p.examined_if_disoriented = true;
			
			if (p.lethargic == true) {
				System.out.println("\tPatient is lethargic");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient is not lethargic\n");
			}
			p.examined_if_lethargic = true;
		} else {
			System.out.println("*** Assess situation before examination ***\n");
		}
	}
	
	//@ requires p.situation_assessed == true;
	//@ requires p.examined_if_confused == true || p.examined_if_disoriented == true || p.examined_if_lethargic == true;
	//@ ensures p.checked_if_severe_pain == true || p.checked_if_distressed == true;
	void checkForPain(TreatedPatient p) {
		System.out.println("Check for severe pain or distress");
		if (p.situation_assessed == true && (p.examined_if_confused == true || p.examined_if_disoriented == true || p.examined_if_lethargic == true)) {
			if (p.severePain == true) {
				System.out.println("\tPatient is in severe pain");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient is not in severe pain\n");
			}
			p.checked_if_severe_pain = true;
			
			if (p.distress == true) {
				System.out.println("\tPatient is in distress");
				setSeverityLevel(SeverityLevel.VeryUrgent);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else {
				System.out.println("\tPatient is not in distress\n");
			}
			p.checked_if_distressed = true;
		} else {
			System.out.println("*** Assess situation and examine if patient is either confused, disoriented, or lethargic before checking for pain ***\n");
		}
	}
	
	//@ requires (p.checked_if_severe_pain == true || p.checked_if_distressed == true) && p.resources > 0;
	//@ ensures p.number_resources_assessed == true;
	void checkResourcesNeeded(TreatedPatient p) {
		System.out.println("Check required resources");
		if ((p.checked_if_severe_pain == true || p.checked_if_distressed == true) && p.getResourcesRequired() > 0) {
			if (p.getResourcesRequired() == 0) {
				System.out.println("\tPatient does not need resources");
				setSeverityLevel(SeverityLevel.Delayed);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.getResourcesRequired() == 1) {
				System.out.println("\tPatient needs only one resource");
				setSeverityLevel(SeverityLevel.Minor);
				System.out.println("\t\t=> " + getSeverityLevel() + "\n");
			} else if (p.getResourcesRequired() > 1) {
				System.out.println("\tPatient needs more than one resource\n");
				p.number_resources_assessed = true;
				measureVitalZones(p);
			}
			p.number_resources_assessed = true;
		} else {
			System.out.println("*** Check for severe pain or distress before checking resources needed ***\n");
		}
	}
	
	// Age is set to int (years), SaO2 % levels as int
	//@ requires p.number_resources_assessed == true && p.resources > 1;
	//@ ensures p.vitals_examined == true;
	private void measureVitalZones(TreatedPatient p) {
		System.out.println("\tMeasure vital signs");
		if (p.number_resources_assessed == true && p.getResourcesRequired() > 1) {
			if (p.getAge() < 1) {
				if (p.getHeartRate() >= 180 && p.getRespiratoryRate() >= 50 && p.getSaO2Level() < 92) {
					setSeverityLevel(SeverityLevel.VeryUrgent);
				}
			} else if (p.getAge() >= 1 && p.getAge() < 3) {
				if ((p.getHeartRate() >= 160 && p.getHeartRate() < 180) && (p.getRespiratoryRate() >= 40 && p.getRespiratoryRate() < 50) && (p.getSaO2Level() < 92)) {
					setSeverityLevel(SeverityLevel.VeryUrgent);
				}
			} else if (p.getAge() >= 3 && p.getAge() < 8) {
				if ((p.getHeartRate() >= 140 && p.getHeartRate() < 160) && (p.getRespiratoryRate() >= 30 && p.getRespiratoryRate() < 40) && (p.getSaO2Level() < 92)) {
					setSeverityLevel(SeverityLevel.VeryUrgent);
				}
			} else if (p.getAge() >= 8) {
				if ((p.getHeartRate() >= 100 && p.getHeartRate() < 140) && (p.getRespiratoryRate() >= 10 && p.getRespiratoryRate() < 30) && (p.getSaO2Level() < 92)) {
					setSeverityLevel(SeverityLevel.VeryUrgent);
				}
			} else {
				System.out.println("\tReassess vital signs\n");
			}
			p.vitals_examined = true;
			System.out.println("\t\t=> " + getSeverityLevel() + "\n");
		} else {
			System.out.println("*** Check resource assessment and verify if patient needs more than one resource ***\n");
		}
	}
}
