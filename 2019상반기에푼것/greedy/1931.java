import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		int[][] time = new int[repeat][2];
		for (int i = 0; i < repeat; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}

		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				if (e1[1] == e2[1])
					return e1[0] - e2[0];
				return e1[1] - e2[1];
			}
		});
		int endTime = time[0][1];
		int count = 1;

		for (int i = 1; i < repeat; i++) {
			if (endTime <= time[i][0]) {
				count++;
				endTime = time[i][1];
			}
		}
		System.out.println(count);
	}
}