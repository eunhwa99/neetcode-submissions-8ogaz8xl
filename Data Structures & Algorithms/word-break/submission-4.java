 class Solution {
         public boolean wordBreak(String s, List<String> wordDict) {
                  int[] memo = new int[s.length()]; // 0: 미방문, 1: 실패, 2: 성공
                           return dfs(s, wordDict, 0, memo);
                                }
                                 
                                      boolean dfs(String s, List<String> wordDict, int idx, int[] memo) {
                                               if (idx >= s.length()) return true;
                                                        if (memo[idx] != 0) return memo[idx] == 2;
                                                         
                                                                  for (String w : wordDict) {
                                                                               if (idx + w.length() <= s.length() && s.startsWith(w, idx)) {
                                                                                                if (dfs(s, wordDict, idx + w.length(), memo)) {
                                                                                                                     memo[idx] = 2;
                                                                                                                                          return true;
                                                                                                                                                           }
                                                                                                                                                                        }
                                                                                                                                                                                 }
                                                                                                                                                                                  
                                                                                                                                                                                           memo[idx] = 1;
                                                                                                                                                                                                    return false;
                                                                                                                                                                                                         }
                                                                                                                                                                                                          }

 