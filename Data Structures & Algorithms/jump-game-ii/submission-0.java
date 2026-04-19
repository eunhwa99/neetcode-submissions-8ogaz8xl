class Solution {
  public int jump(int[] nums) {
    Map<Integer, Integer> goals = new HashMap<>();
    // 2 4 1 1 1 1
    int goal = nums.length-1;
    goals.put(goal, 0);
    for(int i= nums.length-2;i>=0;i--){
      if(nums[i]+i >=goal){
        for(int j=nums[i]+i;j>=goal;j--){
          if(goals.containsKey(j)){
            int count = goals.get(j);
            int cur = goals.getOrDefault(i,Integer.MAX_VALUE);
            goals.put(i, Math.min(cur, count+1));
          }
        }
        goal = i;
      }
    }
    return goals.get(0);
  }
}
