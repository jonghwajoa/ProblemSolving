import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		while (n-- > 0) {
			String[] inputLine = sc.nextLine().split(" ");
			int HP = Integer.parseInt(inputLine[0]);
			int MP = Integer.parseInt(inputLine[1]);
			int ATTACK = Integer.parseInt(inputLine[2]);
			int DEFENSE = Integer.parseInt(inputLine[3]);

			HP += Integer.parseInt(inputLine[4]);
			MP += Integer.parseInt(inputLine[5]);
			ATTACK += Integer.parseInt(inputLine[6]);
			DEFENSE += Integer.parseInt(inputLine[7]);

			HP = HP > 0 ? HP : 1;
			MP = MP > 0 ? MP : 1;
			ATTACK = ATTACK > 0 ? ATTACK : 0;

			System.out.println(HP + MP * 5 + 2 * ATTACK + 2 * DEFENSE);
		}

	}
}