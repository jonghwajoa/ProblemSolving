import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int ans = 0;
		int length = line[0].length();
		for (int i = length - 1; 0 <= i; i--) {
			int charNum = line[0].charAt(i);
			
			if('0' <= charNum && charNum <= '9') {
				charNum = charNum - '0';
			} else {
				charNum = charNum - 'A' + 10;
			}
			ans += charNum * Math.pow(Integer.parseInt(line[1]), length -i -1);
		}
		System.out.println(ans);
	}

}