import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());
		Person[] person = new Person[repeat];

		for (int i = 0; i < repeat; i++) {
			String[] line = sc.nextLine().split("\\s+");
			person[i] = new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
					Integer.parseInt(line[3]));
		}

		Arrays.sort(person);

		for (int i = 0; i < repeat; i++) {
			System.out.println(person[i].name);
		}

	}
}

class Person implements Comparable<Person> {
	String name;
	int lang;
	int eng;
	int math;

	public Person(String name, int lang, int eng, int math) {
		this.name = name;
		this.lang = lang;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Person that) {
		if (this.lang == that.lang) {
			if (this.eng == that.eng) {
				if (this.math == that.math) {
					return this.name.compareTo(that.name);
				}
				return that.math - this.math;
			}
			return this.eng - that.eng;
		}
		return that.lang - this.lang;
	}
}