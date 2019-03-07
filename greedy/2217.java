import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] array = new int[100001];

		int ans = 0;
		int acc = 0;
		for (int i = 0; i < n; i++) {
			array[sc.nextInt()] += 1;
		}

		for (int i = 1; i < 100001; i++) {
			if(array[i] !=0) {
				int tmp = (n - acc) * i;
				acc += array[i];
				if(ans < tmp) {
					ans = tmp;
				}
			}
		}
		
		System.out.println(ans);
	}
}
