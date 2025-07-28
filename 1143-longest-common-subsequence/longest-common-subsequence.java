class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the LCS length
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match, extend the previous subsequence
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters don't match, take the max LCS by ignoring one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Uncomment below to print the DP matrix
        /*
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        */

        // dp[m][n] contains the length of LCS for text1[0..m-1] and text2[0..n-1]
        return dp[m][n];
    }

//     public static void main(String[] args) {
//         Solution sol = new Solution();

//         // Example dry run
//         String text1 = "abcde";
//         String text2 = "ace";

//         int result = sol.longestCommonSubsequence(text1, text2);
//         System.out.println("Length of LCS: " + result);  // Output: 3
//     }
}
