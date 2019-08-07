package esi;

class TreatedPatient extends Patient {
	Boolean requiresLifeSavingIntervention = false;
	Boolean highRiskSituation = false;
	Boolean confused = false;
	Boolean disoriented = false;
	Boolean lethargic = false;
	Boolean severePain = false;
	Boolean distress = false;
	Integer resourcesRequired = 0;
	Integer heartRate = 0;
	Integer respiratoryRate = 0;
	Integer saO2 = 0;
	
	//@ requires res >= 0;
	//@ ensures this.resourcesRequired == res;
	void setResourcesRequired(Integer res) { this.resourcesRequired = res; }
	
	//@ requires hr >= 0;
	//@ ensures this.heartRate == hr;
	void setHeartRate(Integer hr) { this.heartRate = hr; }
	
	//@ requires rr >= 0;
	//@ ensures this.respiratoryRate == rr;
	void setRespiratoryRate(Integer rr) { this.respiratoryRate = rr; }
	
	//@ requires saO2 >= 0;
	//@ ensures this.saO2 == saO2;
	void setSaO2Level(Integer saO2) { this.saO2 = saO2; }
	
	//@ ensures \result == resourcesRequired;
	/*@ pure @*/ Integer getResourcesRequired() { return resourcesRequired; }
	
	//@ ensures \result == heartRate;
	/*@ pure @*/ Integer getHeartRate() { return heartRate; }
	
	//@ ensures \result == respiratoryRate;
	/*@ pure @*/ Integer getRespiratoryRate() { return respiratoryRate; }
	
	//@ ensures \result == saO2;
	/*@ pure @*/ Integer getSaO2Level() { return saO2; }
}
