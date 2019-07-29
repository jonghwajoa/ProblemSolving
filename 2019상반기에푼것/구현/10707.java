import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int xCompanyLiterPrice = sc.nextInt();
        int yCompanyLiterPrice = sc.nextInt();
        int yCompanyMaxDefaultLiter = sc.nextInt();
        int yCompanyAdditionalFee = sc.nextInt();
        int useWater = sc.nextInt();

        int paymentXCompany = useWater * xCompanyLiterPrice;
        int paymentYCompany = yCompanyLiterPrice;

        if (yCompanyMaxDefaultLiter < useWater) {
            int excessWater = useWater - yCompanyMaxDefaultLiter;
            paymentYCompany += excessWater * yCompanyAdditionalFee;
        }

        System.out.println(Math.min(paymentXCompany, paymentYCompany));
    }
}