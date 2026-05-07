package Day3;
class Voter{
	private String name;
	private int age;
	private boolean voted;
	
	public void setVote(String name, int age) {
		this.name = name;
		this.age = age;
		this.voted= true;
	}
	public void vote() {
		if(age>=18 && !voted) {
			System.out.println(name + "voted successfully");
			voted = true;
		}
		else if(voted) {
			
			System.out.println("Already voted");
		}
		else {
			System.out.println("Not Eligible for vote");
		}
	}
	
}
public class voting {
	public static void main(String[] args) {
		Voter vt = new Voter();
		vt.setVote("Sai",22);
		//System.out.println(vt.setVote());
	}

}
