package Day10;
import java.util.*;
public class merge {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5));
		ArrayList<Integer> list3 = new ArrayList<>();
		
		for(Integer i : list1) {
			if(!list3.contains(i)) {
				list3.add(i);
			}
		}
		for(Integer i : list2) {
			if(!list3.contains(i)) {
				list3.add(i);
			}
		}
		
		System.out.println(list3);
		 
	}

}
