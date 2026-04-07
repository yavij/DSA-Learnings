class Solution {

    private List<List<String>> resultList;

    public Solution(){
        this.resultList = new ArrayList<>();
    }

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();

        // ✅ Build DP table
        boolean[][] dp = buildDP(s);

        // ✅ Start backtracking
        palindromeList(s, 0, path, dp);

        return resultList;
    }

    private void palindromeList(String s, int start, List<String> path, boolean[][] dp) {
        // ✅ Base case
        if (start == s.length()) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // ✅ Try all substrings from current index
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                // choose
                path.add(s.substring(start, end + 1));

                // explore
                palindromeList(s, end + 1, path, dp);

                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    // ✅ DP Precomputation
    private boolean[][] buildDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp;
    }
}