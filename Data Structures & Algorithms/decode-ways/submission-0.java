class Solution {
         public int numDecodings(String s) {
                  int[] dp = new int[s.length()];
                           Arrays.fill(dp, -1);
                                    return dfs(s, dp, 0);
                                         }
                                          
                                               int dfs(String s, int[] dp, int idx) {
                                                        if (idx >= s.length()) return 1;
                                                                 if (dp[idx] != -1) return dp[idx];
                                                                          dp[idx] = 0;
                                                                                   if (s.charAt(idx) == '0') return 0;
                                                                                    
                                                                                             dp[idx] = dfs(s, dp, idx + 1);
                                                                                                      if (idx < s.length() - 1) {
                                                                                                                   int num = Integer.parseInt(s.substring(idx, idx + 2));
                                                                                                                                if (10 <= num && num <= 26) {
                                                                                                                                                 dp[idx] += dfs(s, dp, idx + 2);
                                                                                                                                                              }
                                                                                                                                                                       }
                                                                                                                                                                                return dp[idx];
                                                                                                                                                                                     }
                                                                                                                                                                                      }

