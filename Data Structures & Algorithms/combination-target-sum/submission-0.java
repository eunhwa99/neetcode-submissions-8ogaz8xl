class Solution {
        List<List<Integer>> res;

            public List<List<Integer>> combinationSum(int[] nums, int target) {
                    res = new ArrayList<>();
                            backtrack(0, target, 0, nums, new ArrayList<>());
                                    return res;
                                        }

                                            void backtrack(int sum, int target, int idx, int[] nums, List<Integer> tmp) {
                                                    if (sum == target) {
                                                                res.add(new ArrayList<>(tmp));
                                                                            return;
                                                                                    }
                                                                                            if (sum > target) return;

                                                                                                    for (int i = idx; i < nums.length; i++) {
                                                                                                                tmp.add(nums[i]);
                                                                                                                            backtrack(sum + nums[i], target, i, nums, tmp);
                                                                                                                                        tmp.removeLast();
                                                                                                                                                }
                                                                                                                                                    }
                                                                                                                                                    }

