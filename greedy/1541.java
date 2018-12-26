import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int len = input.length();
		LinkedList<Integer> op = new LinkedList<Integer>();
		LinkedList<Integer> val = new LinkedList<Integer>();
		int num = 0;
		op.add(1);
		for (int i = 0; i < len; i++) {
			char cur = input.charAt(i);
			if (cur == '-' || cur == '+') {
				if (cur == '-') {
					op.add(-1);
				} else {
					op.add(1);
				}
				val.add(num);
				num = 0;
			} else {
				num = num * 10 + Character.getNumericValue(cur);
			}
		}
		val.add(num);
		boolean isSub = false;
		int ans = 0;
		len = val.size();
		for (int i = 0; i < len; i++) {
			int oper = op.get(i);
			if (oper == -1) {
				isSub = true;
			}

			if (isSub) {
				ans -= val.get(i);
			} else {
				ans += val.get(i);
			}
		}

		System.out.println(ans);
	}
}
