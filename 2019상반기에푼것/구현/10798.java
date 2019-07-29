import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = new String[5];

        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            line = line + "                              ";
            input[i] = line.substring(0, 15);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                ans.append(input[j].charAt(i));
            }
        }
        System.out.println(ans.toString().replaceAll(" ", ""));
    }
}
