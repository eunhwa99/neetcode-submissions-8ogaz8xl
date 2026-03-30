 class Solution {
         public int search(int[] nums, int target) {
          
                   int left = 0, right = nums.length-1;
                            while(left <= right){
                                         int mid = left + (right-left)/2;
                                                      if(nums[mid]==target) return mid;
                                                                   if(nums[mid] < target){
                                                                                    if(nums[mid] < nums[right] && target > nums[right]){ 
                                                                                                         right = mid - 1;
                                                                                                                          }
                                                                                                                                           else{ // nums[mid] > nums[right] || target < nums[right]
                                                                                                                                                                left = mid + 1;
                                                                                                                                                                                 }
                                                                                                                                                                                              }
                                                                                                                                                                                                           else { // nums[mid] > target
                                                                                                                                                                                                                            if(nums[mid] >= nums[left] && target < nums[left]){ // target < nums[left] < nums[mid] 
                                                                                                                                                                                                                                                 left = mid + 1;
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                                   else{ // target < nums[mid] < nums[left] ||  nums[mid] > target > nums[left]
                                                                                                                                                                                                                                                                                                        right = mid - 1;
                                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                                                                                                               }
                                                                                                                                                                                                                                                                                                                                                        return -1;
                                                                                                                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                                                                                                                              }

 