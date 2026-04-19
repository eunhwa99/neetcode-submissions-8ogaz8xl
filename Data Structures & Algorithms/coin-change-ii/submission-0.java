class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount+1];
        dp[0][0] = 1;

        for(int i=0;i<coins.length;i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] += (j-coins[i]>=0?dp[i][j-coins[i]]:0) + (i>=1?dp[i-1][j]:0); 
            }
        }

        return dp[coins.length-1][amount];
    }
}
