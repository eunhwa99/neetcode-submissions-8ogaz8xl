class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int idx, List<Integer> tmp){
        res.add(new ArrayList<>(tmp));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i-1]==nums[i]) continue;
            tmp.add(nums[i]);
            backtrack(nums, i+1, tmp);
            tmp.removeLast();
        }
    }
}
