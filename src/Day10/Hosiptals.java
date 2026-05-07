package Day10;
import java.util.*;
class Patients {
    int id;
    String name;
    int age;

    public Patients(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
 class Hospitals {
    private static Map<Integer, Patients> patients = new HashMap<>();
    public static void main(String[] args) {

        addPatient(101, "Ramesh", 30);
        addPatient(102, "Suresh", 40);
        addPatient(103, "Rao", 50);
        addPatient(102, "Suresh", 60); 
        updatePatient(101, "Ramesh Updated", 31);
        getPatient(102);
        removePatient(103);
        listPatients();

    }
    public static void addPatient(int id, String name, int age) {
    	System.out.println(patients.putIfAbsent(id, new Patients(id, name, age)) == null ? "Patient added": "Patient already exists");
    }
    public static void updatePatient(int id, String name, int age) {
    	
    	System.out.println(patients.replace(id, new Patients(id, name, age)) != null? "Patient updated": "Patient not found");
    }
    public static void getPatient(int id) {
    	System.out.println( patients.get(id) != null ? "Details: " + patients.get(id): "Patient not found" );
    }
    public static void removePatient(int id) {
    	System.out.println(patients.remove(id) != null ? "Patient removed": "Patient not found");
    }
    public static void listPatients() {
    	System.out.println("\nAll Patients:");
        patients.values().forEach(System.out::println);
    }
    
    
    
 }