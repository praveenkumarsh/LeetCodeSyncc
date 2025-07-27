import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] stores the smallest possible tail value of an increasing subsequence of length i+1
        int[] dp = new int[nums.length];
        int len = 0; // Current length of the Longest Increasing Subsequence

        for (int num : nums) {
            // Perform binary search in dp[0...len) for the current num
            int i = Arrays.binarySearch(dp, 0, len, num);

            // If not found, binarySearch returns -(insertion_point + 1)
            // Convert to insertion index
            if (i < 0) {
                i = -(i + 1);
            }

            // Place the current number in its correct position
            dp[i] = num;

            // If num extends the LIS, increase the length
            if (i == len) {
                len++;
            }

            // Print current state of dp array for dry run understanding
            // System.out.println("After num = " + num + ", dp = " + Arrays.toString(Arrays.copyOf(dp, len)));
        }

        return len;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
    //     int result = sol.lengthOfLIS(input);
    //     System.out.println("Length of LIS: " + result);
    // }

    /*
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;

            int[] dp = new int[nums.length]; // dp[i] = LIS ending at i
            Arrays.fill(dp, 1); // each number itself is a subsequence of length 1
            int maxlen = 1;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    // If nums[i] > nums[j], it can extend the LIS ending at j
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxlen = Math.max(maxlen, dp[i]);
                System.out.println("dp[" + i + "] = " + dp[i]);
            }

            return maxlen;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();
            int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
            int result = sol.lengthOfLIS(input);
            System.out.println("Length of LIS: " + result);
        }
    }

    */
}
