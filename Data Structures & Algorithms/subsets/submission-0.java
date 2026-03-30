class Solution {
         List<List<Integer>> res;
          
               public List<List<Integer>> subsets(int[] nums) {
                        res = new ArrayList<>();
                                 backtrack(nums, 0, new ArrayList<>());
                                          return res;
                                               }
                                                
                                                     void backtrack(int[] nums, int idx, List<Integer> tmp) {
                                                              if (idx >= nums.length) {
                                                                           List<Integer> list = new ArrayList<>(tmp);
                                                                                        if (res.contains(list)) return;
                                                                                                     res.add(list);
                                                                                                                  return;
                                                                                                                           }
                                                                                                                            
                                                                                                                                     tmp.add(nums[idx]);
                                                                                                                                              backtrack(nums, idx + 1, tmp);
                                                                                                                                                       tmp.removeLast();
                                                                                                                                                                backtrack(nums, idx + 1, tmp);
                                                                                                                                                                     }
                                                                                                                                                                      }

