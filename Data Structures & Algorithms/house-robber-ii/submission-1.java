class Solution {

  public int rob(int[] nums) {
    int[][] dp = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = dp[i][1] = -1;
    }


    return  dfs(dp, nums, 0, false);
  }

 int dfs(int[][] dp, int[] nums, int idx, boolean start) {
    if (idx >= nums.length) return 0;

    if (idx == nums.length - 1 && start) return 0;

    boolean nextStart = idx == 0 || start;

    if (start) {
        if (dp[idx][1] != -1) {
            return dp[idx][1];
        }

        dp[idx][1] = Math.max(
            dfs(dp, nums, idx + 1, start),
            dfs(dp, nums, idx + 2, nextStart) + nums[idx]
        );

        return dp[idx][1];
    } else {
        if (dp[idx][0] != -1) {
            return dp[idx][0]; // 여기 수정
        }

        dp[idx][0] = Math.max(
            dfs(dp, nums, idx + 1, start),
            dfs(dp, nums, idx + 2, nextStart) + nums[idx]
        );

        return dp[idx][0];
    }
}
}
