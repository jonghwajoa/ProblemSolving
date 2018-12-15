import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		int ans=0;
		while(repeat-- >0) {
			if(isPrime(sc.nextInt())) {
				ans++;
			}
			
		}
		System.out.println(ans);
	}
	
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		else if (n==2) return true;
		
		for(int i=2; i <n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
}
