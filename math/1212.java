import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int length = str.length();
		StringBuilder br = new StringBuilder();
		for (int i = 0; i < length; i++) {
			br.setLength(0);
			int num = str.charAt(i) - '0';
			br.insert(0, num % 2);
			num /= 2;
			br.insert(0, num % 2);
			num /= 2;
			br.insert(0, num % 2);
			num /= 2;
			if (i == 0 && br.charAt(0) == '0') {
				br.deleteCharAt(0);
				if (br.charAt(0) == '0') {
					br.deleteCharAt(0);
				}
			}
			System.out.print(br.toString());
		}
		System.out.println();
	}
}