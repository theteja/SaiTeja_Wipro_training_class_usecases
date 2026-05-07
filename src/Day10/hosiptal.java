package Day10;
import java.util.*;



class HospitalSystem implements Comparable<HospitalSystem>{
		int id;
		String name;
	

	public HospitalSystem(int id , String name) {
		this.id=id;
		this.name=name;
	}

	
	public int compareTo(HospitalSystem p) {
		return this.id - p.id;
	}

	@Override
	public String toString() {
		return "Patient ID: " + id + ", Name: " + name;
	}
}
	public class hosiptal{
	public static void main(String[] args) {
		TreeSet<HospitalSystem> patients = new TreeSet<>();
		patients.add(new HospitalSystem(101, "Ramesh"));
		patients.add(new HospitalSystem(102, "Suresh"));
		patients.add(new HospitalSystem(103, "Rao"));
		patients.add(new HospitalSystem(102, "Suresh"));
		
		System.out.println("Registered Patients");
		for(HospitalSystem p : patients) {
			System.out.println(p);
		}
	}

}
