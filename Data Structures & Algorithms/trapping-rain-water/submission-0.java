class Solution {
           public int trap(int[] height) {
                      if (height == null || height.length == 0) return 0;

                                 int n = height.length;
                                            int[] leftMax = new int[n];
                                                       int[] rightMax = new int[n];

                                                                  // 1. 왼쪽에서부터의 최대 높이 계산
                                                                             leftMax[0] = height[0];
                                                                                        for (int i = 1; i < n; i++) {
                                                                                                       leftMax[i] = Math.max(leftMax[i - 1], height[i]);
                                                                                                                  }

                                                                                                                             // 2. 오른쪽에서부터의 최대 높이 계산
                                                                                                                                        rightMax[n - 1] = height[n - 1];
                                                                                                                                                   for (int i = n - 2; i >= 0; i--) {
                                                                                                                                                                  rightMax[i] = Math.max(rightMax[i + 1], height[i]);
                                                                                                                                                                             }

                                                                                                                                                                                        // 3. 각 칸의 물의 양 계산: min(L, R) - 현재 높이
                                                                                                                                                                                                   int totalWater = 0;
                                                                                                                                                                                                              for (int i = 0; i < n; i++) {
                                                                                                                                                                                                                             totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                   return totalWater;
                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                             }
