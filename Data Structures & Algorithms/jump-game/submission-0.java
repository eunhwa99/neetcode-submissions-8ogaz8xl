class Solution {
    public boolean canJump(int[] nums) {
         return dfs(nums, new Boolean[nums.length], 0);
    }

    boolean dfs(int[] nums, Boolean[] dp, int cur){
        if(cur>=nums.length-1) return true;
        if(dp[cur]!=null) return dp[cur];

        dp[cur] = false;
        for(int jump = nums[cur]; jump>=1; jump--){
            dp[cur] = dfs(nums, dp, cur+jump);
            if(dp[cur]) return true;
        }
        return dp[cur];
    }
}
