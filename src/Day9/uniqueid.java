package Day9;

import java.util.HashSet;

class Pat{
	int id;
	String name;
	int age;
	
	public Pat(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	

	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pat p = (Pat) obj;
		return this.id ==  p.id;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Age: " + age;
	}
	
}


public class uniqueid {
	public static void main(String[] args) {
		HashSet<Pat> set = new HashSet<>();
		
		Pat p1 = new Pat(101, "Ramesh", 26);
        Pat p2 = new Pat(102, "Suresh", 28);
        Pat p3 = new Pat(101, "Rao", 44);
        
        if (!set.add(p1)) {

            System.out.println("Already registered: " + p1.id);
        } 
        else {
            System.out.println("Patient added: " + p1.id);
        }
        
        if (!set.add(p2)) {
            System.out.println("Already registered: " + p2.id);
        } 
        else {
            System.out.println("Patient added: " + p2.id);
        }
        
        if (!set.add(p3)) {
            System.out.println("Already registered: " + p3.id);
        } 
        else {
            System.out.println("Patient added: " + p3.id);
        }
        
        
        System.out.println("\nUnique Patient List");
        for (Pat p : set) {
            System.out.println(p);
        }
	}

}
