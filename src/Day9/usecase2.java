package Day9;
import java.util.LinkedList;

class Patients{
    String name;
    int age;
    String disease;
    
    public Patients(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
    
    @Override
    public String toString() {
    	return "Name: " + name + ", Age: " + age + ", Disease: " + disease;
    }       
}

class HospitalQueue{
	private LinkedList<Patients> queue = new LinkedList<>();
	
	public void addPatient(String name, int age, String disease) {
		queue.addLast(new Patients(name, age, disease));
		System.out.println(name + " added to queue.");
	}
	
    public void addEmergencyPatient(String name, int age, String disease) {
        queue.addFirst(new Patients(name, age, disease));
        System.out.println(name + " added as EMERGENCY!");
    }
    
    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("No patients in queue.");
        } 
        else {
            Patients p = queue.removeFirst();
            System.out.println(p.name + " has been treated.");
        }

    }
    
    public void viewQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;

        }

        System.out.println("\n--- Patient Queue ---");
        for (Patients p : queue) {
            System.out.println(p);
        }

    }

    public void firstPatient() {
        if (!queue.isEmpty()) {
            System.out.println("First: " + queue.getFirst());
        }

    }

    public void lastPatient() {
        if (!queue.isEmpty()) {
            System.out.println("Last: " + queue.getLast());
        }

    }

}

public class usecase2 {
    public static void main(String[] args) {
        HospitalQueue hospital = new HospitalQueue();
        hospital.addPatient("Ramesh", 25, "Fever");
        hospital.addPatient("Suresh", 40, "Cold");
        hospital.addEmergencyPatient("Rao", 60, "Heart Attack");
        hospital.viewQueue();
        hospital.firstPatient();
        hospital.lastPatient();
        hospital.treatPatient();
        hospital.viewQueue();
        
        

    }

}

