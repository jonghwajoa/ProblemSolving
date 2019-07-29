import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputLine = sc.nextLine().split(" ");

		int n = Integer.parseInt(inputLine[0]);
		int m = Integer.parseInt(inputLine[1]);

		Medal[] contry = new Medal[n];
		int[] order = new int[n + 1];

		for (int i = 0; i < n; i++) {
			contry[i] = new Medal(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(contry);

		order[contry[0].index] = 1;
		for (int i = 1; i < n; i++) {
			Medal prev = contry[i - 1];
			if (prev.gold == contry[i].gold && prev.silver == contry[i].silver && prev.bronz == contry[i].bronz) {
				order[contry[i].index] = order[prev.index];
			} else {
				order[contry[i].index] = i + 1;
			}
		}
		System.out.println(order[m]);
	}
}

class Medal implements Comparable<Medal> {
	int index;
	int gold;
	int silver;
	int bronz;

	public Medal(int index, int gold, int silver, int bronz) {
		super();
		this.index = index;
		this.gold = gold;
		this.silver = silver;
		this.bronz = bronz;
	}

	@Override
	public int compareTo(Medal o) {
		if (this.gold == o.gold) {
			if (this.silver == o.silver) {
				return o.bronz - this.bronz;
			}
			return o.silver - this.silver;
		}
		return o.gold - this.gold;
	}
}