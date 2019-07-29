import java.util.Scanner;

public class Main {
	static int[] d = new int[12];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		d[1] = 1;
		d[2] = 2;
		d[3] = 4;

		for (int i = 4; i <= 11; i++) {
			d[i] = d[i - 1] + d[i - 2] + d[i - 3];
		}
		
		while(N-- > 0) {
			System.out.println(d[sc.nextInt()]);
		}
	}
}
