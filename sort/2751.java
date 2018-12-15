import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        int []input = new int[repeat];
        
        for(int i=0; i< repeat ; i++) {
        	input[i] = sc.nextInt();
        }
        
        Arrays.sort(input);
        for(int val : input) {
        	System.out.println(val);
        }
    }
}