 class Solution {
         public int lengthOfLIS(int[] nums) {
                  int[] dp = new int[nums.length];
                           int answer = 0;
                                    for (int i = 0; i < nums.length; i++) {
                                                 answer = Math.max(answer, dfs(i, dp, nums));
                                                          }
                                                           
                                                                    return answer;
                                                                         }
                                                                          
                                                                               int dfs(int idx, int[] dp, int[] nums) {
                                                                                        if (dp[idx] > 0) return dp[idx];
                                                                                                 dp[idx] = 1;
                                                                                                          for (int i = idx + 1; i < nums.length; i++) {
                                                                                                                       if (nums[i] > nums[idx]) {
                                                                                                                                        dp[idx] = Math.max(dp[idx], dfs(i, dp, nums) + 1);
                                                                                                                                                     }
                                                                                                                                                              }
                                                                                                                                                               
                                                                                                                                                                        return dp[idx];
                                                                                                                                                                             }
                                                                                                                                                                              }


