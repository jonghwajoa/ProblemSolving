import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		char[] array = input.toCharArray();

		int ans = 0;
		for (int i = 0; i < array.length; i++) {

			if (i != array.length - 1) {
				switch (array[i]) {
				case 'c':
					if (array[i + 1] == '=' || array[i + 1] == '-') {
						i += 1;
					}
					break;
				case 'd':
					if (array[i + 1] == '-') {
						i += 1;
					} else if (i < array.length - 2 && array[i + 1] == 'z' && array[i + 2] == '=') {
						i += 2;
					}
					break;
				case 'l':
				case 'n':
					if (array[i + 1] == 'j') {
						i += 1;
					}
					break;
				case 's':
				case 'z':
					if (array[i + 1] == '=') {
						i += 1;
					}
					break;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}