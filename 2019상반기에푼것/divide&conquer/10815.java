import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		
		int repeat = sc.nextInt();
		
		while(repeat-- > 0) {
			set.add(sc.nextInt());
		}
		
		repeat = sc.nextInt();
		
		while(repeat --> 0) {
			if(set.contains(sc.nextInt())) {
				System.out.print(1+" ");
			} else {
				System.out.print(0+" ");
			}
				
		}
	}
}