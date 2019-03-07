import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int packNum = n / 6;
        int piece = n % 6;

        int ans = Integer.MAX_VALUE;
        boolean existPiece = false;
        if (piece > 0) {
            existPiece = true;
        }

        int minPackPrice = Integer.MAX_VALUE;
        int minPiecePrice = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int packPrice = sc.nextInt();
            int piecePrice = sc.nextInt();

            if (packPrice < minPackPrice) {
                minPackPrice = packPrice;
            }

            if (piecePrice < minPiecePrice) {
                minPiecePrice = piecePrice;
            }
        }

        if (minPackPrice > minPiecePrice * 6) {
            ans = minPiecePrice * n;
        } else {
            ans = packNum * minPackPrice + piece * minPiecePrice;
            if (existPiece) {
                int tmp = (packNum + 1) * minPackPrice;
                if (tmp < ans) {
                    ans = tmp;
                }
            }
        }

        System.out.println(ans);
    }
}
