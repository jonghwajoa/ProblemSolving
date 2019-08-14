import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.HashMap;

public class Main {
	static int[] arr1, arr2;
	static int len1, len2;
	static int target;
	static HashMap<Integer, Integer> map;

	public static void main(String[] argv) throws Exception {
		getReadLine();
		map = new HashMap<>();

		for (int i = 0; i < len2; i++) {
			int acc = 0;
			for (int j = i; j < len2; j++) {
				acc += arr2[j];
				map.put(acc, map.containsKey(acc) ? map.get(acc) + 1 : 1);
			}
		}

		long ans = 0;
		for (int i = 0; i < len1; i++) {
			int acc = 0;
			for (int j = i; j < len1; j++) {
				acc += arr1[j];
				int needN = target - acc;
				if (map.containsKey(needN)) {
					ans += map.get(needN);
				}
			}
		}
		System.out.println(ans);
	}

	private static void getReadLine() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		target = Integer.parseInt(br.readLine());
		len1 = Integer.parseInt(br.readLine());
		arr1 = new int[len1];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < len1; i++) {
			arr1[i] = Integer.parseInt(input[i]);
		}

		len2 = Integer.parseInt(br.readLine());
		arr2 = new int[len2];
		input = br.readLine().split(" ");
		for (int i = 0; i < len2; i++) {
			arr2[i] = Integer.parseInt(input[i]);
		}
	}
}
