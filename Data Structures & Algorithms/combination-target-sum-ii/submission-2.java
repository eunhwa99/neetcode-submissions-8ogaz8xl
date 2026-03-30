 class Solution {
         List<List<Integer>> res;
          
               public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                        res = new ArrayList<>();
                                 Arrays.sort(candidates);
                                          backtrack(target, 0, candidates, new ArrayList<>());
                                                   return res;
                                                        }
                                                         
                                                              void backtrack(int target, int idx, int[] candidates, List<Integer> tmp) {
                                                                       if (target == 0) {
                                                                                    res.add(new ArrayList<>(tmp));
                                                                                                 return;
                                                                                                          }
                                                                                                                   if (target < 0 || idx >= candidates.length) return;
                                                                                                                    
                                                                                                                             tmp.add(candidates[idx]);
                                                                                                                                      backtrack(target - candidates[idx], idx + 1, candidates, tmp);
                                                                                                                                               tmp.removeLast();
                                                                                                                                                
                                                                                                                                                         while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
                                                                                                                                                                      idx++;
                                                                                                                                                                               }
                                                                                                                                                                                
                                                                                                                                                                                         backtrack(target, idx + 1, candidates, tmp);
                                                                                                                                                                                              }
                                                                                                                                                                                               }

 