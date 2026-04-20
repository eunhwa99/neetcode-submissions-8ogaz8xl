class Solution {
          public int findTargetSumWays(int[] nums, int target) {
                    int total = 0;
                              for (int num : nums) {
                                            total += num;
                                                      }

                                                                if (Math.abs(target) > total) return 0;

                                                                          int offset = total;
                                                                                    int[][] dp = new int[nums.length][2 * total + 1];

                                                                                              dp[0][nums[0] + offset] += 1;
                                                                                                        dp[0][-nums[0] + offset] += 1;

                                                                                                                  for (int i = 1; i < nums.length; i++) {
                                                                                                                                for (int sum = -total; sum <= total; sum++) {
                                                                                                                                                  int count = dp[i - 1][sum + offset];
                                                                                                                                                                    if (count == 0) continue;

                                                                                                                                                                                      dp[i][sum + nums[i] + offset] += count;
                                                                                                                                                                                                        dp[i][sum - nums[i] + offset] += count;
                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                          return dp[nums.length - 1][target + offset];
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                  }
