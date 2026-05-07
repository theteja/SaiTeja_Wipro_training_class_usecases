package Day4;
import java.util.*;
class Patient{
	private int id;
	private String name;
	private int age;
	private String illness;
	
	
	public Patient(int id, String name, int age,String illness) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.illness = illness;
	}
	
	public int getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getIllness(){
		return illness;
	}		
}

interface PatientService {
    void registerPatient(Patient p);
    void detailsPatient();
}

// Implementation using ARRAY
class PatientServiceImpl implements PatientService {

    private Patient[] patients = new Patient[10]; // fixed size array
    private int count = 0; // to track number of patients added

    // Add patient
    public void registerPatient(Patient p) {
        if (count < patients.length) {
            patients[count] = p;
            count++;
        } else {
            System.out.println("Storage Full");
        }
    }

    // Display patients
    public void detailsPatient() {
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + patients[i].getId());
            System.out.println("Name: " + patients[i].getName());
            System.out.println("Age: " + patients[i].getAge());
            System.out.println("Illness: " + patients[i].getIllness());
        }
    }
}

abstract class Doctor{
	protected String name;
	protected String specialization;
	
	public Doctor() {
		
	}
	abstract void diagnose(Patient patient);	
}




class GeneralPhysician extends Doctor{
	public GeneralPhysician(String name) {
		this.name =name;
		this.specialization = "General";
	}
	void diagnose(Patient patient) {
		System.out.println(name + " diagnosed "+patient.getName() + " for " + patient.getIllness());
	}
}

class Cardiologist extends Doctor{
	public Cardiologist(String name) {
		this.name =name;
		this.specialization = "Cardiologist";
	}
	void diagnose(Patient patient) {
		if(patient.getIllness().equalsIgnoreCase("Heart")) {
			System.out.println(name + " treating heart patient "+ patient.getName());
		}
	}

}




public class healthcare {
	public static void main(String[] args) {
		PatientService sc = new PatientServiceImpl();
		Patient p1 = new Patient(1, "Sai", 22, "Fever");
		Patient p2 = new Patient(2, "Ravi", 55, "Heart");
		
		sc.registerPatient(p1);
		sc.registerPatient(p2);
		
		System.out.println("Patients:");
		sc.detailsPatient();
		
		
		Doctor d1 = new GeneralPhysician("Dr.Rao");
		Doctor d2 = new Cardiologist("Dr.Ramesh");
		
		System.out.println("\nDiagnosis");
		d1.diagnose(p1);
		d2.diagnose(p2);
		
		
		
	}

}
