import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int repeat = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < repeat; i++) {
			int cur = Integer.parseInt(input[i]);
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			} else {
				map.put(cur, 1);
			}
		}

		repeat = Integer.parseInt(br.readLine());
		String[] testVal = br.readLine().split(" ");

		for (int i = 0; i < repeat; i++) {
			int cur = Integer.parseInt(testVal[i]);
			if (map.containsKey(cur)) {
				System.out.print(map.get(cur) + " ");
			} else {
				System.out.print("0 ");
			}
		}
	}
}