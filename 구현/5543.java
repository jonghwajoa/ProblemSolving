import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int burgerPriceMin = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int burgurPirce = sc.nextInt();
            if (burgurPirce < burgerPriceMin) {
                burgerPriceMin = burgurPirce;
            }
        }

        int drinkPriceMin = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int drinkPrice = sc.nextInt();
            if (drinkPrice < drinkPriceMin) {
                drinkPriceMin = drinkPrice;
            }
        }

        System.out.println(drinkPriceMin + burgerPriceMin - 50);
    }
}