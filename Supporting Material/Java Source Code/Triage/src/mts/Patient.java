package mts;

class Patient {
	String firstName = "";
	String lastName = "";
	String id = "";
	Gender gender = Gender.Male;
	Integer age = 0;
	Boolean obtain_patient_info = false;
	Boolean examined_airway = false;
	Boolean examined_breathing = false;
	Boolean checked_patient_for_shock = false;
	Boolean pain_measured = false;
	Boolean cardiac_pain_examined = false;
	Boolean breathing_rate_measured = false;
	Boolean pulse_checked = false;
	Boolean pleuritic_pain_examined = false;
	Boolean checked_for_persistent_vomiting = false;
	Boolean examine_patients_cardiac_history = false;
	Boolean pain_remeasured = false;
	Boolean vomiting_checked = false;
	Boolean mild_pain_examined = false;
	Boolean problems_checked = false;
	Boolean resuscitation_in_action = false;
	Boolean patient_stabilized = false;
	Boolean patient_supervised = false;
	Boolean patient_reassessed = false;
	
	//@ requires f != null;
	//@ ensures this.firstName == f;
	void setFirstName(String f) { this.firstName = f; }
	
	//@ requires l != null;
	//@ ensures this.lastName == l;
	void setLastName(String l) { this.lastName = l; }
	
	//@ requires i != null;
	//@ ensures this.id == i;
	void setID(String i) { this.id = i; }
	
	//@ requires g != null;
	//@ ensures this.gender == g;
	void setGender(Gender g) { this.gender = g; }
	
	//@ requires a > 0;
	//@ ensures this.age == a;
	void setAge(int a) { this.age = a; }
	
	//@ ensures \result == firstName;
	/*@ pure @*/ String getFirstName() { return firstName; }
	
	//@ ensures \result == lastName;
	/*@ pure @*/ String getLastName() { return lastName; }
	
	//@ ensures \result == id;
	/*@ pure @*/ String getID() { return id; }
	
	//@ ensures \result == gender;
	/*@ pure @*/ Gender getGender() { return gender; }
	
	//@ ensures \result == age;
	/*@ pure @*/ Integer getAge() { return age; }
	
	void displayInfo() {
		System.out.println("First Name: " + getFirstName() + 
					      "\nLast Name: " + getLastName() + 
					      "\nID: " + getID() + 
					      "\nGender: " + getGender() + 
					      "\nAge: " + getAge() + "\n");
	}
}
