class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
    int idx=0;
    for(int num:nums){
      if(numMap.get(target-num)!=null){
        return new int[]{numMap.get(target-num), idx};
      }
      numMap.put(num, idx++);
    }
    return new int[2];
    }
}
