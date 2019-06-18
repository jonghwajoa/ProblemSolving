public class Main {

    public static void main(String[] args) throws Exception {
        int[] input1 = { 1, 2, 4, 0, 3 };
        int[] input2 = { 1, 4, 5, 0, 3, 2 };
        int[] input3 = { 1, 2, 2, 0 };

        System.out.println(solve(input1));
        System.out.println(solve(input2));
        System.out.println(solve(input3));
    }

    public static boolean solve(int[] input) {

        int start = 0;
        int startValue = input[start];
        int nextIndex = input[start];
        boolean[] isVisit = new boolean[input.length];
        isVisit[start] = true;

        while (!isVisit[nextIndex]) {
            isVisit[nextIndex] = true;
            nextIndex = input[nextIndex];
            if (nextndex == startValue) {
                break;
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (!isVisit[i]) {
                return false;
            }
        }
        return true;
    }

}
