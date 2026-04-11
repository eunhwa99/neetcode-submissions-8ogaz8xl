class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        int maxPrev = dp[0];
        int ans = Math.max(dp[0], dp[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i] + maxPrev;
            maxPrev = Math.max(maxPrev, dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}