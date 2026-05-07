package Day9;
import java.util.ArrayList;
class Patient{
	String name;
	int age;
	String disease;
	
	public Patient(String name, int age, String disease) {
		this.name=name;
		this.age=age;
		this.disease=disease;
		}
	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Disease: " + disease;
		
	}
}
class PatientManagementSystem{
	private ArrayList<Patient> patients = new ArrayList<>();
	
	public void addPatient(String name, int age, String disease) {
		patients.add(new Patient(name, age, disease));
		System.out.println(name + " added successfully");
	}
	
	public void viewPatients() {
		if(patients.isEmpty()) {
			System.out.println("No patients available");
			return;
		}
		for(Patient p : patients) {
			System.out.println(p);
			
		}
	}
	public void searchPatient(String name) {
		boolean found = false;
		
		for(Patient p : patients) {
			if (p.name.equalsIgnoreCase(name)) {
				System.out.println("Found: " + p);
                found = true;
			}
		}
		if(!found) {
			System.out.println("Patient not found");
		}
	}
}

public class usecase1 {

	public static void main(String[] args) {
		PatientManagementSystem system = new PatientManagementSystem();
		system.addPatient("Ramesh", 25, "Fever");
        system.addPatient("Suresh", 40, "Cold");
        system.viewPatients();
        system.searchPatient("Ramesh");
        system.searchPatient("Suresh");
		
	}

}
