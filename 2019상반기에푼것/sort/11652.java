import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());

		Map<Long, Integer> map = new HashMap<Long, Integer>();

		while (repeat-- > 0) {
			long input = Long.parseLong(br.readLine());
			if (map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			} else {
				map.put(input, 1);
			}
		}

		long ans = 0;
		int max =0;
		for(long key : map.keySet()) {
			if(max < map.get(key)) {
				max = map.get(key);
				ans = key;
			} else if (max == map.get(key) && key < ans ) {
				ans = key;
			}
		}
		
		System.out.println(ans);
	}
}