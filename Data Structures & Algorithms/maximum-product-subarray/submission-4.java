class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = maxProduct;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0) {
                res = Math.max(0, res);
                maxProduct = 1;
                minProduct = 1;
                continue;
            }
            else if(nums[i]<0){
                int tmp = maxProduct;
                maxProduct = Math.max(minProduct*nums[i], nums[i]);
                minProduct = Math.min(tmp*nums[i], nums[i]);
            }
            else{
                maxProduct = Math.max(maxProduct*nums[i], nums[i]);
                minProduct = Math.min(minProduct*nums[i], nums[i]);
            }
            res = Math.max(maxProduct, res);
        }
        return res;
    }
}
