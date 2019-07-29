public class Solution {

    public static void main(String[] argv) {
        Q: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 1 && j == 1) {
                    continue Q;
                }
                System.out.println(i + " " + j);
            }
        }
    }

}
