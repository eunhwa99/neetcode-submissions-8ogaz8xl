class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        int prev = 0;
        for(int i=0;i<nums.length;i++){
            res = Math.max(res, prev+nums[i]);
            if(prev + nums[i] <0) {
                prev = 0;
                continue;
            }
            prev = prev+nums[i];
        }

        return res;
    }
}
