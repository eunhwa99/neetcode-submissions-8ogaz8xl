 
  class Solution {
       public int longestConsecutive(int[] nums) {
                Set<Integer> numSet = new HashSet<>();
                 
                          for(int num:nums){
                                       numSet.add(num);
                                                }
                                                         
                                                                  int maxCount = 0;
                                                                           int length = 0;
                                                                                    int currentPointer = 0;
                                                                                             while(currentPointer<nums.length){
                                                                                                          if(!numSet.contains(nums[currentPointer]-1)){
                                                                                                                           length = 1;
                                                                                                                                            while(numSet.contains(nums[currentPointer]+length)){
                                                                                                                                                                 length++;
                                                                                                                                                                                  }
                                                                                                                                                                                                   maxCount = Math.max(maxCount,length);
                                                                                                                                                                                                                }
                                                                                                                                                                                                                             currentPointer++;
                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                               return maxCount;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                     