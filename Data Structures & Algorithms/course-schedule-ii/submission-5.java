class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            ind[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (ind[i] == 0) {
                que.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            res[idx++] = cur;
            for (int next : adj.get(cur)) {
                ind[next]--;

                if (ind[next] == 0) {
                    que.offer(next);
                }
            }
        }

        return idx == numCourses?res:new int[0];
    }
}
