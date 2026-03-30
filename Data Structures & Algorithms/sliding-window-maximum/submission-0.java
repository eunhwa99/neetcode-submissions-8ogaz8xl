class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(((a, b) -> b - a));
    int[] res = new int[(nums.length - k) + 1];
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
      queue.add(nums[i]);
      if (queue.size() == k) {
        res[idx++] = queue.peek();
        queue.remove(nums[i-k+1]);
      }
    }
    return res;
  }
}
