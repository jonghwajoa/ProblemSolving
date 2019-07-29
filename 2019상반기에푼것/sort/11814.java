import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());
		Person []person = new Person[repeat];
		
		for(int i=0; i<repeat; i++) {
			String []line = sc.nextLine().split("\\s+");
			person[i] = new Person(Integer.parseInt(line[0]),line[1]);
		}
		
		Arrays.sort(person, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		
		for(int i=0; i<repeat; i++) {
			System.out.println(person[i].age + " " + person[i].name);
		}
		
	}
}

class Person {
	int age;
	String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}