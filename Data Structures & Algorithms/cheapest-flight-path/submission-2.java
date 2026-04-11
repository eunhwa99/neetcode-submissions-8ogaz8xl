class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 1_000_000_000;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] next = dist.clone();

            for (int[] f : flights) {
                int from = f[0];
                int to = f[1];
                int price = f[2];

                if (dist[from] == INF) continue;

                next[to] = Math.min(next[to], dist[from] + price);
            }

            dist = next;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}