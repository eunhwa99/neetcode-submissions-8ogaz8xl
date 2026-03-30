class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    List<Integer>[] arrList = new List[nums.length + 1];
    Map<Integer, Integer> numFreqMap = new HashMap<>();
    for (int num : nums) {
      numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
    }

    for (int num : numFreqMap.keySet()) {
      int value = numFreqMap.get(num);
      if (arrList[value] == null) {
        arrList[value] = new ArrayList<>();
      }
      arrList[value].add(num);
    }

    int cur = nums.length;
    int[] result = new int[k];
    int idx = 0;
    while (idx < k) {
      if (arrList[cur] != null) {

        for (int a : arrList[cur]) {
          result[idx++] = a;
        }

      }
      cur--;
    }
    return result;
  }
}
