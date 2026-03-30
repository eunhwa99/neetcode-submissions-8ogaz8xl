class Solution {
           public int trap(int[] height) {
                     int left = 0, right = height.length-1;
                               int leftMax = height[left], rightMax = height[right];
                                         int res = 0;
                                                   while(left<right){
                                                               if(leftMax < rightMax){
                                                                               left++;
                                                                                               if(height[left] > leftMax) leftMax = height[left];
                                                                                                               res += (leftMax-height[left]);
                                                                                                                           }
                                                                                                                                       else{
                                                                                                                                                       right--;
                                                                                                                                                                       if(height[right] > rightMax) rightMax = height[right];
                                                                                                                                                                                       res+=(rightMax-height[right]);
                                                                                                                                                                                                   }
                                                                                                                                                                                                             }
                                                                                                                                                                                                                       return res;
                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                 }
