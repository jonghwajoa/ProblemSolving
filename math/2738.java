package temp;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] arr1 = new int[a * b];
		int[] arr2 = new int[a * b];

		for (int i = 0; i < a * b; i++) {
			arr1[i] = sc.nextInt();
		}

		for (int i = 0; i < a * b; i++) {
			arr2[i] = sc.nextInt();
		}

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(arr1[i * b + j] + arr2[i * b + j] + " ");
			}
			System.out.println();
		}
	}
}
