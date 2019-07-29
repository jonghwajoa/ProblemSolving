import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());

		while (repeat-- > 0) {
			int n = Integer.parseInt(sc.nextLine());
			String[] inputLine;

			int acc = 0;
			double accScore = 0;
			for (int i = 0; i < n; i++) {
				inputLine = sc.nextLine().split(" ");
				int tmp = Integer.parseInt(inputLine[0]);
				double score = Double.parseDouble(inputLine[1]);
				acc += tmp;
				accScore += tmp * score;
			}

			System.out.println(acc + " " + Math.round(accScore / (double) acc * 10.0) / 10.0);
		}

	}
}