import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		int zeroCount = 0;
		int oneCount = 0;

		for (int i = 0; i < repeat; i++) {
			int val = sc.nextInt();
			if (val == 0)
				zeroCount++;
			else if (val == 1)
				oneCount++;
			else if (val > 0)
				plus.add(val);
			else
				minus.add(val);
		}

		Collections.sort(plus, new Comparator<Integer>() {
			@Override
			public int compare(Integer e1, Integer e2) {
				return e2 - e1;
			}
		});

		Collections.sort(minus);
		int ans = oneCount;
		if (plus.size() % 2 == 1) {
			ans += plus.remove(plus.size() - 1);
		}

		if (minus.size() % 2 == 1) {
			if (zeroCount > 0) {
				minus.remove(minus.size() - 1);
			} else {
				ans += minus.remove(minus.size() - 1);
			}
		}

		int len = plus.size();
		for (int i = 0; i < len; i += 2) {
			ans = ans + plus.get(i) * plus.get(i + 1);
		}

		len = minus.size();
		for (int i = 0; i < len; i += 2) {
			ans = ans + minus.get(i) * minus.get(i + 1);
		}

		System.out.println(ans);
	}
}