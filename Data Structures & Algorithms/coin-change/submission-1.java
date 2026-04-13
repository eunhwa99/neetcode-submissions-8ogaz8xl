 
  class Solution {
       public int coinChange(int[] coins, int amount) {
                if (coins.length == 0 && amount > 0) return -1;
                         int[] dp = new int[amount + 1];
                                  Arrays.fill(dp, amount + 1);
                                           dp[0] = 0;
                                            
                                                     for (int a = 1; a <= amount; a++) {
                                                                  for (int coin : coins) {
                                                                                   if (a - coin >= 0) {
                                                                                                        dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                                                                                                                         }
                                                                                                                                      }
                                                                                                                                               }
                                                                                                                                                
                                                                                                                                                         return dp[amount] == amount + 1 ? -1 : dp[amount];
                                                                                                                                                              }
                                                                                                                                                               
                                                                                                                                                                }
                                                                                                                                                                