class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[][] dp = new int[nums.length][2];
        // dp[i][0]: product until i
        // dp[i][1]: product from i ~ nums.length-1
        // output[i] = dp[i-1][0] * dp[i+1][1]

        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int prev = i==0?1:dp[i-1][0];
            dp[i][0] = prev * nums[i];
            int next = i==0?1:dp[n-i][1];
            dp[n-i-1][1] = nums[n-i-1] * next;
        }

        for(int i=0;i<nums.length;i++){
            int prev = i==0?1:dp[i-1][0];
            int next = i==nums.length-1?1:dp[i+1][1];
            output[i] = prev * next;
        }
        return output;
    }
}  
