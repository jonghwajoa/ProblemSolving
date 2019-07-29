import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int len = N.length();
		int sum = 0;
		boolean zero = false;
		for (int i = 0; i < len; i++) {
			int cur = Character.getNumericValue(N.charAt(i));
			if (cur == 0)
				zero = true;
			sum += cur;
		}

		if (!zero || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		String[] max = N.split("");
		Arrays.sort(max, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o2) - Integer.parseInt(o1);
			}
		});

		System.out.println(String.join("", max));
		for (String val : max) {
			System.out.print(val);
		}
	}
}