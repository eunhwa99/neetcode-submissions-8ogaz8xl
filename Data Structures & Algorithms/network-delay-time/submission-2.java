class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {
    // 인접 리스트
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] t : times) {
      graph.computeIfAbsent(t[0], x -> new ArrayList<>()).add(new int[]{t[1], t[2]});
    }

    // dist 초기화
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{k, 0});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int node = cur[0], time = cur[1];

   

      for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
        int nextNode = next[0], nextTime = time + next[1];
        if (nextTime < dist[nextNode]) {
          dist[nextNode] = nextTime;
          pq.offer(new int[]{nextNode, nextTime});
        }
      }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        return -1;
      }
      ans = Math.max(ans, dist[i]);
    }
    return ans;
  }
}
                                                                                                                                                                                                                                                                                                                        
