import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());
		int[][] input = new int[repeat][2];

		for (int i = 0; i < repeat; i++) {
			String[] line = sc.nextLine().split("\\s+");
			input[i][0] = Integer.parseInt(line[0]);
			input[i][1] = Integer.parseInt(line[1]);
		}

		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		for(int i=0; i<repeat; i++) {
			System.out.println(input[i][0] + " " + input[i][1]);
		}
	}
}