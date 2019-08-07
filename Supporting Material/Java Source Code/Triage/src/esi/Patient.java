package esi;

class Patient {
	String firstName = "";
	String lastName = "";
	String id = "";
	Gender gender = Gender.Male;
	Integer age = -1;
	Boolean obtain_patient_info = false;
	Boolean checked_for_immediate_intervention = false;
	Boolean situation_assessed = false;
	Boolean examined_if_confused = false;
	Boolean examined_if_disoriented = false;
	Boolean examined_if_lethargic = false;
	Boolean checked_if_severe_pain = false;
	Boolean checked_if_distressed = false;
	Boolean number_resources_assessed = false;
	Integer resources = 0;
	Boolean vitals_examined = false;
	
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
	void setAge(Integer a) { this.age = a; }
	
	//@ requires r > 0;
	//@ ensures this.resources == r;
	void setResources(Integer r) { this.resources = r; }
	
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
	
	//@ ensures \result == resources;
	/*@ pure @*/ Integer getResources() { return resources; }
	
	void displayInfo() {
		System.out.println("First Name: " + getFirstName() + 
						  "\nLast Name: " + getLastName() + 
						  "\nID: " + getID() + 
						  "\nGender: " + getGender() + 
						  "\nAge: " + getAge() + "\n");
	}
}
