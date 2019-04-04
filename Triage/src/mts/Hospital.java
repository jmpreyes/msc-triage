package mts;

class Hospital {
	String name = "";
	String phone = "";
	String address = "";
	
	//@ requires name != null;
	//@ ensures this.name == name;
	void setName(String name) { this.name = name; }
	
	//@ requires phone != null;
	//@ ensures this.phone == phone;
	void setPhone(String phone) { this.phone = phone; }
	
	//@ requires address != null;
	//@ ensures this.address == address;
	void setAddress(String address) { this.address = address; }
	
	//@ ensures \result == name;
	/*@ pure @*/String getName() { return name; }
	
	//@ ensures \result == phone;
	/*@ pure @*/String getPhone() { return phone; }
	
	//@ ensures \result == address;
	/*@ pure @*/String getAddress() { return address; }
}
