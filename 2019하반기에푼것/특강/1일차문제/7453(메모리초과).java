import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static int N, target;
	static int[] a, b, c, d;

	static HashMap<Integer, Long> map1, map2;

	public static void main(String[] argv) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new int[N];
		b = new int[N];
		c = new int[N];
		d = new int[N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			a[i] = Integer.parseInt(line[0]);
			b[i] = Integer.parseInt(line[1]);
			c[i] = Integer.parseInt(line[2]);
			d[i] = Integer.parseInt(line[3]);
		}

		map1 = new HashMap<>();
		map2 = new HashMap<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum1 = a[i] + b[j];
				int sum2 = c[i] + d[j];
				map1.put(sum1, map1.containsKey(sum1) ? map1.get(sum1) + 1 : 1);
				map2.put(sum2, map2.containsKey(sum2) ? map2.get(sum2) + 1 : 1);
			}
		}

		long ans = 0;
		for (Integer key : map1.keySet()) {
			int findKey = key * -1;
			if (map2.containsKey(findKey)) {
				ans += map1.get(key) * map2.get(findKey);
			}
		}
		System.out.println(ans);
	}
}
