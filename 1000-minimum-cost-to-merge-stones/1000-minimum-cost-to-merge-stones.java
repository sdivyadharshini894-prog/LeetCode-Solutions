


class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        // prefixSum[i] = sum of stones[0: i - 1]
        int[] prefixSum = buildPrefixSum(stones);

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // induction rule
            for (int j = i + k - 1; j < n; j++) {
                // step 1: try splitting [i: j] into 2 non-empty halves and do k-way merge separately
                // initialize dp[i][j] as picking p = i
                dp[i][j] = dp[i][i] + dp[i + 1][j];
                for (int p = i + (k - 1); p < j; p += k - 1) {
                    dp[i][j] = Math.min(
                        dp[i][j], dp[i][p] + dp[p + 1][j]
                    );
                }

                // step 2: merge the remaining stones after the individually merged 2 halves, if possible
                if ((j - i) % (k - 1) == 0) 
                    dp[i][j] += prefixSum[j + 1] - prefixSum[i];
            }
        }

        return dp[0][n - 1];
    }

    private int[] buildPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        return prefixSum;
    }
}