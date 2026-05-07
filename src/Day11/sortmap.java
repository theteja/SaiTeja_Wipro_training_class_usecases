package Day11;
import java.util.*;
public class sortmap {
	public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");
        Map<Integer, String> sortedMap = new TreeMap<>(map);
        System.out.println("Sorted Map by Keys:");
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());

        }

    }

}
