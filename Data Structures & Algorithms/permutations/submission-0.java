class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }

    void backtrack(int[] nums, List<Integer> perm, int cur){
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if ((cur & (1 << i)) == 0) {
                perm.add(nums[i]);
                backtrack(nums, perm, cur | (1 << i));
                perm.remove(perm.size() - 1);
            }
        }
    }
}
