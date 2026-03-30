 class Solution {
         public int maxArea(int[] heights) {
                  int area = 0;
                           int l = 0, r = heights.length - 1;
                                    while (l < r) {
                                                 int currentArea = (r - l) * Math.min(heights[l], heights[r]);
                                                              area = Math.max(area, currentArea);
                                                                           if (heights[l] < heights[r]) l++;
                                                                                        else r--;
                                                                                                 }
                                                                                                          return area;
                                                                                                               }
                                                                                                                }

 
