import java.util.*;

class Solution {
    public int solution(String[][] relation) {
int n = relation.length;
		int m = relation[0].length;
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 1; i < 1 << m; i++) {
			Set<String> set = new HashSet<String>();

			for (int j = 0; j < n; j++) {
				String sb = new String();
				for (int k = 0; k < m; k++) {
					if ((i & (1 << k)) > 0) {
						sb += relation[j][k];
					}
				}
				set.add(sb);
			}
			if (set.size() == n && possible(ans, i)) {
				ans.add(i);
			}
		}
        
        
		return ans.size();
	}

	public static boolean possible(ArrayList<Integer> ans, int x) {
		for (int i = 0; i < ans.size(); i++) {
			if ((ans.get(i) & x) == ans.get(i)) {
				return false;

			}
		}
		return true;
	}
}