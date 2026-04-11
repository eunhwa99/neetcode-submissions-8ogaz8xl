class Solution {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Queue<int[]> que = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
       adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < flights.length; i++) {
      adjList.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
    }

    int[][] visited = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        visited[i][j] = -1;
      }
    }
    que.offer(new int[]{src, 0, 0}); // k, cost
    visited[src][0] = 0;

    while (!que.isEmpty()) {
    int[] top = que.poll();
    int cur = top[0];
    int stop = top[1];
    int cost = top[2];

    if (cur == dst) return cost;
    if (stop > k) continue;
    
    if (visited[cur][stop] != -1 && visited[cur][stop] < cost) continue; // pop할 때 체크
    visited[cur][stop] = cost; // pop할 때 확정

    for (int[] adj : adjList.get(cur)) {
        int next = adj[0];
        int nextCost = adj[1] + cost;
        que.offer(new int[]{next, stop + 1, nextCost});
    }
    }

    return -1;

  }
}
