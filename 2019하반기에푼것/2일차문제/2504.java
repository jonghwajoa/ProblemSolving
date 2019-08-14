import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (!isValid(input)) {
            System.out.println(0);
            return;
        }
        final int MAX_DEPTH = 15; // 최대길이 30 /2
        int[] depth = new int[MAX_DEPTH + 1];
        int ans = 0;

        Stack<Character> stack = new Stack<>();
        int curDepth = 0;
        for (char c : input.toCharArray()) {
            int acc = 0;
            switch (c) {
            case '(':
            case '[':
                curDepth += 1;
                break;
            case ']':
                curDepth -= 1;
                if (depth[curDepth + 1] > 0) {
                    acc = depth[curDepth + 1] * 3;
                    depth[curDepth + 1] = 0;
                    depth[curDepth] += acc;
                } else {
                    depth[curDepth] += 3;
                }

                if (curDepth == 0) {
                    ans += depth[curDepth];
                    depth[curDepth] = 0;
                }
                break;
            case ')':
                curDepth -= 1;
                if (depth[curDepth + 1] > 0) {
                    acc = depth[curDepth + 1] * 2;
                    depth[curDepth + 1] = 0;
                    depth[curDepth] += acc;
                } else {
                    depth[curDepth] += 2;
                }

                if (curDepth == 0) {
                    ans += depth[curDepth];
                    depth[curDepth] = 0;
                }
                break;
            }
        }
        System.out.println(ans);
    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            switch (c) {
            case '(':
            case '[':
                stack.push(c);
                break;
            case ']':
                if (stack.size() <= 0 || stack.pop() != '[') {
                    return false;
                }
                break;
            case ')':
                if (stack.size() <= 0 || stack.pop() != '(') {
                    return false;
                }
                break;
            }
        }
        return stack.size() == 0;
    }
}