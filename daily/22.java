public class Main {

	public static void main(String[] args) throws Exception {

		int[] input = { 1, 2, 3, 7, 10 };
		solve(input, 7);

		int[] input2 = { -5, -3, 0, 1 };
		solve(input2, 0);

		int[] input3 = { 1, 4, 5, 6, 8, 9 };
		solve(input3, 10);
	}

	public static void solve(int[] input, int target) {
		int left = 0;
		int right = input.length - 1;

		boolean flag = false;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (input[mid] < target) {
				left = mid + 1;
			} else if (target < input[mid]) {
				right = mid - 1;
			} else {
				flag = true;
				break;
			}
		}

		System.out.println(flag);
	}

}
