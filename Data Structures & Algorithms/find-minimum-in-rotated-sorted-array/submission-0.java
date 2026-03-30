class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int res = 1001;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1; 
            }
            else{
                right = mid - 1;
            }
             res = Math.min(nums[mid], res);
        }
        return res;
    }
}
