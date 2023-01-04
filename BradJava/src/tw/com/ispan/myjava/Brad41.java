package tw.com.ispan.myjava;

import java.util.HashMap;
import java.util.Set;

public class Brad41 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Brad");
		map.put("gender", false);
		map.put("weight", 80.2);
		System.out.println(map.get("weight"));
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.printf("%s => %s\n", key, map.get(key));
		}
	}

}
